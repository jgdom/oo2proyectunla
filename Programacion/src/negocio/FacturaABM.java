package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.FacturaDao;
import datos.Cliente;
import datos.DetalleAlta;
import datos.DetalleBaja;
import datos.Factura;
import datos.ItemFactura;
import datos.Lectura;
import datos.LecturaAltaDemanda;
import datos.LecturaBajaDemanda;
import datos.Medidor;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import datos.TarifaAlta;
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
	
	public List<Factura> traerFacturaConItemFactura(){
		return dao.traerFacturaConItemFactura();
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

	public Factura traerFactura(int nroSerieMedidor, LocalDate fecha) {
        Factura f =dao.traerFactura(nroSerieMedidor, fecha);
        return f;
    }
	
	public int agregarItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, Factura factura) {
		return dao.agregarItemFactura(detalle, precioUnitario, cantidad, unidad, factura);
	}

	public List<ItemFactura> traerItemFacturaDeLaFactura(int idFactura) {
		return dao.traerItemFacturaDeLaFactura(idFactura);
	}
	
	public Factura traerFacturaConItemFactura(int nroSerieMedidor, LocalDate fecha) {
        Factura f =dao.traerFacturaConItemFactura(nroSerieMedidor, fecha);
        return f;
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

	//-------------------------------------------------------------------------------------------------------------------
	//	 double energiaContratada; String tipoTension; double horaPico; double horaValle; double resto;
	public int obtenerConsumoDeLecturasAltaDemanda(LecturaAltaDemanda LAnterior, LecturaAltaDemanda LUltima) {
		
		int sumaAnterior = (int) (LAnterior.sumaDeConsumo());
		int sumaUltima = (int) (LUltima.sumaDeConsumo());
		
		return (sumaAnterior+sumaUltima);
	}
	
	public int obtenerConsumoLecturaAltaValorPico(LecturaAltaDemanda LAnterior, LecturaAltaDemanda LUltima) {
		int sumaAnterior = (int) (LAnterior.getHoraPico());
		int sumaUltima = (int) (LUltima.getHoraPico());
		
		return (sumaAnterior+sumaUltima);
	}
	
	public int obtenerConsumoLecturaAltaValorValle(LecturaAltaDemanda LAnterior, LecturaAltaDemanda LUltima) {
		
		int sumaAnterior = (int) LAnterior.getHoraValle();
		int sumaUltima = (int) LUltima.getHoraValle();
		
		return (sumaAnterior+sumaUltima);
	}
	
	public int obtenerConsumoLecturaAltaValorResto(LecturaAltaDemanda LAnterior, LecturaAltaDemanda LUltima) {
		
		int sumaAnterior = (int) LAnterior.getResto();
		int sumaUltima = (int) LUltima.getResto();
		
		return (sumaAnterior+sumaUltima);
	}
	
	public double obtenerValorFijoDeUnaTarifaAltaDelMedidor(Medidor medidor, LecturaAltaDemanda LA) {
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		TarifaABM TABM = TarifaABM.getInstancia();
		
		double valorCargoFijo = 0.0;
		
		TarifaAlta tarifa = TABM.traerTarifaAlta(medidor.getTarifa().getServicio());
		List<DetalleAlta> list = DTABM.TraerTodasLasDetalleAltaDeUnaTarifa(tarifa.getIdTarifa());
		
		for(DetalleAlta DA : list) {
			if(LA.getEnergiaContratada() < 300) {
				if (DA.getDetalleConceptos().equalsIgnoreCase("Cargo Fijo") && !DA.isSuperaLimite() )
					valorCargoFijo = DA.getValor();
			} else {
				if (DA.getDetalleConceptos().equalsIgnoreCase("Cargo Fijo") && DA.isSuperaLimite())
					valorCargoFijo = DA.getValor();
			}
				
		}
		
		return valorCargoFijo;
		
	}

	public double obtenerValorHoraPicoDeUnaTarifaAltaDelMedidor(Medidor medidor, LecturaAltaDemanda LA) {
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		TarifaABM TABM = TarifaABM.getInstancia();
		
		double valorCargoPico = 0.0;
		
		TarifaAlta tarifa = TABM.traerTarifaAlta(medidor.getTarifa().getServicio());
		List<DetalleAlta> list = DTABM.TraerTodasLasDetalleAltaDeUnaTarifa(tarifa.getIdTarifa());
		
		for(DetalleAlta DA : list) {
			if(LA.getEnergiaContratada() < 300) {
				if (DA.getDetalleConceptos().equalsIgnoreCase("Cargo Pico") && !DA.isSuperaLimite() )
					valorCargoPico = DA.getValor();
			} else {
				if (DA.getDetalleConceptos().equalsIgnoreCase("Cargo Pico") && DA.isSuperaLimite())
					valorCargoPico = DA.getValor();
			}
				
		}
		
		return valorCargoPico;
		
	}
	
	
	
	public double obtenerValorHoraValleDeUnaTarifaAltaDelMedidor(Medidor medidor, LecturaAltaDemanda LA) {
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		TarifaABM TABM = TarifaABM.getInstancia();
		
		double valorCargoValle = 0.0;
		
		TarifaAlta tarifa = TABM.traerTarifaAlta(medidor.getTarifa().getServicio());
		List<DetalleAlta> list = DTABM.TraerTodasLasDetalleAltaDeUnaTarifa(tarifa.getIdTarifa());
		
		for(DetalleAlta DA : list) {
			if(LA.getEnergiaContratada() < 300) {
				if (DA.getDetalleConceptos().equalsIgnoreCase("Cargo Valle") && !DA.isSuperaLimite() )
					valorCargoValle = DA.getValor();
			} else {
				if (DA.getDetalleConceptos().equalsIgnoreCase("Cargo Valle") && DA.isSuperaLimite())
					valorCargoValle = DA.getValor();
			}
				
		}
		
		return valorCargoValle;
		
	}
	
	public double obtenerValorRestoDeUnaTarifaAltaDelMedidor(Medidor medidor, LecturaAltaDemanda LA) {
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		TarifaABM TABM = TarifaABM.getInstancia();
		
		double valorResto = 0.0;
		
		TarifaAlta tarifa = TABM.traerTarifaAlta(medidor.getTarifa().getServicio());
		List<DetalleAlta> list = DTABM.TraerTodasLasDetalleAltaDeUnaTarifa(tarifa.getIdTarifa());
		
		for(DetalleAlta DA : list) {
			if(LA.getEnergiaContratada() < 300) {
				if (DA.getDetalleConceptos().equalsIgnoreCase("Cargo Resto") && !DA.isSuperaLimite() )
					valorResto = DA.getValor();
			} else {
				if (DA.getDetalleConceptos().equalsIgnoreCase("Cargo Resto") && DA.isSuperaLimite())
					valorResto = DA.getValor();
			}
				
		}
		
		return valorResto;
		
	}
	
	//Punto 6
	public Factura generarFactura(Medidor medidor, LocalDate fecha) {
		int id=0 ;
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
		
		//Hasta aca ya genere factura, falta agregarlo a la base de datos y despues meter sus items
		
		//Factura factura = this.traerFacturaConItemFactura((int) medidor.getNroSerie(), fecha);
		Factura factura = this.traerFactura((int) medidor.getNroSerie(), fecha);
		if( factura == null) {
			 factura = new Factura(Integer.valueOf(nroSerieMedidor), cliente.getIdCliente(), fecha, observacion);
			 id = this.agregarFactura(factura);
			// --------------------------------------------------------------------------------------------------
				// Todo esto hace el 5
			 if (TABM.traerTarifa(medidor.getTarifa().getIdTarifa()) instanceof TarifaBaja) { //Con esto me dice que las lecturas son de baja
					
					LecturaBajaDemanda lecturaAnt = (LecturaBajaDemanda) lecturaAnterior;
					LecturaBajaDemanda lecturaUlt = (LecturaBajaDemanda) lecturaUltima;

					int ConsumoLecturasTotal = this.obtenerConsumoDeLecturasBajaDemanda(lecturaAnt, lecturaUlt);
					
					//double valorCargoFijo = obtenerValorFijoDeUnaTarifaBajaDelMedidor(medidor);
					double valorCargoVariable = obtenerValorVariableDeUnaTarifaBajaDelMedidor(medidor);
					
					// --------------------------------------------------------------------------------------------------
					
					this.agregarItemFactura("Cargo Variable", valorCargoVariable, ConsumoLecturasTotal, "$KwH", this.traerFactura(id));
					
					factura = this.traerFacturaConItemFactura(id); 					// Actualizo para pedirle el calculoTotalAPagar()
					
					//CostoTotal = valorCargoFijo + factura.CalcularTotalAPagar();	//lo que tenes que cobrar
					
					
				} else {
					  LecturaAltaDemanda lecturaAnt = (LecturaAltaDemanda) lecturaAnterior;
					  LecturaAltaDemanda lecturaUlt = (LecturaAltaDemanda) lecturaUltima;
					  
					  //int consumoLecturaTotal = this.obtenerConsumoDeLecturasAltaDemanda(lecturaAnt, lecturaUlt);
					  
					  int consumoLecturaPico = this.obtenerConsumoLecturaAltaValorPico(lecturaAnt, lecturaUlt);
					  int consumoLecturaValle = this.obtenerConsumoLecturaAltaValorValle(lecturaAnt, lecturaUlt);
					  int consumoLecturaResto = this.obtenerConsumoLecturaAltaValorResto(lecturaAnt, lecturaUlt);
					  
					  double ValorCargoPico = this.obtenerValorHoraPicoDeUnaTarifaAltaDelMedidor(medidor, lecturaAnt);
					  double valorCargoValle = this.obtenerValorHoraValleDeUnaTarifaAltaDelMedidor(medidor, lecturaAnt);
					  double valorResto = this.obtenerValorRestoDeUnaTarifaAltaDelMedidor(medidor, lecturaAnt);
					  
					  this.agregarItemFactura("Cargo Pico", ValorCargoPico, consumoLecturaPico, "$KwH", this.traerFactura(id));
					  this.agregarItemFactura("Cargo Valle", valorCargoValle, consumoLecturaValle, "$KwH", this.traerFactura(id));
					  this.agregarItemFactura("Resto", valorResto, consumoLecturaResto, "$KwH", this.traerFactura(id));

					  factura = this.traerFacturaConItemFactura(id);
					  
					//CostoTotal = consumoLecturaTotal;	//lo que tenes que cobrar
				}
		}
				

		return factura;
	}

	public Factura generarFacturaWeb(Medidor medidor, LocalDate fecha) {
		int id=0 ;
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
		
		//Hasta aca ya genere factura, falta agregarlo a la base de datos y despues meter sus items
		
		Factura factura = this.traerFacturaConItemFactura((int) medidor.getNroSerie(), fecha);
		//Factura factura = this.traerFactura((int) medidor.getNroSerie(), fecha);
		if( factura == null) {
			 factura = new Factura(Integer.valueOf(nroSerieMedidor), cliente.getIdCliente(), fecha, observacion);
			 id = this.agregarFactura(factura);
			// --------------------------------------------------------------------------------------------------
				// Todo esto hace el 5
			 if (TABM.traerTarifa(medidor.getTarifa().getIdTarifa()) instanceof TarifaBaja) { //Con esto me dice que las lecturas son de baja
					
					LecturaBajaDemanda lecturaAnt = (LecturaBajaDemanda) lecturaAnterior;
					LecturaBajaDemanda lecturaUlt = (LecturaBajaDemanda) lecturaUltima;

					int ConsumoLecturasTotal = this.obtenerConsumoDeLecturasBajaDemanda(lecturaAnt, lecturaUlt);
					
					//double valorCargoFijo = obtenerValorFijoDeUnaTarifaBajaDelMedidor(medidor);
					double valorCargoVariable = obtenerValorVariableDeUnaTarifaBajaDelMedidor(medidor);
					
					// --------------------------------------------------------------------------------------------------
					
					this.agregarItemFactura("Cargo Variable", valorCargoVariable, ConsumoLecturasTotal, "$KwH", this.traerFactura(id));
					
					factura = this.traerFacturaConItemFactura(id); 					// Actualizo para pedirle el calculoTotalAPagar()
					
					//CostoTotal = valorCargoFijo + factura.CalcularTotalAPagar();	//lo que tenes que cobrar
					
					
				} else {
					  LecturaAltaDemanda lecturaAnt = (LecturaAltaDemanda) lecturaAnterior;
					  LecturaAltaDemanda lecturaUlt = (LecturaAltaDemanda) lecturaUltima;
					  
					  //int consumoLecturaTotal= this.obtenerConsumoDeLecturasAltaDemanda(lecturaAnt, lecturaUlt);
					  
					  int consumoLecturaPico = this.obtenerConsumoLecturaAltaValorPico(lecturaAnt, lecturaUlt);
					  int consumoLecturaValle = this.obtenerConsumoLecturaAltaValorValle(lecturaAnt, lecturaUlt);
					  int consumoLecturaResto = this.obtenerConsumoLecturaAltaValorResto(lecturaAnt, lecturaUlt);
					  
					  double ValorCargoPico = this.obtenerValorHoraPicoDeUnaTarifaAltaDelMedidor(medidor, lecturaAnt);
					  double valorCargoValle = this.obtenerValorHoraValleDeUnaTarifaAltaDelMedidor(medidor, lecturaAnt);
					  double valorResto = this.obtenerValorRestoDeUnaTarifaAltaDelMedidor(medidor, lecturaAnt);
					  
					  this.agregarItemFactura("Cargo Pico", ValorCargoPico, consumoLecturaPico, "$KwH", this.traerFactura(id));
					  this.agregarItemFactura("Cargo Valle", valorCargoValle, consumoLecturaValle, "$KwH", this.traerFactura(id));
					  this.agregarItemFactura("Resto", valorResto, consumoLecturaResto, "$KwH", this.traerFactura(id));

					  factura = this.traerFacturaConItemFactura(id);
					  
					//CostoTotal = consumoLecturaTotal;	//lo que tenes que cobrar
				}
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
			if (factura.getFecha().isAfter(FPrimera) && factura.getFecha().isBefore(FUltima)) { 
				//-------Fprimera(--------------Fecha--------------)Fultima----------
				
				factura = this.traerFacturaConItemFactura(factura.getIdFactura());
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
		List<Factura> lista = new ArrayList<Factura>();
		for (Factura f : this.traerFactura()) {
			if (f.getFecha().isAfter(fPrimera) && f.getFecha().isBefore(fUltima)) {
				Factura factura = this.traerFacturaConItemFactura(f.getIdFactura());
				lista.add(factura);
			}
		}
		return lista;
	}

	// energia total entregada entre fechas reporte 9
	public String energiaTotalEntregadaEntreFechas(LocalDate fPrimera, LocalDate fUltima) {
		int energiaTotal = 0;
		for (Factura f : this.traerFacturasEntreFechas(fPrimera, fUltima)) {
			for (ItemFactura i : f.getLstItemFactura()) {
					energiaTotal += i.getCantidad();
			}
		}
		return "La energia total entregada entre las fechas " + fPrimera + " y " + fUltima + " es:" + energiaTotal;
	}
	
	//11. Emitir reporte de los clientes con mayor consumo en horario pico (sólo los de gran demanda)
	
	public String reporteClienteMayorConsumoHoraPico() {
		double mayorConsumo = -9999999;
		ClienteABM C = ClienteABM.getInstancia();
		Cliente clienteMayorConsumoHoraPico = null;
		List<Factura> lista = new ArrayList<Factura>();
		
		lista = this.traerFacturaConItemFactura();
		
		for (Factura factura : lista) {
			
			for(ItemFactura item : factura.getLstItemFactura()) {
				
				if(item.getDetalle().equalsIgnoreCase("Cargo Pico") && item.getPrecioUnitario() > mayorConsumo){
					clienteMayorConsumoHoraPico = C.traerCliente(factura.getidCliente());
					mayorConsumo = item.getCantidad();
				}
				
			}
			
		}
		return "Reporte 11 \nCliente con mayor consumo es: "+clienteMayorConsumoHoraPico+ "\nCon un consumo de :"+mayorConsumo;
	}
	
	//reporte 13 consumo total por banda tarifaria
	public String ConsumoTotalPorBandaTarifariaEntreFechas(LocalDate fPrimera,LocalDate fUltima) {
		int consumoBaja = 0;
		int consumoAlta = 0;
		for(Factura f : this.traerFacturasEntreFechas(fPrimera, fUltima)) {
			for(ItemFactura i : f.getLstItemFactura()) {
				if(i.getDetalle().equalsIgnoreCase("baja")) {
					consumoBaja += i.getCantidad();
				}
				if(i.getDetalle().equalsIgnoreCase("alta")) {
					consumoAlta += i.getCantidad();
				}
			}
		}
		return "Entre las fechas " + Funciones.traerFechaCorta(fPrimera) + " y " + Funciones.traerFechaCorta(fUltima) + " los clientes de baja demanda consumieron: " + consumoBaja + " y los clientes de alta demanda consumieron:" + consumoAlta;
	}

}
