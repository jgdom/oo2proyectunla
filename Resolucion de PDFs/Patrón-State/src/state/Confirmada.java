package state;

import datos.Cliente;

public class Confirmada extends EstadoBoleto {
	@Override
	public EstadoBoleto dejarDisponible() {
		try {
			throw new Exception("Error, esta butaca ya está confirmada");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public EstadoBoleto reservar(Cliente cliente) {
		try {
			throw new Exception("Error, esta butaca ya está confirmada");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public EstadoBoleto confirmar() {
		try {
			throw new Exception("Error, esta butaca ya está confirmada");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
