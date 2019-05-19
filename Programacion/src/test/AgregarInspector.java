package test;
import datos.Inspector;
import negocio.DatosPersonalesABM;
import negocio.InspectorABM;
import dao.HibernateUtil;
import dao.InspectorDao;
import datos.DatosPersonales;
public class AgregarInspector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatosPersonalesABM dabm = DatosPersonalesABM.getInstancia();
	
		try {
		DatosPersonales d = dabm.traerDatosPersonalesPorDNI(112233);
		//dabm.agregarDatosPersonales(dp);
		InspectorABM iabm = InspectorABM.getInstancia();
		Inspector i = new Inspector(d,"123123123123");
		System.out.println(i.getdPersonales().getIdDatosPersonales());
		iabm.agregarInspector(i);

		}catch(Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally {
		HibernateUtil.getSessionFactory().close();
		}
		}
}

