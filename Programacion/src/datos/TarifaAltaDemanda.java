package datos;

public class TarifaAltaDemanda {
	private double cargoFijo;
	private double variable;
	public TarifaAltaDemanda(double cargoFijo, double variable) {
		super();
		this.cargoFijo = cargoFijo;
		this.variable = variable;
	}
	public double getCargoFijo() {
		return cargoFijo;
	}
	public void setCargoFijo(double cargoFijo) {
		this.cargoFijo = cargoFijo;
	}
	public double getVariable() {
		return variable;
	}
	public void setVariable(double variable) {
		this.variable = variable;
	}
	@Override
	public String toString() {
		return "TarifaAltaDemanda [cargoFijo=" + cargoFijo + ", variable=" + variable + "]";
	}
	
}
