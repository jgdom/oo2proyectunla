package datos;

import state.Disponible;
import state.EstadoBoleto;

public class Boleto {
	private Butaca butaca;
	private EstadoBoleto estado;

	public Boleto(Butaca butaca) {
		this.butaca = butaca;
		this.estado = new Disponible();
	}

	/*---------- METODOS ----------*/
	public void cancelarCompra() {
		this.setEstado(this.getEstado().dejarDisponible());
	}

	public void reservarButaca(Cliente cliente) {
		this.setEstado(this.getEstado().reservar(cliente));
	}

	public void confirmar() {
		this.setEstado(this.getEstado().confirmar());
	}

	/*--------- GETs y SETs ---------*/
	public Butaca getButaca() {
		return butaca;
	}

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}

	public EstadoBoleto getEstado() {
		return estado;
	}

	public void setEstado(EstadoBoleto estado) {
		this.estado = estado;
	}
}
