package test;
import datos.Inspector;
import negocio.DatosPersonalesABM;
import negocio.InspectorABM;
import dao.HibernateUtil;
import dao.InspectorDao;
import datos.DatosPersonales;
public class agregarInspector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		private int idDatosPersonales;
		private String nombre;
		private String apellido;
	*/
		DatosPersonales dp = new DatosPersonales("Juan","Dominguez",12345678);
		
		try {
			DatosPersonalesABM dabm = DatosPersonalesABM.getInstancia();
			dabm.agregarDatosPersonales(dp);
			//InspectorABM iabm = InspectorABM.getInstancia();
		//	Inspector i = new Inspector(dp,"123123123123");
		//	iabm.agregarInspector(i);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			HibernateUtil.getSessionFactory();
		}
	}

}
