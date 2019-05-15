package dao;

import datos.Cliente;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
	
	private static ClienteDao instancia;
	private static Session session;
	private Transaction tx;
	
	protected ClienteDao() {}
	
	public static ClienteDao getInstancia() {
		if(instancia == null) {
			instancia = new ClienteDao();
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
	
	public Cliente traerCliente(int idCliente) {
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.get(Cliente.class, idCliente);
			
		}
		finally {
			session.close();
		}
		return c;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Cliente> traerClientes() throws HibernateException {
		List<Cliente> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from Cliente" ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
	
	public Cliente traerClienteYMedidor(int idCliente)throws HibernateException{
		Cliente c = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente =" + idCliente;
			c = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(c.getMedidor());
		}
		finally {
			session.close();
		}
		return c;
	}
	
	public void eliminarCliente(Cliente c)throws HibernateException{
		try {
			iniciaOperacion();
			session.delete(c);
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
	
	public int agregarCliente(Cliente c) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(c).toString());
			
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
