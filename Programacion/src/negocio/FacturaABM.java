package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FacturaDao;
import datos.Factura;
import datos.ItemFactura;

public class FacturaABM {

	private static FacturaABM instancia;
	private FacturaDao dao = FacturaDao.getInstancia();
	
	protected FacturaABM() {}
	
	public static FacturaABM getInstancia() {
		if(instancia == null) {
			instancia = new FacturaABM();
		}
		return instancia;
	}
	
	public Factura traerFactura(int idFactura) {
		return dao.traerFactura(idFactura);
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
	
	//------------------------------------------------------------------------------------------------------------
	
	public ItemFactura traerItemFactura(int idItemFactura) {
		return dao.traerItemFactura(idItemFactura);
	}
	
	public ItemFactura traerItemFactura(String detalle) {
		return dao.traerItemFactura(detalle);
	}
	
	public int agregarItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, Factura factura) {
		return dao.agregarItemFactura(detalle, precioUnitario, cantidad, unidad, factura);
	}
	
	public List<ItemFactura> traerItemFacturaDeLaFactura(int idFactura){
		return dao.traerItemFacturaDeLaFactura(idFactura);
	}
	
}
