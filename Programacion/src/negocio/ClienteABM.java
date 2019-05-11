package negocio;

import dao.ClienteDao;
import datos.Cliente;
import java.util.List;

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
	
	public Cliente traerCliente(int idCliente) {
		return dao.traerCliente(idCliente);
	}
	
	public Cliente traerClienteYMedidor(int idCliente) {
		return dao.traerClienteYMedidor(idCliente);
	}
	
	public List<Cliente> traerClientes(){
		return dao.traerClientes();
	}
	
	public int agregarCliente(Cliente c) {
		return dao.agregarCliente(c);
	}
	
	public void eliminarCliente(Cliente c) {
		dao.eliminarCliente(c);
	}

}
