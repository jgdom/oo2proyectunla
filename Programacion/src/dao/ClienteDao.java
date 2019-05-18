package dao;

import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaJuridica;
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
	
	public PersonaFisica traerPersonaFisica(int dni) {
		PersonaFisica f = null;
		try {
			iniciaOperacion();
			f = (PersonaFisica)session.createQuery("from PersonaFisica f inner join fetch f.dPersonales where f.dni=" + dni).uniqueResult();
		}
		finally {
			session.close();
		}
		return f;//no funciona
	}
	
	public PersonaJuridica traerPersonaJuridica(String cuit) {
		PersonaJuridica j = null;
		try {
			iniciaOperacion();
			j = (PersonaJuridica)session.createQuery("from PersonaJuridica j where j.cuit=" + cuit).uniqueResult();
		}
		finally {
			session.close();
		}
		return j;
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
	
	public int agregarPersonaFisica(PersonaFisica f) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(f).toString());
			
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
	
	public int agregarPersonaJuridica(PersonaJuridica j) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(j).toString());
			
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
	
	public void actualizarCliente(Cliente c)throws HibernateException{
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
