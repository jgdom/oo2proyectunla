package test;

import datos.DatosPersonales;
import datos.LecturaAltaDemanda;
import datos.Medidor;
import datos.PersonaJuridica;
import datos.TarifaAlta;
import negocio.ClienteABM;
import negocio.DatosPersonalesABM;
import negocio.DetallesTarifaABM;
import negocio.FacturaABM;
import negocio.Funciones;
import negocio.InspectorABM;
import negocio.LecturaABM;
import negocio.MedidorABM;
import negocio.TarifaABM;
import negocio.ZonaABM;

public class TestAgregarPersonasJuridicasConFacturas {

	public static void main(String[] args) {
		
		DatosPersonalesABM abm = DatosPersonalesABM.getInstancia();
		ClienteABM clienteABM = ClienteABM.getInstancia();
		InspectorABM inspectorABM = InspectorABM.getInstancia();
		ZonaABM zabm = ZonaABM.getInstacia();
		TarifaABM TABM = TarifaABM.getInstancia();
		MedidorABM medidorABM = MedidorABM.getInstancia();
		LecturaABM LABM = LecturaABM.getInstaciaABM();
		FacturaABM FABM = FacturaABM.getInstancia();
		
		//---------------------------------------------------------------------------------
		DatosPersonales DP = new DatosPersonales("Alberto", "Fernandez", 30413564);
		PersonaJuridica PF = new PersonaJuridica("Julio 200", "Comcobo", "20-30413564-1");
		try {
			System.out.println(abm.agregarDatosPersonales(DP));
			System.out.println(clienteABM.agregarPersonaJuridica(PF));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			TarifaAlta T = TABM.traerTarifaAlta("T2 - MT"); // Traigo una tarifa, en este caso por ser fisico
															// corresponde a
			// la baja

			// Medidor(String direccion, Zona zona,Tarifa tarifa,Cliente cliente)
			Medidor medidor1 = new Medidor(PF.getDireccion(), zabm.traerZona("Lanús"), T, PF);
			System.out.println(medidorABM.agregarMedidor(medidor1));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			LecturaAltaDemanda L1 = new LecturaAltaDemanda(Funciones.traerTiempo(15, 0, 0),
					Funciones.traerFecha("03/02/2019"), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 250, "BT", 11.0, 2.0, 5.0);
			
			LecturaAltaDemanda L2 = new LecturaAltaDemanda(Funciones.traerTiempo(15, 0, 0),
					Funciones.traerFecha("03/04/2019"), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 200, "BT", 5.0, 30.0, 5.0);


			System.out.println(LABM.agregarLectura(L1));
			System.out.println(LABM.agregarLectura(L2));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\n \n" + FABM.generarFactura(medidorABM.traerMedidor(PF.getDireccion()),
					Funciones.traerFecha(3, 5, 2019)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		
		
		//---------------------------------------------------------------------------------
	}
	
}
