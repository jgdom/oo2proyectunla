package test;

import datos.*;
import negocio.*;

public class TestAgregarPersonaFisica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ClienteABM abmc = ClienteABM.getInstancia();
		DatosPersonalesABM abm = DatosPersonalesABM.getInstancia();
		DatosPersonales DP = new DatosPersonales("Quimey", "Perez", 44);
		PersonaFisica PF = new PersonaFisica("9 de basto 3000", DP);
		try {
			System.out.println(abm.agregarDatosPersonales(DP));
			System.out.println(abmc.agregarPersonaFisica(PF));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		 */
		InspectorABM inspectorABM = InspectorABM.getInstancia();
		MedidorABM medidorABM = MedidorABM.getInstancia();
		LecturaABM LABM = LecturaABM.getInstaciaABM();
		ClienteABM clienteABM = ClienteABM.getInstancia();
		PersonaFisica PF = new PersonaFisica();
		FacturaABM FABM = FacturaABM.getInstancia();
		try {
			LecturaBajaDemanda L1 = new LecturaBajaDemanda(Funciones.traerTiempo(15, 0, 0),
					Funciones.traerFecha("03/06/2019"), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 100.0);

			LecturaBajaDemanda L2 = new LecturaBajaDemanda(Funciones.traerTiempo(15, 0, 0),
					Funciones.traerFecha(3, 8, 2019), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 75.0);

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

		

	}

}
