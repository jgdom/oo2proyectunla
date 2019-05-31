package dao;

import datos.Lectura;
import datos.Medidor;
import negocio.Funciones;
import java.util.List;
import java.time.LocalDate;
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
		
		public Lectura traerLectura(LocalDate fecha) {
			Lectura l = null;
			try {
				iniciaOperacion();
				l = (Lectura) session.createQuery("from Lectura l where l.fecha= '"+fecha+"'").uniqueResult();
			}
			finally {
				session.close();
			}
			return l;
		}
		
		@SuppressWarnings ( "unchecked" )
		public List<Lectura> traerLectura() throws HibernateException {
			List<Lectura> lista = null ;
			try {
				iniciaOperacion();
				lista = session .createQuery( "from Lectura" ).list();
			} finally {
				session .close();
			}
			return lista ;
		}
		
		public Lectura traerLecturaEInspector(int idLectura)throws HibernateException{
			Lectura z = null;
			try {
				iniciaOperacion();
				String hql = "from Lectura a where a.idLectura =" + idLectura;
				z = (Lectura) session.createQuery(hql).uniqueResult();
				Hibernate.initialize(z.getInspector());
			}
			finally {
				session.close();
			}
			return z;
		}
		
		@SuppressWarnings("unchecked")
		public List<Lectura> traerLecturasMedidor(long idMedidor){
			List<Lectura> lista = null;
			try {
				iniciaOperacion();
				String hql = "from Lectura l inner join fetch l.medidor m where m.nroSerie= " + idMedidor;
				lista = session.createQuery(hql).list();
			}
			finally {
				session.close();
			}
			return lista;
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
		
		public Lectura traerLectura(Medidor medidor,int mes,int anio) {
			Lectura l = null;
			List<Lectura> lista = traerLecturasMedidor(medidor.getNroSerie());
			int i = 0;
			while(l == null && i < lista.size()) {
				if(Funciones.traerAnio(lista.get(i).getFecha())==anio && Funciones.traerMes(lista.get(i).getFecha())==mes) {
					l = lista.get(i);
				}
			}
			return l;
		}

	

}
