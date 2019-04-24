package test;

import datos.Evento;
import dao.HibernateUtil;
import negocio.EventoABM;
import java.time.*;

public class TestAgregarEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EventoABM e = EventoABM.getInstancia();
			int id = e.agregar(new Evento("Concierto2",LocalDate.of(2019, 06, 20),LocalTime.of(22, 00, 00)));
			System.out.println(id);
			System.out.println(e.traer((long)4));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
