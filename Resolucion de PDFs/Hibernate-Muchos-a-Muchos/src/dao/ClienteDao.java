package dao;

import java.util.List;

import org.hibernate.*;
import datos.Cliente;
import datos.Evento;

public class ClienteDao {
	
	private static ClienteDao instancia;
	private static Session session;
	private Transaction tx;
	
	protected ClienteDao() {}
	
	private void iniciaOperacion()throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he)throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos",he);
	}
	
	public static ClienteDao getInstancia() {
		if(instancia == null) {
			instancia = new ClienteDao();
		}
		return instancia;
	}
	
	public Cliente traerCliente(long idCliente)throws HibernateException{
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.get(Cliente.class, idCliente);
		}//session.get solo para clave primaria
		finally {
			session.close();
		}
		return c;
	}
	
	public Cliente traerCliente(int dni)throws HibernateException{
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		}
		finally {
			session.close();
		}
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traerCliente()throws HibernateException{
		List<Cliente> clientes = null;
		try {
			iniciaOperacion();
			clientes = session.createQuery("from Cliente c order by c.apellido asc,c.nombre asc").list();
		}
		finally {
			session.close();
		}
		return clientes;
	}
	
	public int agregar(Cliente c)throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(c).toString());
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
	
	public void actualizar(Cliente c)throws HibernateException{
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
	
	public void eliminar(Cliente c)throws HibernateException{
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
	
	public Cliente traerClienteYEventos(long idCliente)throws HibernateException{
		Cliente c = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente = " + idCliente;
			c = (Cliente)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(c.getEventos());
		}
		finally {
			session.close();
		}
		return c;
	}
	
	public boolean agregarEvento(Cliente cliente,Evento evento)throws HibernateException{
		Cliente c = traerClienteYEventos(cliente.getIdCliente());
		c.agregar(evento);
		actualizar(c);
		return true;
	}
	
	public boolean eliminarEvento(Cliente cliente,Evento evento)throws HibernateException{
		Cliente c = traerClienteYEventos(cliente.getIdCliente());
		c.eliminar(evento);
		actualizar(c);
		return true;
	}

}
