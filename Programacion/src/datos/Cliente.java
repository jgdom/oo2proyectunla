package datos;

import java.util.Set;

public class Cliente {
	
	private int idCliente;
	private String direccion;
	private Set<Medidor> medidor;
	
	public Cliente() {}

	public Cliente(String direccion) {
		super();
		this.direccion = direccion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Medidor> getMedidor() {
		return medidor;
	}

	public void setMedidor(Set<Medidor> medidor) {
		this.medidor = medidor;
	}

	
	

}
