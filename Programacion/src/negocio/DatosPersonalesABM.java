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
	
	public DatosPersonales traerDatosPersonales(int idDatosPersonales) {
		return dao.traerDatosPersonales(idDatosPersonales);
	}
	
	public int agregarDatosPersonales(DatosPersonales d) {
		return dao.agregarDatosPersonales(d);
	}

}
