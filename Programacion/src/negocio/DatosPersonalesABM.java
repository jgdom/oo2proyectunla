package negocio;

import datos.DatosPersonales;
import dao.DatosPersonalesDao;

public class DatosPersonalesABM {
	
	private static DatosPersonalesABM instancia;
	private DatosPersonalesDao dao = DatosPersonalesDao.getInstancia();
	
	protected DatosPersonalesABM() {}
	
	public static DatosPersonalesABM getInstancia() {
		if(instancia == null) {
			instancia = new DatosPersonalesABM();
		}
		return instancia;
	}
	
	public DatosPersonales traerDatosPersonalesPorId(int idDatosPersonales) {
		return dao.traerDatosPersonalesPorId(idDatosPersonales);
	}
	
	public DatosPersonales traerDatosPersonalesPorDNI(int dni) {
		return dao.traerDatosPersonalesPorDNi(dni);
	}
	
	public int agregarDatosPersonales(DatosPersonales d)throws Exception {
		if(traerDatosPersonalesPorDNI(d.getDni()) != null)throw new Exception("ERROR ya existen datos con dni = " + d.getDni());
		return dao.agregarDatosPersonales(d);
	}
	public void actualizar(DatosPersonales p) {
		dao.actualizarCliente(p);
	}
	
	public void eliminarDatosPersonales(DatosPersonales d) {
		dao.eliminarDatosPersonales(d);
	}

}
