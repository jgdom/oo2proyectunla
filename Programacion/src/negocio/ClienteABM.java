package negocio;

import dao.ClienteDao;
import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaJuridica;
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
	public Cliente traerPersonaFisicaYDatosPersonales(int dni) {
        return dao.traerClienteYDatosPersonales(dni);
    }

	public Cliente traerCliente(int idCliente) {
		return dao.traerCliente(idCliente);
	}
	
	public PersonaFisica traerPersonaFisica(int dni) {
		return dao.traerPersonaFisica(dni);
	}
	
	public PersonaJuridica traerPersonaJuridica(String cuit) {
		return dao.traerPersonaJuridica(cuit);
	}
	
	public Cliente traerClienteYMedidor(int idCliente) {
		return dao.traerClienteYMedidor(idCliente);
	}
	
	public List<Cliente> traerClientes(){
		return dao.traerClientes();
	}
	
	public int agregarPersonaFisica(PersonaFisica f)throws Exception {
		if(traerPersonaFisica(f.getdPersonales().getDni()) != null)throw new Exception("ERROR ya existe cliente con dni-->" + f.getdPersonales().getDni());
		return dao.agregarPersonaFisica(f);
	}
	
	public int agregarPersonaJuridica(PersonaJuridica j)throws Exception {
		if(traerPersonaJuridica(j.getCuit()) != null)throw new Exception("ERROR ya existe cliente con cuit-->" + j.getCuit());
		return dao.agregarPersonaJuridica(j);
	}
	
	public void eliminarCliente(Cliente c) {
		dao.eliminarCliente(c);
	}
	
	public void actualizarCliente(Cliente c) {
		dao.actualizarCliente(c);
	}

}
