package state;

import datos.Cliente;

public abstract class EstadoBoleto {
	private Cliente cliente;

	public abstract EstadoBoleto dejarDisponible();

	public abstract EstadoBoleto reservar(Cliente cliente);

	public abstract EstadoBoleto confirmar();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
