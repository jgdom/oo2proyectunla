package negocio;

import datos.Lectura;
import datos.Medidor;
import java.util.List;

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
	public Lectura traerLectura(long nroSerie,int mes) {
		return dao.traerLectura(nroSerie,mes);
	}
	public int  agregarLectura(Lectura l) throws Exception{
		if(traerLectura(l.getMedidor().getNroSerie(),l.getFecha().getMonthValue())!= null)throw new Exception("ERROR ya existe lectura");
		return dao.agregarLectura(l);
	}
	public void eliminarLectura(Lectura l) throws Exception{
		if(traerLectura(l.getMedidor().getNroSerie(),l.getFecha().getMonthValue())==null)throw new Exception("ERROR no se pudo eliminar lectura");
		 dao.eliminaLectura(l);
	}
	
	public Lectura traerLecturaEInspector(int idLectura) {
		return dao.traerLecturaEInspector(idLectura);
	}
	
	public List<Lectura> traerLecturaYMedidor(long idMedidor) {
		return dao.traerLecturasMedidor(idMedidor);
	}
	
	public Lectura traerLectura(Medidor medidor,int mes,int anio) {
		return dao.traerLectura(medidor, mes, anio);
	}

}
