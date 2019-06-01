package dao;


import datos.Cliente;
import datos.DatosPersonales;
//import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatosPersonalesDao {
	
	private static DatosPersonalesDao instancia;
	private static Session session;
	private Transaction tx;
	
	protected DatosPersonalesDao() {}
	
	public static DatosPersonalesDao getInstancia() {
		if(instancia == null) {
			instancia = new DatosPersonalesDao();
		}
		return instancia;
	}
	
	private void iniciaOperacion()throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he)throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos",he);
	}
	
	public DatosPersonales traerDatosPersonalesPorId(int idDatosPersonales) {
		DatosPersonales d = null;
		try {
			iniciaOperacion();
			d = (DatosPersonales)session.get(DatosPersonales.class, idDatosPersonales);
			
		}
		finally {
			session.close();
		}
		return d;
	}
	public DatosPersonales traerDatosPersonalesPorDNi(int dni) {
		DatosPersonales d = null;
		try {
			iniciaOperacion();
			d = (DatosPersonales)session.createQuery("from DatosPersonales p where p.dni=" + dni).uniqueResult();
			
		}
		finally {
			session.close();
		}
		return d;
	}
	
	public int agregarDatosPersonales(DatosPersonales d) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(d).toString());
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return id;
	}
	public void actualizarCliente(DatosPersonales c)throws HibernateException{
		try {
			iniciaOperacion();
			session.update(c);
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}

}
