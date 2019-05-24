package test.Tarifa;

import dao.HibernateUtil;
import negocio.TarifaABM;

public class TestAgregarTarifaAlta {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();
		
		try {
			TABM.agregarTarifaAlta("Alt2","MT",300);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		HibernateUtil.getSessionFactory().close();
		
	}

}
