package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FacturaDao;
import datos.Cliente;
import datos.DetalleBaja;
import datos.Factura;
import datos.ItemFactura;
import datos.Lectura;
import datos.LecturaAltaDemanda;
import datos.LecturaBajaDemanda;
import datos.Medidor;
import datos.TarifaBaja;
import datos.Lectura;

public class FacturaABM {

	private static FacturaABM instancia;
	private FacturaDao dao = FacturaDao.getInstancia();

	protected FacturaABM() {
	}

	public static FacturaABM getInstancia() {
		if (instancia == null) {
			instancia = new FacturaABM();
		}
		return instancia;
	}

	public Factura traerFactura(int idFactura) {
		return dao.traerFactura(idFactura);
	}

	public Factura traerFacturaConItemFactura(int idFactura) {
		return dao.traerFacturaConItemFactura(idFactura);
	}

	public List<Factura> traerFacturasDelCliente(int idCliente) {
		return dao.traerFacturasDelCliente(idCliente);
	}

	public List<Factura> traerFactura() {
		return dao.traerFactura();
	}

	public int agregarFactura(int nroSerieMedidor, int idCliente, LocalDate fecha, String observaciones) {
		return dao.agregarFactura(nroSerieMedidor, idCliente, fecha, observaciones);
	}

	public int agregarFactura(Factura z) {
		return dao.agregarFactura(z);
	}

	public void actualizarFactura(Factura z) {
		dao.actualizarFactura(z);
	}

	public void eliminaFactura(Factura l) {
		dao.eliminaFactura(l);
	}

	// ------------------------------------------------------------------------------------------------------------

	public ItemFactura traerItemFactura(int idItemFactura) {
		return dao.traerItemFactura(idItemFactura);
	}

	public ItemFactura traerItemFactura(String detalle) {
		return dao.traerItemFactura(detalle);
	}

