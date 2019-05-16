package test;
import datos.Zona;
import dao.HibernateUtil;
import negocio.ZonaABM;
public class AgregarZona {

	public static void main(String[] args) {
		ZonaABM zabm = ZonaABM.getInstacia();
		Zona z = new Zona("hola 2");
		try {
			zabm.agregarZona(z);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			HibernateUtil.getSessionFactory().close();
		}
		// TODO Auto-generated method stub

	}

}
