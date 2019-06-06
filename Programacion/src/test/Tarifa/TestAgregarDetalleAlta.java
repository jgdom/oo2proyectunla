package test.Tarifa;

import dao.HibernateUtil;
import negocio.DetallesTarifaABM;
import negocio.TarifaABM;

public class TestAgregarDetalleAlta {

	public static void main(String[] args) {
		TarifaABM TABM = TarifaABM.getInstancia();
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();

		try {
			// DTABM.agregarDetalleAlta(detalleConceptos, unidad, superaLimite, valor, tarifaAlta)
			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", false, 3226.41, TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", false, 2.260,   TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", false, 2.160,  TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", false, 2.061,  TABM.traerTarifaAlta("T2 - BT"));
			
			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", true, 3226.41, TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", true, 3.286,   TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", true, 3.138,  TABM.traerTarifaAlta("T2 - BT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", true, 2.990,  TABM.traerTarifaAlta("T2 - BT"));
			
			//----------------------------------------------------------------------------------------------
			
			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", false, 3226.09, TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", false, 2.148,   TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", false, 2.053,  TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", false, 1.959,  TABM.traerTarifaAlta("T2 - MT"));
			
			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", true, 3226.09, TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", true, 3.123,   TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", true, 2.983,  TABM.traerTarifaAlta("T2 - MT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", true, 2.841,  TABM.traerTarifaAlta("T2 - MT"));
			
			//----------------------------------------------------------------------------------------------
			
			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", false, 3224.11, TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", false, 2.060,   TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", false, 1.969,  TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", false, 1.879,  TABM.traerTarifaAlta("T2 - AT"));
			
			DTABM.agregarDetalleAlta("Cargo Fijo", "$/mes", true, 3224.11, TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Pico", "$/kWh", true, 2.995,   TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Resto", "$/kWh", true, 2.860,  TABM.traerTarifaAlta("T2 - AT"));
			DTABM.agregarDetalleAlta("Cargo Valle", "$/kWh", true, 2.725,  TABM.traerTarifaAlta("T2 - AT"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		HibernateUtil.getSessionFactory().close();

	}

}
