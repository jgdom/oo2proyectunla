package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Factura;
import datos.ItemFactura;

public class FacturaDao {

	private static FacturaDao instancia;
	private static Session session;
	private Transaction tx;

	protected FacturaDao() {
	}

	public static FacturaDao getInstancia() {
		if (instancia == null) {
			instancia = new FacturaDao();
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

	public Factura traerFactura(int idFactura) {
		Factura z = null;
		try {
			iniciaOperacion();
			z = (Factura) session.get(Factura.class, idFactura);
		} finally {
			session.close();
		}
		return z;
	}
	
	public Factura traerFacturaConItemFactura(int idFactura) {
		Factura z = null;
		try {
			iniciaOperacion();
			z = (Factura) session.get(Factura.class, idFactura);
			Hibernate.initialize(z.getLstItemFactura());
		} finally {
			session.close();
		}
		return z;
	}
	
	@SuppressWarnings("unchecked")
	public List<Factura> traerFacturasDelCliente(int idCliente) throws HibernateException {
		List<Factura> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Factura where idCliente = "+ idCliente).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Factura> traerFactura() throws HibernateException {
		List<Factura> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Factura").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public int agregarFactura(int nroSerieMedidor, int idCliente, LocalDate fecha, String observaciones) {
		int id = 0;
		Factura z = new Factura(nroSerieMedidor, idCliente, fecha, observaciones);
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
	
	public int agregarFactura(Factura z) {
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
	
	public void actualizarFactura(Factura z) throws HibernateException {
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
	
	public void eliminaFactura(Factura l) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(l);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	//------------------------------------------------------------------------------------
	
	public ItemFactura traerItemFactura(int idItemFactura) {
		ItemFactura z = null;
		try {
			iniciaOperacion();
			z = (ItemFactura) session.get(ItemFactura.class, idItemFactura);
		} finally {
			session.close();
		}
		return z;
	}
	
	public ItemFactura traerItemFactura(String detalle) {
		ItemFactura z = null;
		try {
			iniciaOperacion();
			z = (ItemFactura) session.createQuery("from ItemFactura t where t.detalle = '"+detalle+"'").uniqueResult();
		} finally {
			session.close();
		}
		return z;
	}
	
	//ItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, Factura factura)
	public int agregarItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, Factura factura) {
		int id = 0;
		ItemFactura IF = new ItemFactura(detalle, precioUnitario, cantidad, unidad, factura);
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(IF).toString());

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ItemFactura> traerItemFacturaDeLaFactura(int idFactura) {
		List<ItemFactura> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from ItemFactura where idFactura = "+ idFactura).list();

		} finally {
			session.close();
		}
		return lista;
	}


}
