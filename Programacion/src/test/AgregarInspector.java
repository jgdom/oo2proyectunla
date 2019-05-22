package test;
import datos.Inspector;
import negocio.DatosPersonalesABM;
import negocio.InspectorABM;
import datos.DatosPersonales;

public class AgregarInspector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatosPersonalesABM dabm = DatosPersonalesABM.getInstancia();
	
		try {
			DatosPersonales d = dabm.traerDatosPersonalesPorDNI(1);
			InspectorABM iabm = InspectorABM.getInstancia();
			Inspector i = new Inspector(d,"1");
			System.out.println(i.getdPersonales().getIdDatosPersonales());
			iabm.agregarInspector(i);

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}

