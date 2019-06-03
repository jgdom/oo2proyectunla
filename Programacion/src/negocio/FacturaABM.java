package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FacturaDao;
import datos.Cliente;
import datos.Factura;
import datos.ItemFactura;
import datos.Lectura;
import datos.Medidor;

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

	public int generarFactura(Medidor medidor, Cliente cliente, LocalDate fecha, Lectura lecturaAnterior,
			Lectura lecturaUltima) {

		String observacion = "de : " + lecturaAnterior.toString() + " \n hasta :" + lecturaUltima.toString();
		String nroSerieMedidor = "" + medidor.getNroSerie();
		Factura factura = new Factura(Integer.valueOf(nroSerieMedidor), cliente.getIdCliente(), fecha.plusMonths(1),
				observacion);

		/*
		 * En BAJA 1) consumo = 50+55 == 105 2) fijarse que TARIFA le corresponde (105)
		 * para obtener el VALOR cargo fijo y el cargo variables
		 * 
		 * 3) total consumo = cargo fijo.VALOR + (consumo * cargo variable.VALOR) total
		 * consumo = 32,82 + (105 * 2.653)
		 */

		return 1;
	}
	// traerCliente(dni)

	// -----------------------------------------------------------------------------------------------------------
	//7 Emitir reporte de consumos por cliente entre fechas
	public String reporteEntreFechasConsumoCliente(Cliente cliente, LocalDate FPrimera, LocalDate FUltima) {
		String reporte;
		int consumo = 0;
		List<Factura> listaFacturaDeCliente = this.traerFacturasDelCliente(cliente.getIdCliente()); //traigo todas las facturas del cliente

		for (Factura factura : listaFacturaDeCliente) {			//recorre todas las facturas del cliente
			if (factura.getFecha().isAfter(FPrimera) && factura.getFecha().isBefore(FUltima)) {	//miro sus fechas si corresponden a los limites
				for (ItemFactura Ifactura : factura.getLstItemFactura()) {		//y si corresponde entro en su lista de item factura para sacar el consumo
					consumo = consumo + Ifactura.getCantidad();				// con eso sumo los consumos
				}

			}
		}

		reporte = "El cliente : " + cliente.getIdCliente() + " \nEntre las fechas " + FPrimera + " y " + FUltima
				+ "\n Consumio en total : " + consumo;

		return reporte;
	}

}
