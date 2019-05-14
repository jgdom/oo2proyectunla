package datos;

public class TarifaBajaDemanda extends Tarifa{

	private double cargoFijo;
	private double variable;
	
	public TarifaBajaDemanda() {}
	
	public TarifaBajaDemanda(String tipoTension, double cargoFijo, double variable) {
		super(tipoTension);
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
		return "TarifaBajaDemanda [cargoFijo=" + cargoFijo + ", variable=" + variable + "]";
	}
	
	

	
	
}
