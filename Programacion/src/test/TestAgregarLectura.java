package test;
import datos.Lectura;
import datos.LecturaAltaDemanda;
import datos.LecturaBajaDemanda;
import datos.Inspector;
import datos.Medidor;
import negocio.MedidorABM;
import negocio.LecturaABM;
import negocio.InspectorABM;
import java.time.LocalDate;
import java.time.LocalTime;
public class TestAgregarLectura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InspectorABM abmi  = InspectorABM.getInstancia();
		LecturaABM abml = LecturaABM.getInstaciaABM();
		MedidorABM dao = MedidorABM.getInstancia();
		try {
			Inspector i = abmi.traerInspector(1);
			Inspector il = abmi.traerInspectorDni(1);
			Medidor m = dao.traerMedidor(1);
			System.out.println(m);
			System.out.println(il);
			System.out.println(i);
			Lectura l = new LecturaAltaDemanda(LocalTime.now(),LocalDate.now(),i,m,2.0,"alta",2.0,2.0,2.0);
			System.out.println(abml.agregarLectura(l));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Inspector i = abmi.traerInspector(1);
			Medidor m = dao.traerMedidor(1);
			System.out.println(i);
			System.out.println(m);
			Lectura l = new LecturaBajaDemanda(LocalTime.now(),LocalDate.now(),i,m,2.0);
			System.out.println(abml.agregarLectura(l));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
