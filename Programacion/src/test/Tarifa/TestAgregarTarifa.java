package test;

import dao.HibernateUtil;
import datos.DatosPersonales;
import datos.Inspector;
import negocio.InspectorABM;
import negocio.TarifaABM;

public class TestAgregarTarifa {

	public static void main(String[] args) {
		
		TarifaABM TABM = TarifaABM.getInstancia();

		/*
		try {
			TABM.agregarTarifaBaja("ServicioBajo");	 //hacer exception por nombre (servicio) 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}


		*/
		

		
		try {

			//TABM.eliminarTarifa(TABM.traerTarifa(2));
			System.out.println(TABM.traerTarifaBajaConDetalles("ServicioBajo"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
		
		
		//--------------------------------------------------------------
		//--------------------------------------------------------------
		/*
		try {
			TABM.agregarTarifaAlta("ServicioAlto","MT",800);
			System.out.println(TABM.traerTarifa(2)); //hacer que me lo traiga por nombre
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			HibernateUtil.getSessionFactory().close();
		}
		*/

	}

}
