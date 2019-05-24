package negocio;

import datos.Lectura;
import dao.LecturaDao;

public class LecturaABM {

	private static LecturaABM instancia;
	private static LecturaDao dao = LecturaDao.getInstancia();
	protected LecturaABM() {}
	
	public static LecturaABM getInstaciaABM() {
		if(instancia == null) {
			instancia = new LecturaABM();
		}
		return instancia;

	}
	public Lectura traerLectura(int idLectura) {
		return dao.traerLecturaEInspector(idLectura);
	}
	public int  agregarLectura(Lectura l) {
		return dao.agregarLectura(l);
	}
	public void eliminarLectura(Lectura l) {
		 dao.eliminaLectura(l);
	}

}
