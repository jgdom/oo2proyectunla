package dao;
import datos.Inspector;
import datos.Lectura;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class LecturaDao {

		
		private static LecturaDao instancia;
		private static Session session;
		private Transaction tx;
		
		protected LecturaDao() {}
		
		public static LecturaDao getInstancia() {
			if(instancia == null) {
				instancia = new LecturaDao();
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
		
		public Lectura traerLectura(int idLectura) {
			Lectura z = null;
			try {
				iniciaOperacion();
				z = (Lectura) session.get(Lectura.class, idLectura);
				
			}
			finally {
				session.close();
			}
			return z;
		}
		
		@SuppressWarnings ( "unchecked" )
		public List<Lectura> traerLectura() throws HibernateException {
			List<Lectura> lista = null ;
			try {
				iniciaOperacion();
				lista = session .createQuery( "from lectura" ).list();
			} finally {
				session .close();
			}
			return lista ;
		}
		
		public Lectura traerLecturaEInspector(int idLectura)throws HibernateException{
			Lectura z = null;
			try {
				iniciaOperacion();
				String hql = "from lectura a where a.idLectura =" + idLectura;
				z = (Lectura) session.createQuery(hql).uniqueResult();
				Hibernate.initialize(z.getInspector());
			}
			finally {
				session.close();
			}
			return z;
		}
		
		public void eliminaLectura(Lectura l)throws HibernateException{
			try {
				iniciaOperacion();
				session.delete(l);
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
		
		public int agregarLectura(Lectura z) {
			int id = 0;
			try {
				iniciaOperacion();
				id = Integer.parseInt(session.save(z).toString());
				//session.persist(z);
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
		public void actualizar(Lectura z)throws HibernateException{
			try {
				iniciaOperacion();
				session.update(z);
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
		
		public boolean agregarZonaAInspector(Lectura z,Inspector i) {
		
			return true;
		}

	

}
