package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Tarifa;
import datos.TarifaAlta;
import datos.TarifaBaja;


public class TarifaDao {

	private static TarifaDao instancia;
	private static Session session;
	private Transaction tx;
	
	protected TarifaDao() {}
	
	public static TarifaDao getInstancia() {
		if (instancia == null) {
			instancia = new TarifaDao();
		}
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	//-------------------------------------------------------
	
	public Tarifa traerTarifa(int idTarifa) {
		Tarifa z = null;
		try {
			iniciaOperacion();
			z = (Tarifa) (Tarifa) session.get(Tarifa.class, idTarifa);

		} finally {
			session.close();
		}
		return z;
	}
	
	//usar este metodo al principio de todo ABMTarifa
	public Tarifa traerTarifa(String servicio) {
		Tarifa z = null;
		try {
			iniciaOperacion();
			z = (Tarifa) session.createQuery("from Tarifa t where t.servicio = '"+servicio+"'").uniqueResult();
			
		} finally {	
			session.close();
		}
		return z;
	}
		
	public TarifaBaja traerTarifaBaja(int idTarifa) {
		TarifaBaja z = null;
		try {
			iniciaOperacion();
			z = (TarifaBaja) session.get(TarifaBaja.class, idTarifa);
		} finally {
			session.close();
		}
		return z;
	}
	
	public TarifaAlta traerTarifaAlta(int idTarifa) {
		TarifaAlta z = null;
		try {
			iniciaOperacion();
			z = (TarifaAlta) session.get(TarifaAlta.class, idTarifa);
		} finally {
			session.close();
		}
		return z;
	}
	
	public TarifaBaja traerTarifaBajaConDetalles(int idTarifa) {
		TarifaBaja z = null;
		try {
			iniciaOperacion();
													//LO TOMA JAVA 
			z = (TarifaBaja) session.get(TarifaBaja.class, idTarifa);
			Hibernate.initialize(z.getListDetalleBaja());
		} finally {
			session.close();
		}
		return z;
	}
	
	public TarifaAlta traerTarifaAltaConDetalles(int idTarifa) {
		TarifaAlta z = null;
		try {
			iniciaOperacion();
													//LO TOMA JAVA 
			z = (TarifaAlta) session.get(TarifaAlta.class, idTarifa);
			Hibernate.initialize(z.getListDetalleAlta());
		} finally {
			session.close();
		}
		return z;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarifa> traerTarifa() throws HibernateException {
		List<Tarifa> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Tarifa").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	
	//------------------------------------------------------
	
	public int agregarTarifaBaja(String servicio) {
		int id = 0;
		TarifaBaja t = new TarifaBaja(servicio);
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(t).toString());
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public int agregarTarifaAlta(String servicio,String tensionContratada, int limite) {
		int id = 0;
		TarifaAlta t = new TarifaAlta(servicio, tensionContratada, limite);
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(t).toString());
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	//------------------------------------------------------
	
	public void eliminarTarifa(Tarifa t) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(t);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void actualizar(Tarifa t) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(t);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	
	
	
}
