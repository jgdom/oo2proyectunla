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
		/*
		private int idDatosPersonales;
		private String nombre;
		private String apellido;
	*/
//		DatosPersonalesABM dabm = DatosPersonalesABM.getInstancia();
//		DatosPersonales dp = new DatosPersonales("Juan","Dominguez",12345678);
//		dabm.agregarDatosPersonales(dp);
//		dp = dabm.traerDatosPersonales(6);
		
		try {
			
			//dabm.agregarDatosPersonales(dp);
			InspectorABM iabm = InspectorABM.getInstancia();
			Inspector i = new Inspector("123123123123");
			System.out.println(i);
			
			Inspector ins = iabm.traerInspector(iabm.agregarInspector(i));
			System.out.println(ins.getIdInspector());
			DatosPersonalesABM dabm = DatosPersonalesABM.getInstancia();
			DatosPersonales dp=new DatosPersonales("Juan","Dominguez",12345678,ins);
			dabm.agregarDatosPersonales(dp);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
	}

}
