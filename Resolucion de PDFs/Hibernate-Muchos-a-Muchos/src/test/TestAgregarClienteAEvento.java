package test;

import dao.*;
import negocio.*;

public class TestAgregarClienteAEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ClienteABM c = ClienteABM.getInstancia();
			EventoABM e = EventoABM.getInstancia();
			e.agregar(e.traer((long)4), c.traerCliente(11111111));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
