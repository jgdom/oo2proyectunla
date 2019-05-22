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
	
	public Tarifa traerTarifa(String servicio) {
		return dao.traerTarifa(servicio);
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
	public int agregarTarifaAlta(String servicio, String tensionContratada, int limite) {
		TarifaAlta TA = new TarifaAlta(servicio,tensionContratada,limite);
		return dao.agregarTarifaAlta(TA);
	}
	
	public int agregarTarifaBaja(String servicio){
		TarifaBaja TB = new TarifaBaja(servicio);
		return dao.agregarTarifaBaja(TB);
	}
	
	public Tarifa traerTarifaBajaConDetalles(String servicio) {
		return dao.traerTarifaBajaConDetalles(servicio);
	}
	
	

}
