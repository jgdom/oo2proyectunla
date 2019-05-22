package test;
import datos.Zona;
import dao.HibernateUtil;
import negocio.ZonaABM;
public class AgregarZona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZonaABM zabm = ZonaABM.getInstacia();
		
		try {
			Zona z = new Zona("zona 1");
			zabm.agregarZona(z);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			HibernateUtil.getSessionFactory().close();
		}
		

	}

}
