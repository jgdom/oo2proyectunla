package state;

import datos.Cliente;

public class Reservada extends EstadoBoleto {
	@Override
	public EstadoBoleto dejarDisponible() {
		return new Disponible();
	}

	@Override
	public EstadoBoleto reservar(Cliente cliente) {
		try {
			throw new Exception("Error, esta butaca ya está reservada");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public EstadoBoleto confirmar() {
		return new Confirmada();
	}
}
