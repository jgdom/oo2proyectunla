package test.Tarifa;

import dao.HibernateUtil;
import negocio.TarifaABM;

public class TestTraerTarifaBajaConDetalles {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();
		
		try {
			System.out.println(TABM.traerTarifaBaja("T1 - R1").getListDetalleBaja());

			//System.out.println(TABM.traerTarifaBajaConDetalles("T1 - R1")); //no funciona, hay que verlo.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		HibernateUtil.getSessionFactory().close();
	}

}
