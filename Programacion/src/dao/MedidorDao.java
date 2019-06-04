package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Medidor;


public class MedidorDao {
	private static MedidorDao instancia;
	private static Session session;
	private Transaction tx;
	
	protected MedidorDao() {}
	
	public static MedidorDao getInstancia() {
		if(instancia == null) {
			instancia = new MedidorDao();
		}
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos",he);
	}
	
	public Medidor traerMedidor(long idMedidor) {
		Medidor z = null;
		try {
			iniciaOperacion();
			z = (Medidor) session.get(Medidor.class, idMedidor);
			
		}
		finally {
			session.close();
		}
		return z;
	}
	
	public Medidor traerMedidor(String direccion) {
		Medidor z = null;
		try {
			iniciaOperacion();
			z = (Medidor) session.createQuery("from Medidor m where m.direccion= '"+direccion+"'").uniqueResult();
			
		}
		finally {
			session.close();
		}
		return z;
	}
	
	public Medidor traerMedidorYLecturasYTarifas(long id) {
		Medidor z = null;
		try {
			iniciaOperacion();
			z = (Medidor) session.createQuery("from Medidor m where m.nroSerie=" + id).uniqueResult();
			Hibernate.initialize(z.getLectura());
			Hibernate.initialize(z.getTarifa());
		}
		finally {
			session.close();
		}
		return z;
	}
	
	public Medidor traerMedidorYLecturas(long id) {
		Medidor z = null;
		try {
			iniciaOperacion();
			z = (Medidor) session.createQuery("from Medidor m where m.nroSerie=" + id).uniqueResult();
			Hibernate.initialize(z.getLectura());
		}
		finally {
			session.close();
		}
		return z;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Medidor> traerMedidor() throws HibernateException {
		List<Medidor> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from Medidor" ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
	
	
	public void eliminarMedidor(Medidor z)throws HibernateException{
		try {
			iniciaOperacion();
			session.delete(z);
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
	
	public int agregarMedidor(Medidor z) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(z).toString());
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
	
	
}
