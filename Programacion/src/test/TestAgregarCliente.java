package test;

//import negocio.ClienteABM;
//import negocio.DatosPersonalesABM;
//import datos.Cliente;
//import datos.DatosPersonales;
//import datos.PersonaFisica;
//import datos.PersonaJuridica;
import dao.HibernateUtil;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ClienteABM abmc = ClienteABM.getInstancia();
		//DatosPersonalesABM abmd = DatosPersonalesABM.getInstancia();
		try {
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
