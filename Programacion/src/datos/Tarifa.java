package datos;

public class Tarifa {
	private String tipoTension;


	public Tarifa(String tipoTension) {
		super();
		this.tipoTension = tipoTension;
	}

	public String getTipoTension() {
		return tipoTension;
	}

	public void setTipoTension(String tipoTension) {
		this.tipoTension = tipoTension;
	}

	@Override
	public String toString() {
		return "Tarifa [tipoTension=" + tipoTension + "]";
	}
	
}
