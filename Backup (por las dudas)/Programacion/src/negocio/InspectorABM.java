package negocio;

import java.util.List;

import dao.InspectorDao;
import datos.Inspector;
public class InspectorABM {
	private static InspectorABM  instancia;
	private InspectorDao dao = InspectorDao.getInstancia();
	protected InspectorABM() {}
	
	public static InspectorABM getInstancia(){
		if(instancia == null) {
			instancia = new InspectorABM();
		}
		return instancia;
	}
	public Inspector traerInspector(int idInspector) {
		return dao.traerInspector(idInspector);
	}
	public Inspector traerInspectoresYZonas(int idInspector) {
		return dao.traerInspectoresYZonas(idInspector);
	}
	public List<Inspector> traerInspectores(){
		return dao.traerZonas();
	}
	public int agregarInspector(Inspector i) {
		return dao.agregarInspector(i);
		
	}
	public void eliminarInspector(Inspector i) {
		 dao.eliminarInspecto(i);
	}
}
