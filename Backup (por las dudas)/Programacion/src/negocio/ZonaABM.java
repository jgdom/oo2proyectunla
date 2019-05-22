package negocio;
import datos.Inspector;
import datos.Zona;
import datos.Medidor;
import java.util.List;

import dao.ZonaDao;
public class ZonaABM {
	private static ZonaABM  instancia;
	private static ZonaDao dao = ZonaDao.getInstancia();
	
	protected ZonaABM() {
	}
	
	public static ZonaABM getInstacia() {
		if(instancia == null) {
			instancia = new ZonaABM();
		}
		return instancia;
	}
	
	public Zona traerZona(int idZona) {
		return dao.traerZona(idZona);
	}
	public Zona traerInspectoresYZonas(int idInspector) {
		return dao.traerZonaseInspector(idInspector);
	}
	public List<Zona> traerInspectores(){
		return dao.traerZonas();
	}
	public int agregarZona(Zona z) {
		return dao.agregarZona(z);
		
	}
	public void eliminarInspector(Zona z) {
		 dao.eliminarZona(z);
	}
	public boolean agregarInspectorEnZona(Zona z,Inspector i) {
		return dao.agregarZonaAInspector(z, i);
	}
	public boolean eliminarInspectorEnZona(Zona z,Inspector i) {
		return dao.eliminarInspectorenZona(z, i);
	}
	public boolean eliminarMedidorEnZona(Zona z,Medidor m) {
		return dao.eliminarMedidorEnZona(z, m);
	}
	
	public boolean agregarMedidorEnZona(Zona z,Medidor m) {
		return dao.agregarMedidorEnZona(z, m);
	}
}
