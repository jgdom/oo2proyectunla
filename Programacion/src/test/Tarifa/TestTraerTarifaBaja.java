package test.Tarifa;

import dao.HibernateUtil;
import negocio.TarifaABM;

public class TestTraerTarifaBaja {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();
		
		try {
			System.out.println(TABM.traerTarifaBaja("Alta"));//si pones alguna que no este, te tirara NULL (HACER UNA EXCEPCION)
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		HibernateUtil.getSessionFactory().close();
	}

}
