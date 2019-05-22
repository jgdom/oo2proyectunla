package dao;

import datos.Inspector;
import datos.Zona;
import datos.Medidor;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ZonaDao {

	private static ZonaDao instancia;
	private static Session session;
	private Transaction tx;

	protected ZonaDao() {
	}

	public static ZonaDao getInstancia() {
		if (instancia == null) {
			instancia = new ZonaDao();
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

	public Zona traerZona(int idZona) {
		Zona z = null;
		try {
			iniciaOperacion();
			z = (Zona) session.get(Zona.class, idZona);

		} finally {
			session.close();
		}
		return z;
	}

	@SuppressWarnings("unchecked")
	public List<Zona> traerZonas() throws HibernateException {
		List<Zona> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from zona").list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Zona traerZonaseInspector(int idZona) throws HibernateException {
		Zona z = null;
		try {
			iniciaOperacion();
			String hql = "from Zona a where a.idZona =" + idZona;
			z = (Zona) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(z.getInspector());
		} finally {
			session.close();
		}
		return z;
	}

	public Zona traerZonasyMedidor(int idZona) throws HibernateException {
		Zona z = null;
		try {
			iniciaOperacion();
			String hql = "from Zona a where a.idZona =" + idZona;
			z = (Zona) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(z.getMedidor());
		} finally {
			session.close();
		}
		return z;
	}

	public void eliminarZona(Zona z) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(z);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public int agregarZona(Zona z) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(z).toString());
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Zona z) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(z);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public boolean agregarZonaAInspector(Zona z, Inspector i) {
		Zona zona = traerZonaseInspector(z.getIdZona());
		zona.agregarInspector(i);
		actualizar(zona);
		return true;
	}

	public boolean eliminarInspectorenZona(Zona z, Inspector i) {
		Zona zona = traerZonaseInspector(z.getIdZona());
		zona.eliminarInspector(i);
		actualizar(zona);
		return true;
	}

	public boolean agregarMedidorEnZona(Zona z, Medidor m) {
		Zona zona = traerZonasyMedidor(z.getIdZona());
		zona.agregarMedidor(m);
		actualizar(zona);
		return true;
	}

	public boolean eliminarMedidorEnZona(Zona z, Medidor m) {
		Zona zona = traerZonasyMedidor(z.getIdZona());
		zona.eliminarMedidor(m);
		actualizar(zona);
		return true;
	}
}
