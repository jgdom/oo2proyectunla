package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DetalleAlta;
import datos.DetalleBaja;
import datos.Tarifa;
import datos.TarifaAlta;
import datos.TarifaBaja;

import java.util.List;

public class DetallesTarifaDao {

	private static DetallesTarifaDao instancia;
	private static Session session;
	private Transaction tx;
	
	protected DetallesTarifaDao() {}
	
	public static DetallesTarifaDao getInstancia() {
		if (instancia == null) {
			instancia = new DetallesTarifaDao();
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

	public DetalleBaja TraerDetalleBaja(int id) {
		DetalleBaja z = null;
		try {
			iniciaOperacion();
			z = (DetalleBaja) session.get(DetalleBaja.class, id);

		} finally {
			session.close();
		}
		return z;
	}
	
	public DetalleAlta TraerDetalleAlta(int id) {
		DetalleAlta z = null;
		try {
			iniciaOperacion();
			z = (DetalleAlta) session.get(DetalleAlta.class, id);

		} finally {
			session.close();
		}
		return z;
	}

	@SuppressWarnings("unchecked")
	public List<DetalleBaja> TraerTodasLasDetalleBaja(){
		List<DetalleBaja> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from DetalleBaja").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<DetalleAlta> TraerTodasLasDetalleAlta(){
		List<DetalleAlta> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from DetalleAlta").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	//------------------------------------------------------------------
	public int agregarDetalleBaja(String detalleConceptos,String unidad, int desde, int hasta, double valor, TarifaBaja tarifaBaja) {
		
		int id = 0;
		DetalleBaja t = new DetalleBaja(detalleConceptos, unidad, desde,hasta,valor,tarifaBaja );
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
	
	public int agregarDetalleAlta(String detalleConceptos, String unidad, boolean superaLimite, double valor, TarifaAlta tarifaAlta) {
		
		int id = 0;
		DetalleAlta t = new DetalleAlta(detalleConceptos, unidad, superaLimite,valor,tarifaAlta );
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
	
	//------------------------------------------------------------------
	
	public void eliminarDetalleBaja(DetalleBaja t) throws HibernateException {
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
	
	public void eliminarDetalleAlta(DetalleAlta t) throws HibernateException {
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
	
	public void actualizarDetalleBaja(DetalleBaja t) throws HibernateException {
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
	
	public void actualizarDetalleAlta(DetalleAlta t) throws HibernateException {
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
