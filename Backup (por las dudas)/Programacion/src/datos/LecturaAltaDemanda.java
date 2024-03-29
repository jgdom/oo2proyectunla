package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class LecturaAltaDemanda extends Lectura {
	private double energiaContratada;
	private String tipoTension;
	private double horaPico;
	private double horaValle;
	private double resto;
	public LecturaAltaDemanda() {}
	public LecturaAltaDemanda(LocalTime hora, LocalDate fecha, double energiaContratada, String tipoTension,
			double horaPico, double horaValle, double resto) {
		super(hora, fecha);
		this.energiaContratada = energiaContratada;
		this.tipoTension = tipoTension;
		this.horaPico = horaPico;
		this.horaValle = horaValle;
		this.resto = resto;
	}
	public double getEnergiaContratada() {
		return energiaContratada;
	}
	public void setEnergiaContratada(double energiaContratada) {
		this.energiaContratada = energiaContratada;
	}
	public String getTipoTension() {
		return tipoTension;
	}
	public void setTipoTension(String tipoTension) {
		this.tipoTension = tipoTension;
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
	@Override
	public String toString() {
		return "LecturaAltaDemanda [energiaContratada=" + energiaContratada + ", tipoTension=" + tipoTension
				+ ", horaPico=" + horaPico + ", horaValle=" + horaValle + ", resto=" + resto + "]";
	}
	
}
