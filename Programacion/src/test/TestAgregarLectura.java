package test;
import datos.Lectura;
import datos.LecturaAltaDemanda;
import datos.LecturaBajaDemanda;
import datos.Inspector;
import datos.Medidor;
import negocio.MedidorABM;
import datos.PersonaFisica;
import negocio.LecturaABM;
import negocio.FacturaABM;
import negocio.Funciones;
import negocio.InspectorABM;
import java.time.LocalDate;
import java.time.LocalTime;
public class TestAgregarLectura {


	public static void main(String[] args) {
		
		MedidorABM medidorABM = MedidorABM.getInstancia();
	
		PersonaFisica PF =  new PersonaFisica();
		FacturaABM FABM = FacturaABM.getInstancia();
	
		/*
		try {
			
			LecturaBajaDemanda L1 = new LecturaBajaDemanda(Funciones.traerTiempo(17, 0, 0),
					Funciones.traerFecha(4,6,2019), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 100.0);

			LecturaBajaDemanda L2 = new LecturaBajaDemanda(Funciones.traerTiempo(18, 0, 0),
					Funciones.traerFecha(5, 8, 2019), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 75.0);
			System.out.println(LABM.traerLecturaYMedidor(1));
			System.out.println(LABM.agregarLectura(L1));
			System.out.println(LABM.agregarLectura(L2));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		// ----------------------------------------------------------------------

		// public double generarFactura(Medidor medidor, Cliente cliente, LocalDate
		// fecha, Lectura lecturaAnterior,
		// Lectura lecturaUltima)
	*/
		try {
			
			System.out.println("\n \n"+
					FABM.generarFactura(medidorABM.traerMedidor(PF.getDireccion()), Funciones.traerFecha(3, 9, 2019)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
