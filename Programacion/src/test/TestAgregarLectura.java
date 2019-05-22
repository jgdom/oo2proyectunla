package test;
import datos.Lectura;
import datos.LecturaAltaDemanda;
import datos.LecturaBajaDemanda;
import datos.Inspector;
import negocio.LecturaABM;
import negocio.InspectorABM;
import java.time.LocalDate;
import java.time.LocalTime;
public class TestAgregarLectura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InspectorABM abmi  = InspectorABM.getInstancia();
		LecturaABM abml = LecturaABM.getInstaciaABM();
		try {
		Inspector i = abmi.traerInspector(1);
		Inspector il = abmi.traerInspectorDni(1);
		System.out.println(il);
		System.out.println(i);
		
			Lectura l = new Lectura(LocalTime.now(),LocalDate.now(),i);
			System.out.println(abml.agregarLectura(l));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
