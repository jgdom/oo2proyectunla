package test.Tarifa;

import dao.HibernateUtil;
import negocio.DetallesTarifaABM;
import negocio.TarifaABM;

public class TestAgregarDetalleAlta {

	public static void main(String[] args) {
		TarifaABM TABM = TarifaABM.getInstancia();
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		
		try {
		    System.out.println( TABM.traerTarifaBaja("Alta"));
			DTABM.agregarDetalleAlta("hola", "$/mes", false, 3000, TABM.traerTarifaAlta("Alta"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		HibernateUtil.getSessionFactory().close();

	}

}
