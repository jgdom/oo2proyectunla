package test.Tarifa;

import dao.HibernateUtil;
import negocio.TarifaABM;

public class TestAgregarTarifaAlta {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();
		
		try {
			TABM.agregarTarifaAlta("T2 - R1","BT",300);
			TABM.agregarTarifaAlta("T2 - R2","MT",300);
			TABM.agregarTarifaAlta("T2 - R3","AT",300);
			TABM.agregarTarifaAlta("T2 - R4","BT",300);
			TABM.agregarTarifaAlta("T2 - R5","MT",300);
			TABM.agregarTarifaAlta("T2 - R6","AT",300);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		HibernateUtil.getSessionFactory().close();
		
	}

}
