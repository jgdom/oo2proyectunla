package test;

import java.time.LocalDate;
import java.time.LocalTime;

import dao.TarifaDao;
import datos.Cliente;
import datos.DatosPersonales;
import datos.Factura;
import datos.Inspector;
import datos.Lectura;
import datos.LecturaBajaDemanda;
import datos.Medidor;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import datos.Tarifa;
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

public class TestCompleto {

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
			TABM.agregarTarifaBaja("T1 - R1");
			TABM.agregarTarifaBaja("T1 - R2");
			TABM.agregarTarifaBaja("T1 - R3");
			TABM.agregarTarifaBaja("T1 - R4");
			TABM.agregarTarifaBaja("T1 - R5");
			TABM.agregarTarifaBaja("T1 - R6");
			TABM.agregarTarifaBaja("T1 - R7");
			TABM.agregarTarifaBaja("T1 - R8");
			TABM.agregarTarifaBaja("T1 - R9");

			// DetalleBaja(String detalleConceptos,String unidad, int desde, int hasta,
			// double valor, TarifaBaja tarifaBaja)
			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 0, 150, 32.82, TABM.traerTarifaBaja("T1 - R1"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 0, 150, 2.653, TABM.traerTarifaBaja("T1 - R1"));

			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 151, 325, 56.11, TABM.traerTarifaBaja("T1 - R2"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 151, 325, 2.651, TABM.traerTarifaBaja("T1 - R2"));

			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 326, 400, 91.73, TABM.traerTarifaBaja("T1 - R3"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 326, 400, 2.705, TABM.traerTarifaBaja("T1 - R3"));

			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 401, 450, 107.34, TABM.traerTarifaBaja("T1 - R4"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 401, 450, 2.785, TABM.traerTarifaBaja("T1 - R4"));

			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 451, 500, 161.66, TABM.traerTarifaBaja("T1 - R5"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 451, 500, 2.864, TABM.traerTarifaBaja("T1 - R5"));

			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 501, 600, 316.00, TABM.traerTarifaBaja("T1 - R6"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 501, 600, 2.918, TABM.traerTarifaBaja("T1 - R6"));

			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 601, 700, 850.24, TABM.traerTarifaBaja("T1 - R7"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 601, 700, 3.309, TABM.traerTarifaBaja("T1 - R7"));

			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 701, 1400, 1203.64, TABM.traerTarifaBaja("T1 - R8"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 701, 1400, 3.411, TABM.traerTarifaBaja("T1 - R8"));

			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 1401, 9999, 1442.88, TABM.traerTarifaBaja("T1 - R9"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 1401, 9999, 3.437, TABM.traerTarifaBaja("T1 - R9"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// --------------------------------------------------------------------- Agrego
		// Una persona Fisica
		DatosPersonales DP = new DatosPersonales("Quimey", "Perez", 41237009);
		PersonaFisica PF = new PersonaFisica("9 de basto 3000", DP);
		try {
			System.out.println(abm.agregarDatosPersonales(DP));
			System.out.println(clienteABM.agregarPersonaFisica(PF));
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
			TarifaBaja T = TABM.traerTarifaBaja("T1 - R1"); // Traigo una tarifa, en este caso por ser fisico corresponde a
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
			LecturaBajaDemanda L1 = new LecturaBajaDemanda(Funciones.traerTiempo(15, 0, 0),
					Funciones.traerFecha("03/02/2019"), inspectorABM.traerInspectorDni(42347332),
					medidorABM.traerMedidor(PF.getDireccion()), 100.0);

			LecturaBajaDemanda L2 = new LecturaBajaDemanda(Funciones.traerTiempo(15, 0, 0),
					Funciones.traerFecha(3, 4, 2019), inspectorABM.traerInspectorDni(42347332),
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

		try {
			System.out.println(FABM.generarFactura(medidorABM.traerMedidor(PF.getDireccion()),
					clienteABM.traerPersonaFisica(41237009), Funciones.traerFecha(3, 5, 2019),
					LABM.traerLectura(medidorABM.traerMedidor(PF.getDireccion()).getNroSerie(), 02),
					LABM.traerLectura(medidorABM.traerMedidor(PF.getDireccion()).getNroSerie(), 04)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
