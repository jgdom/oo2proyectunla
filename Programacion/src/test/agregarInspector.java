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
		DatosPersonalesABM dabm = DatosPersonalesABM.getInstancia();
		DatosPersonales dp = dabm.traerDatosPersonales(1);
		
		try {
			
			//dabm.agregarDatosPersonales(dp);
			InspectorABM iabm = InspectorABM.getInstancia();
			Inspector i = new Inspector(dp,"123123123123");
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
