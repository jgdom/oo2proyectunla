package test;

import negocio.InspectorABM;
import negocio.ZonaABM;
import dao.HibernateUtil;
import datos.Zona;
public class TraerInspectores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		ZonaABM zabm = ZonaABM.getInstacia();
		InspectorABM iabm = InspectorABM.getInstancia();
		System.out.println(zabm.traerZona(4));
		System.out.println(iabm.traerInspector(9));
		zabm.agregarInspectorEnZona(zabm.traerZona((int)1), iabm.traerInspector(1));
		System.out.println("OK");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
		
	}

}
