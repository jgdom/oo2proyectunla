package datos;

public class TarifaAltaDemanda extends Tarifa{

	private double horaPico;
	private double horaValle;
	private double resto;
	private double fijo;
	
	public TarifaAltaDemanda() {}
	
	public TarifaAltaDemanda(String tipoTension, double horaPico, double horaValle, double resto, double fijo) {
		super(tipoTension);
		this.horaPico = horaPico;
		this.horaValle = horaValle;
		this.resto = resto;
		this.fijo = fijo;
	}

	public double getHoraPico() {
		return horaPico;
	}

	public void setHoraPico(double horaPico) {
		this.horaPico = horaPico;
	}

	public double getHoraValle() {
		return horaValle;
	}

	public void setHoraValle(double horaValle) {
		this.horaValle = horaValle;
	}

	public double getResto() {
		return resto;
	}

	public void setResto(double resto) {
		this.resto = resto;
	}

	public double getFijo() {
		return fijo;
	}

	public void setFijo(double fijo) {
		this.fijo = fijo;
	}

	@Override
	public String toString() {
		return "TarifaAltaDemanda [horaPico=" + horaPico + ", horaValle=" + horaValle + ", resto=" + resto + ", fijo="
				+ fijo + "]";
	}
	
	
	
	
}
