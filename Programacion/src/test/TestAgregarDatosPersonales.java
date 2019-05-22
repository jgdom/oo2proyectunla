package test;

import datos.DatosPersonales;
import negocio.DatosPersonalesABM;

public class TestAgregarDatosPersonales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatosPersonalesABM abm = DatosPersonalesABM.getInstancia();
		try {
			DatosPersonales p = new DatosPersonales("persona","uno",1);
			System.out.println("Ultimo id agregado -->" + abm.agregarDatosPersonales(p));
			DatosPersonales p2 = new DatosPersonales("persona","dos",2);
			System.out.println("Ultimo id agregado -->" + abm.agregarDatosPersonales(p2));
			DatosPersonales p3 = new DatosPersonales("persona","tres",3);
			System.out.println("Ultimo id agregado -->" + abm.agregarDatosPersonales(p3));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			DatosPersonales p1 = abm.traerDatosPersonalesPorDNI(1);
			System.out.println(p1);
			DatosPersonales p2 = abm.traerDatosPersonalesPorId(1);
			System.out.println(p2);
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
