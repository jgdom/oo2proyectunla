package negocio;

import datos.*;
import java.util.List;
import dao.ClienteDao;

public class ClienteABM {
	
	private static ClienteABM instancia;
	private ClienteDao dao = ClienteDao.getInstancia();
	
	protected ClienteABM() {}
	
	public static ClienteABM getInstancia() {
		if(instancia == null) {
			instancia = new ClienteABM();
		}
		return instancia;
	}
	
	public Cliente traerCliente(long idCliente) {
		return dao.traerCliente(idCliente);
	}
	
	public Cliente traerCliente(int dni) {
		return dao.traerCliente(dni);
	}
	
	public List<Cliente> traerClientes(){
		return dao.traerCliente();
	}
	
	public int agregar(Cliente cliente) {
		return dao.agregar(cliente);
	}
	
	public void actualizar(Cliente cliente) {
		dao.actualizar(cliente);
	}
	
	public void eliminar(Cliente cliente) {
		dao.eliminar(cliente);
	}
	
	public Cliente traerClienteYEventos(long idCliente) {
		return dao.traerClienteYEventos(idCliente);
	}
 	
	public boolean agregarEvento(Cliente cliente,Evento evento) {
		return dao.agregarEvento(cliente, evento);
		
	}
	
	public boolean eliminarEvento(Cliente cliente,Evento evento) {
		return dao.eliminarEvento(cliente, evento);
	}

}
