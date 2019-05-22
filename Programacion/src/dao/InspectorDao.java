package dao;
import datos.Inspector;
import datos.PersonaFisica;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Zona;
public class InspectorDao {

		
		private static InspectorDao instancia;
		private static Session session;
		private Transaction tx;
		
		protected InspectorDao() {}
		
		public static InspectorDao getInstancia() {
			if(instancia == null) {
				instancia = new InspectorDao();
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
		
		public Inspector traerInspector(int idInspector) {
			Inspector i = null;
			try {
				iniciaOperacion();
				i = (Inspector) session.get(Inspector.class, idInspector);
				
			}
			finally {
				session.close();
			}
			return i;
		}
		
		@SuppressWarnings ( "unchecked" )
		public List<Inspector> traerZonas() throws HibernateException {
			List<Inspector> lista = null ;
			try {
				iniciaOperacion();
				lista = session .createQuery( "from Inspector" ).list();
			} finally {
				session .close();
			}
			return lista ;
		}
		public Inspector traerInspectorPorDni(int dni) {
			Inspector f = null;
			try {
				iniciaOperacion();
				f = (Inspector)session.createQuery("from Inspector i inner join fetch i.dPersonales p where p.dni=" + dni).uniqueResult();
			}
			finally {
				session.close();
			}
			return f;
		}
		public Inspector traerInspectoresYZonas(int idInspector)throws HibernateException{
			Inspector i = null;
			try {
				iniciaOperacion();
				String hql = "from Inspector a where a.idInspector =" + idInspector;
				i = (Inspector) session.createQuery(hql).uniqueResult();
				Hibernate.initialize(i.getZonas());
			}
			finally {
				session.close();
			}
			return i;
		}

		public void eliminarInspecto(Inspector i)throws HibernateException{
			try {
				iniciaOperacion();
				session.delete(i);
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
		
		public int agregarInspector(Inspector i) {
			int id = 0;
			try {
				iniciaOperacion();
				id = Integer.parseInt(session.save(i).toString());
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
		public void actualizar(Inspector z) throws HibernateException {
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
		public boolean agregarZona(Zona zona,Inspector inspector) {
			Inspector i = traerInspectoresYZonas(inspector.getIdInspector());
			i.agregarZona(zona);
			actualizar(i);
			return true;
		}
		
		public boolean EliminarZona(Zona zona,Inspector inspector) {
			Inspector i = traerInspectoresYZonas(inspector.getIdInspector());
			i.eliminarZona(zona);
			actualizar(i);
			return true;
		}
}
