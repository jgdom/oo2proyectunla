package test.Tarifa;

import dao.HibernateUtil;
import negocio.TarifaABM;

public class TestAgregarTarifaBaja {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();
		
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//Tirara Error porque ya existe
		try {
			TABM.agregarTarifaBaja("T1 - R9");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		HibernateUtil.getSessionFactory().close();

	}

}
