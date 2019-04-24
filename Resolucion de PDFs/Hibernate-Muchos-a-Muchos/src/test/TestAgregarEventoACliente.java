package test;

import dao.HibernateUtil;
import negocio.*;

public class TestAgregarEventoACliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ClienteABM c = ClienteABM.getInstancia();
			EventoABM e = EventoABM.getInstancia();
			c.agregarEvento(c.traerCliente(11111111), e.traer((long)3));
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