	public int agregarItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, Factura factura) {
		return dao.agregarItemFactura(detalle, precioUnitario, cantidad, unidad, factura);
	}

	public List<ItemFactura> traerItemFacturaDeLaFactura(int idFactura) {
		return dao.traerItemFacturaDeLaFactura(idFactura);
	}

	// ------------------------------------------------------------------------------------------------------------

	
	//PUNTO 5
	public int obtenerConsumoDeLecturasBajaDemanda(LecturaBajaDemanda LA, LecturaBajaDemanda LU) {
		return (int) (LA.getEnergiaConsumida() + LU.getEnergiaConsumida());
	}
	
	public double obtenerValorFijoDeUnaTarifaBajaDelMedidor(Medidor medidor) {
		
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		TarifaABM TABM = TarifaABM.getInstancia();
		
		double valorCargoFijo = 0.0;
		//traigo la lista de detalles de baja demanda que le pertenece al medidor-----------------------------
		TarifaBaja tarifa = TABM.traerTarifaBaja(medidor.getTarifa().getServicio());
		List<DetalleBaja> listDetalleBaja = DTABM.TraerTodasLasDetalleBajaDeUnaTarifa(tarifa.getIdTarifa());

		//traigo el cargo variable y el cargo fijo
		for (DetalleBaja DB : listDetalleBaja) {
			if (DB.getDetalleConceptos().equalsIgnoreCase("Cargo Fijo"))
				valorCargoFijo = DB.getValor();
		}
		//--------------------------------------------------------------------------------------------------------
		return valorCargoFijo;
	}
	
	public double obtenerValorVariableDeUnaTarifaBajaDelMedidor(Medidor medidor) {
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		TarifaABM TABM = TarifaABM.getInstancia();
		
		double valorCargoVariable = 0.0;
		//traigo la lista de detalles de baja demanda que le pertenece al medidor-----------------------------
		TarifaBaja tarifa = TABM.traerTarifaBaja(medidor.getTarifa().getServicio());
		List<DetalleBaja> listDetalleBaja = DTABM.TraerTodasLasDetalleBajaDeUnaTarifa(tarifa.getIdTarifa());

		//traigo el cargo variable y el cargo fijo
		for (DetalleBaja DB : listDetalleBaja) {
			if (DB.getDetalleConceptos().equalsIgnoreCase("Cargo Variable"))
				valorCargoVariable = DB.getValor();
		}
		//--------------------------------------------------------------------------------------------------------
		return valorCargoVariable;
	}

	
	//Punto 6
	public Factura generarFactura(Medidor medidor, LocalDate fecha) {

		TarifaABM TABM = TarifaABM.getInstancia();
		MedidorABM MABM = MedidorABM.getInstancia();
		LecturaABM LABM = LecturaABM.getInstaciaABM();
		//double CostoTotal = 0;	
		
		medidor = MABM.traerMedidorYLecturasYTarifas(medidor.getNroSerie()); // Por las dudas pido todo de nuevo
		Cliente cliente = medidor.getCliente(); // me agarro el cliente del medidor

		// si la fecha de la factura es del mes 5, entonces las lecturas seran el 2 y el 4
		Lectura lecturaAnterior = LABM.traerLecturaAnteriorDelMedidorDeLaFactura(medidor,fecha);
		Lectura lecturaUltima = LABM.traerLecturaUltimaDelMedidorDeLaFactura(medidor,fecha);
		
		// falta las otras variables para la tarifa y lectura ALTA---------------------------------------------

		String observacion = "desde : " + lecturaAnterior.getFecha() + "\nhasta : " + lecturaUltima.getFecha();
		String nroSerieMedidor = "" + medidor.getNroSerie();
		Factura factura = new Factura(Integer.valueOf(nroSerieMedidor), cliente.getIdCliente(), fecha, observacion);
		//Hasta aca ya genere factura, falta agregarlo a la base de datos y despues meter sus items
		
		int id = this.agregarFactura(factura);

		// --------------------------------------------------------------------------------------------------
		// Todo esto hace el 5
		
		if (TABM.traerTarifa(medidor.getTarifa().getIdTarifa()) instanceof TarifaBaja) { //Con esto me dice que las lecturas son de baja
																							
			LecturaBajaDemanda lecturaAnt = (LecturaBajaDemanda) lecturaAnterior;
			LecturaBajaDemanda lecturaUlt = (LecturaBajaDemanda) lecturaUltima;

			int ConsumoLecturasTotal = this.obtenerConsumoDeLecturasBajaDemanda(lecturaAnt, lecturaUlt);
			double valorCargoFijo = obtenerValorFijoDeUnaTarifaBajaDelMedidor(medidor);
			double valorCargoVariable = obtenerValorVariableDeUnaTarifaBajaDelMedidor(medidor);
			
			// --------------------------------------------------------------------------------------------------
			
			this.agregarItemFactura("Baja", valorCargoVariable, ConsumoLecturasTotal, "$KwH", this.traerFactura(id));
			
			factura = this.traerFacturaConItemFactura(id); 					// Actualizo para pedirle el calculoTotalAPagar()
			
			//CostoTotal = valorCargoFijo + factura.CalcularTotalAPagar();	
			
			
		} else {
			  //LecturaAltaDemanda lecturaAnt = (LecturaAltaDemanda) lecturaAnterior;
			  //LecturaAltaDemanda lecturaUlt = (LecturaAltaDemanda) lecturaUltima;
		}

		return factura;
	}


	// -----------------------------------------------------------------------------------------------------------
	// 7 Emitir reporte de consumos por cliente entre fechas
	public String reporteEntreFechasConsumoCliente(Cliente cliente, LocalDate FPrimera, LocalDate FUltima) {
		String reporte;
		int consumo = 0;
		List<Factura> listaFacturaDeCliente = this.traerFacturasDelCliente(cliente.getIdCliente()); // traigo todas las
																									// facturas del
																									// cliente

		for (Factura factura : listaFacturaDeCliente) { // recorre todas las facturas del cliente
			if (factura.getFecha().isAfter(FPrimera) && factura.getFecha().isBefore(FUltima)) { // miro sus fechas si
																								// corresponden a los
																								// limites
				for (ItemFactura Ifactura : factura.getLstItemFactura()) { // y si corresponde entro en su lista de item
																			// factura para sacar el consumo
					consumo = consumo + Ifactura.getCantidad(); // con eso sumo los consumos
				}

			}
		}

		reporte = "El cliente : " + cliente.getIdCliente() + " \nEntre las fechas " + FPrimera + " y " + FUltima
				+ "\n Consumio en total : " + consumo;

		return reporte;
	}

	// facturas emitidas entre fechas reporte 8
	@SuppressWarnings("null")
	public List<Factura> traerFacturasEntreFechas(LocalDate fPrimera, LocalDate fUltima) {
		List<Factura> lista = null;
		for (Factura f : this.traerFactura()) {
			if (f.getFecha().isAfter(fPrimera) && f.getFecha().isBefore(fUltima)) {
				lista.add(f);
			}
		}
		return lista;
	}

	// energia total entregada entre fechas reporte 9
	// energia de consumo total baja
	public int energiaTotalEntregadaBajaEntreFechas(LocalDate fPrimera, LocalDate fUltima) {
		int energiaTotalBaja = 0;
		for (Factura f : this.traerFactura()) {
			if (f.getFecha().isAfter(fPrimera) && f.getFecha().isBefore(fUltima)) {
				for (ItemFactura i : f.getLstItemFactura()) {
					energiaTotalBaja += i.getCantidad();
				}
			}
		}
		return energiaTotalBaja;
	}

	// energia de consumo total alta
	public int energiaTotalEntregadaAltaEntreFechas(LocalDate fPrimera, LocalDate fUltima) {
		int energiaTotalAlta = 0;
		return energiaTotalAlta;
	}

	// energia total
	public String reporteEnergiaEntregada(LocalDate fPrimera, LocalDate fUltima) {
		int total = this.energiaTotalEntregadaBajaEntreFechas(fPrimera, fUltima)
				+ this.energiaTotalEntregadaAltaEntreFechas(fPrimera, fUltima);
		return "La energia total entregada es: " + total + "entre las fechas " + Funciones.traerFechaCorta(fPrimera)
				+ " y " + Funciones.traerFechaCorta(fUltima);
	}

}
