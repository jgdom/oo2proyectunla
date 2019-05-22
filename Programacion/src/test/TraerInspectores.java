package test;

import negocio.InspectorABM;
import negocio.ZonaABM;
import dao.HibernateUtil;
import datos.Inspector;
import datos.Zona;
public class TraerInspectores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		ZonaABM zabm = ZonaABM.getInstacia();
		InspectorABM iabm = InspectorABM.getInstancia();
		Inspector i = iabm.traerInspectorDni(1);
		Zona z = zabm.traerZona(1);
		System.out.println(i);
		System.out.println(z);
		
		iabm.agregarInspectorEnZona(z,i);
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
