package datos;

public class TarifaBajaDemanda extends Tarifa {
	private double HoraPico;
	private double resto;
	private double fijo;
	public TarifaBajaDemanda(String tipoTension, double horaPico, double resto, double fijo) {
		super(tipoTension);
		HoraPico = horaPico;
		this.resto = resto;
		this.fijo = fijo;
	}
	public double getHoraPico() {
		return HoraPico;
	}
	public void setHoraPico(double horaPico) {
		HoraPico = horaPico;
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
		return "TarifaBajaDemanda [HoraPico=" + HoraPico + ", resto=" + resto + ", fijo=" + fijo + "]";
	}
	


}
