package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FacturaDao;
import datos.Factura;

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
	
	public void actualizar(Factura z) {
		dao.actualizar(z);
	}
	
	public void eliminaFactura(Factura l) {
		dao.eliminaFactura(l);
	}
	
	
	
}
