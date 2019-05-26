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
	
	//--------------------------------------------------
	
	public Tarifa traerTarifa(int id) {
		return dao.traerTarifa(id);
	}
	
	public TarifaAlta traerTarifaAlta(String servicio){
		Tarifa T = dao.traerTarifa(servicio); //Primero reviso que este
		//hacer verificaciones
		return dao.traerTarifaAlta(T.getIdTarifa()); // y si lo encuentra lo busca en su tabla correspondiente para mostrar
	}
	
	public TarifaBaja traerTarifaBaja(String servicio) {
		Tarifa T = dao.traerTarifa(servicio); //Primero reviso que este
		//hacer verificaciones
		return dao.traerTarifaBaja(T.getIdTarifa()); // y si lo encuentra lo busca en su tabla correspondiente para mostrar
	}

	public Tarifa traerTarifaBajaConDetalles(String servicio) {
		Tarifa T = dao.traerTarifa(servicio);
		//hacer verificaciones
		return dao.traerTarifaBajaConDetalles(T.getIdTarifa());
		
	}
	
	public Tarifa traerTarifaAltaConDetalles(String servicio) {
		Tarifa T = dao.traerTarifa(servicio);
		//hacer verificaciones
		return dao.traerTarifaAltaConDetalles(T.getIdTarifa());
	}
	
	public List<Tarifa> traerTarifas(){
		return dao.traerTarifas();
	}
	
	//--------------------------------------------------
	
	public int agregarTarifaAlta(String servicio, String tensionContratada, int limite)throws Exception {
		
		Tarifa TarifaNuevo = dao.traerTarifa(servicio);
		if (TarifaNuevo != null)
			throw new Exception("ERROR La tarifa ya existe-->" + TarifaNuevo.toString());
		return dao.agregarTarifaAlta(servicio,tensionContratada,limite);
	}
	
	public int agregarTarifaBaja(String servicio) throws Exception{
		
		Tarifa TarifaNuevo = dao.traerTarifa(servicio);
		if (TarifaNuevo != null) throw new Exception("ERROR La tarifa ya existe-->" + TarifaNuevo.toString());
		
		return dao.agregarTarifaBaja(servicio);
	}
	
	//--------------------------------------------------
	
	public void eliminarTarifa(Tarifa t) {
		dao.eliminarTarifa(t);
	}
	
	public void actualizarTarifa(Tarifa t) {
		dao.actualizar(t);
	}
	
	//Fijarse si es necesario el throws Exception 
	

	
	
	

}
