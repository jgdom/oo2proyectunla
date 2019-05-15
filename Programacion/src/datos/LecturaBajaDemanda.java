package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class LecturaBajaDemanda extends Lectura{
	private double energiaConsumida;
	public LecturaBajaDemanda() {}
	public LecturaBajaDemanda(LocalTime hora, LocalDate fecha, double energiaConsumida) {
		super(hora, fecha);
		this.energiaConsumida = energiaConsumida;
	}

	public double getEnergiaConsumida() {
		return energiaConsumida;
	}

	public void setEnergiaConsumida(double energiaConsumida) {
		this.energiaConsumida = energiaConsumida;
	}

	@Override
	public String toString() {
		return "LecturaBajaDemanda [energiaConsumida=" + energiaConsumida + "]";
	}
	
	
}
