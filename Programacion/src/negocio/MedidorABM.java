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
	
	public Medidor traerMedidor(String medidor) {
		return dao.traerMedidor(medidor);
	}
	
	public Medidor traerMedidorYLecturas(long id) {
		return dao.traerMedidorYLecturas(id);
	}
	public List<Medidor> traerMedidor(){
		return dao.traerMedidor();
	}
	
	public void eliminarMedidor(Medidor m) throws Exception{
		if(traerMedidor(m.getDireccion())==null)throw new Exception("ERROR no se pudo eliminar");
		dao.eliminarMedidor(m);
	}
	
	public int agregarMedidor(Medidor m)throws Exception {
		if(traerMedidor(m.getDireccion())!=null)throw new  Exception("ERROR ya exite medidor");
		return dao.agregarMedidor(m);
	}

}
