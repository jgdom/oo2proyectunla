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
	
	public Tarifa traerTarifa(int idTarifa) {
		Tarifa z = null;
		try {
			iniciaOperacion();
			z = (Tarifa) session.get(Tarifa.class, idTarifa);

		} finally {
			session.close();
		}
		return z;
	}
	
	public Tarifa traerTarifa(String servicio) {
		Tarifa z = null;
		try {
			iniciaOperacion();
			z = (Tarifa) session.createQuery("from Tarifa t where t.servicio = "+servicio);

		} finally {
			session.close();
		}
		return z;
	}
	
	public Tarifa traerTarifaBajaConDetalles(String servicio) {
		TarifaBaja z = null;
		try {
			iniciaOperacion();
													//LO TOMA JAVA 
			z = (TarifaBaja) session.createQuery("from TarifaBaja t where t.servicio = '' + servicio + ''").uniqueResult();
			Hibernate.initialize(z.getListDetalleBaja());
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
	
	public int agregarTarifaAlta(TarifaAlta t) {
		int id = 0;
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
	
	public int agregarTarifaBaja(TarifaBaja t) {
		int id = 0;
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
