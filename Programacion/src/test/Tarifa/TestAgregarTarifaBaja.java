package test.Tarifa;

import dao.HibernateUtil;
import negocio.TarifaABM;

public class TestAgregarTarifaBaja {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();
		
		try {
			TABM.agregarTarifaBaja("Baja2");	 //hacer exception por nombre (servicio) 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		

		HibernateUtil.getSessionFactory().close();

	}

}
