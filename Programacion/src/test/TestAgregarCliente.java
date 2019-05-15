package test;

import negocio.ClienteABM;
import negocio.DatosPersonalesABM;
import datos.Cliente;
import datos.DatosPersonales;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import dao.HibernateUtil;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abmc = ClienteABM.getInstancia();
		DatosPersonalesABM abmd = DatosPersonalesABM.getInstancia();
		
		try {
			Cliente cl = new PersonaFisica("calle falsa 123");
			int id = abmc.agregarCliente(cl);
			PersonaFisica per = (PersonaFisica) abmc.traerCliente(id);
			DatosPersonales dp = new DatosPersonales("Juan","Dominguez",12345678,per);
			abmd.agregarDatosPersonales(dp);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
