package test.Tarifa;

import dao.HibernateUtil;
import negocio.TarifaABM;
import negocio.DetallesTarifaABM;

public class TestAgregarDetalleBaja {

	public static void main(String[] args) {

		TarifaABM TABM = TarifaABM.getInstancia();
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();

		try {
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

		HibernateUtil.getSessionFactory().close();
	}

}
