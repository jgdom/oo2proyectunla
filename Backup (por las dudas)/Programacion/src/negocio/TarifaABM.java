package negocio;

import java.util.List;

import dao.TarifaDao;
import datos.Tarifa;
import datos.TarifaAlta;
import datos.TarifaBaja;

public class TarifaABM {

	private static TarifaABM instancia;
	private TarifaDao dao = TarifaDao.getInstancia();
	
	protected TarifaABM() {}
	
	public static TarifaABM getInstancia() {
		if(instancia == null) {
			instancia = new TarifaABM();
		}
		return instancia;
	}
	
	public Tarifa traerTarifa(int id) {
		return dao.traerTarifa(id);
	}
	
	public List<Tarifa> traerTarifas(){
		return dao.traerTarifa();
	}
	
	public void eliminarTarifa(Tarifa t) {
		dao.eliminarTarifa(t);
	}
	
	public void actualizarTarifa(Tarifa t) {
		dao.actualizar(t);
	}
	
	//Fijarse si es necesario el throws Exception 
	public int agregarTarifaAlta(TarifaAlta TA ) {
		return dao.agregarTarifaAlta(TA);
	}
	
	public int agregarTarifaBaja(TarifaBaja TB ){
		return dao.agregarTarifaBaja(TB);
	}
	
	

}
