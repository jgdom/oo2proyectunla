package negocio;

import datos.*;
import dao.EventoDao;

public class EventoABM {
	
	private static EventoABM instancia;
	private EventoDao dao = EventoDao.getInstancia();
	
	protected EventoABM() {}
	
	public static EventoABM getInstancia() {
		if(instancia == null) {
			instancia = new EventoABM();
		}
		return instancia;
	}
	
	public Evento traer(long idEvento) {
		return dao.traerEvento(idEvento);
	}
	
	public int agregar(Evento e) {
		return dao.agregar(e);
	}
	
	public void actualizar(Evento e) {
		dao.actualizar(e);
	}
	
	public void eliminar(Evento e) {
		dao.eliminar(e);
	}
	
	public boolean agregar(Evento evento,Cliente cliente) {
		return dao.agregarCliente(evento, cliente);
	}
	
	public boolean eliminar(Evento evento,Cliente cliente) {
		return dao.eliminarCliente(evento, cliente);
	}

}
