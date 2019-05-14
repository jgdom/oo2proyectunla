package datos;

public class Tarifa {
	
	protected String tipoTension;

	public Tarifa() {}

	public Tarifa(String tipoTension) {
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
