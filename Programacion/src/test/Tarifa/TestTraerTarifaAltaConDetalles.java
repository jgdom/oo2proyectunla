package test.Tarifa;

import java.util.List;

import dao.HibernateUtil;
import datos.DetalleAlta;
import datos.TarifaAlta;
import negocio.DetallesTarifaABM;
import negocio.TarifaABM;

public class TestTraerTarifaAltaConDetalles {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();
		DetallesTarifaABM DBABM = DetallesTarifaABM.getInstancia();
				
		try {
			TarifaAlta TA = TABM.traerTarifaAlta("T2 - MT");
			System.out.println(TA.toString());
			
			List<DetalleAlta> ListaDA = DBABM.TraerTodasLasDetalleAltaDeUnaTarifa(TA.getIdTarifa());
			
			for (DetalleAlta p : ListaDA)
				System.out.println("\n" + p);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		HibernateUtil.getSessionFactory().close();
	}

}
