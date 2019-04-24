package state;

import datos.Cliente;

public class Disponible extends EstadoBoleto {
	@Override
	public EstadoBoleto dejarDisponible() {
		try {
			throw new Exception("Error, esta butaca ya está disponible");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public EstadoBoleto reservar(Cliente cliente) {
		Reservada ocupada = new Reservada();
		ocupada.setCliente(cliente);
		return ocupada;
	}

	@Override
	public EstadoBoleto confirmar() {
		try {
			throw new Exception("Error, no tiene una butaca seleccioanda");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}
