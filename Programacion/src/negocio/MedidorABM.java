package negocio;

import datos.Medidor;

import java.util.List;

import dao.MedidorDao;

public class MedidorABM {
	
	private MedidorDao dao = MedidorDao.getInstancia();
	private static MedidorABM instancia;
	
	protected MedidorABM() {}
	
	public static MedidorABM getInstancia() {
		if(instancia == null) {
			instancia = new MedidorABM();
		}
		return instancia;
	}
	
	public Medidor traerMedidor(long id) {
		return dao.traerMedidor(id);
	}
	
	public List<Medidor> traerMedidor(){
		return dao.traerMedidor();
	}
	
	public void eliminarMedidor(Medidor m) {
		dao.eliminarMedidor(m);
	}
	
	public int agregarMedidor(Medidor m) {
		return dao.agregarMedidor(m);
	}

}
