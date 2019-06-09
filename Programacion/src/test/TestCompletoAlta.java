package test;

import datos.DatosPersonales;
import datos.Inspector;
import datos.LecturaAltaDemanda;
import datos.LecturaBajaDemanda;
import datos.Medidor;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import datos.TarifaAlta;
import datos.TarifaBaja;
import datos.Zona;
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

public class TestCompletoAlta {

	public static void main(String[] args) {

		DatosPersonalesABM abm = DatosPersonalesABM.getInstancia();
		ClienteABM clienteABM = ClienteABM.getInstancia();
		InspectorABM inspectorABM = InspectorABM.getInstancia();
		ZonaABM zabm = ZonaABM.getInstacia();
		TarifaABM TABM = TarifaABM.getInstancia();
		MedidorABM medidorABM = MedidorABM.getInstancia();
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		LecturaABM LABM = LecturaABM.getInstaciaABM();
		FacturaABM FABM = FacturaABM.getInstancia();

		// ESTO SOLAMENTE ES PARA UN CLIENTE DE BAJA

		// ----------------------------------------------------------------------
		// Agregar TarifaBaja con sus detalles por las dudas

		try {
			TABM.agregarTarifaAlta("T2 - BT", "BT", 300);
			TABM.agregarTarifaAlta("T2 - MT", "MT", 300);
			TABM.agregarTarifaAlta("T2 - AT", "AT", 300);

			// DetalleBaja(String detalleConceptos,String unidad, int desde, int hasta,
			// double valor, TarifaBaja tarifaBaja)
			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", false, 3226.41, TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", false, 2.260, TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", false, 2.160, TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", false, 2.061, TABM.traerTarifaAlta("T2 - BT"));

			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", true, 3226.41, TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", true, 3.286, TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", true, 3.138, TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", true, 2.990, TABM.traerTarifaAlta("T2 - BT"));

			// ----------------------------------------------------------------------------------------------

			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", false, 3226.09, TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", false, 2.148, TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", false, 2.053, TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", false, 1.959, TABM.traerTarifaAlta("T2 - MT"));

			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", true, 3226.09, TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", true, 3.123, TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", true, 2.983, TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", true, 2.841, TABM.traerTarifaAlta("T2 - MT"));

			// ----------------------------------------------------------------------------------------------

			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", false, 3224.11, TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", false, 2.060, TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", false, 1.969, TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", false, 1.879, TABM.traerTarifaAlta("T2 - AT"));

			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", true, 3224.11, TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", true, 2.995, TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", true, 2.860, TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", true, 2.725, TABM.traerTarifaAlta("T2 - AT"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// --------------------------------------------------------------------- Agrego
		// Una persona Fisica
		DatosPersonales DP = new DatosPersonales("Quimey", "Perez", 41237009);
		PersonaJuridica PF = new PersonaJuridica("9 de basto 3000", "Sony", "20-40234234-1");
		try {
			System.out.println(abm.agregarDatosPersonales(DP));
			System.out.println(clienteABM.agregarPersonaJuridica(PF));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// ---------------------------------------------------------------------- Agrego
		// una Zona (Lanús)

		Zona z = new Zona("Lanús");
		try {
			System.out.println(zabm.agregarZona(z));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// --------------------------------------------------------------------- Agrego
		// inspector

		DatosPersonales DP2 = new DatosPersonales("Juan", "Domingez", 42347332);
		Inspector inspector1 = new Inspector(DP2, "20-42347332-1");
		try {
			System.out.println(abm.agregarDatosPersonales(DP2));
			System.out.println(inspectorABM.agregarInspector(inspector1));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// --------------------------------------------------------------------- Agrego
		// Intermedio
		// inspector has zonas

		try {
			inspectorABM.agregarInspectorEnZona(z, inspector1); // se hace despues de agregar los dos
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// ----------------------------------------------------------------------
		// Agregar Medidor de Cliente Quimey
		// Medidor(String direccion, Zona zona,Tarifa tarifa,Cliente cliente)

		try {
			TarifaAlta T = TABM.traerTarifaAlta("T2 - BT"); // Traigo una tarifa, en este caso por ser fisico
															// corresponde a
			// la baja

			// Medidor(String direccion, Zona zona,Tarifa tarifa,Cliente cliente)
			Medidor medidor1 = new Medidor(PF.getDireccion(), z, T, PF);
			System.out.println(medidorABM.agregarMedidor(medidor1));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// ----------------------------------------------------------------------
		// Agregar lectura de medidor
		// LecturaBajaDemanda(LocalTime hora, LocalDate fecha, Inspector inspector,
		// Medidor medidor,double energiaConsumida)

		try {
			LecturaAltaDemanda L1 = new LecturaAltaDemanda(Funciones.traerTiempo(15, 0, 0),
					Funciones.traerFecha("03/02/2019"), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 250, "BT", 7.0, 5.0, 12.0);
			
			LecturaAltaDemanda L2 = new LecturaAltaDemanda(Funciones.traerTiempo(15, 0, 0),
					Funciones.traerFecha("03/04/2019"), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 200, "BT", 10.0, 10.0, 10.0);


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

		try {
			System.out.println("\n \n" + FABM.generarFactura(medidorABM.traerMedidor(PF.getDireccion()),
					Funciones.traerFecha(3, 5, 2019)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
