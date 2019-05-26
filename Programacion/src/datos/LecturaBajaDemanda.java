package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class LecturaBajaDemanda extends Lectura{
	
	private int idLecturaBajaDemanda;
	private double energiaConsumida;
	
	public LecturaBajaDemanda() {}
	
	public LecturaBajaDemanda(LocalTime hora, LocalDate fecha, Inspector inspector, Medidor medidor,
			double energiaConsumida) {
		super(hora, fecha, inspector, medidor);
		this.energiaConsumida = energiaConsumida;
	}
	
	public int getIdLecturaBajaDemanda() {
		return idLecturaBajaDemanda;
	}

	protected void setIdLecturaBajaDemanda(int idLecturaBajaDemanda) {
		this.idLecturaBajaDemanda = idLecturaBajaDemanda;
	}

	public double getEnergiaConsumida() {
		return energiaConsumida;
	}

	public void setEnergiaConsumida(double energiaConsumida) {
		this.energiaConsumida = energiaConsumida;
	}
	
	@Override
	public String toString() {
		return super.toString() + "LecturaBajaDemanda [energiaConsumida=" + energiaConsumida + "]";
	}
	
	
}
