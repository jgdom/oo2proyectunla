package datos;

public class LecturaBajaDemanda {
	private double energiaConsumida;

	public LecturaBajaDemanda(double energiaConsumida) {
		super();
		this.energiaConsumida = energiaConsumida;
	}

	@Override
	public String toString() {
		return "LecturaBajaDemanda [energiaConsumida=" + energiaConsumida + "]";
	}
	
}
