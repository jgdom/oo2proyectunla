package test.Tarifa;

import dao.HibernateUtil;
import negocio.TarifaABM;

public class TraerTodasLasTarifasSinDetalles {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();
		
		try {
			System.out.println(TABM.traerTarifas());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		HibernateUtil.getSessionFactory().close();

	}

}
