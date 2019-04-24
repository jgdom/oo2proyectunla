package test;

import datos.Cliente;
import negocio.ClienteABM;
import dao.HibernateUtil;
import java.time.*;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ClienteABM c = ClienteABM.getInstancia();
			int id = c.agregar(new Cliente("Cliente","Dos",22222222,LocalDate.of(1995, 01, 01)));
			System.out.println("Ultimo id agregado----> " + id);
			System.out.println(c.traerCliente(11111111));
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
