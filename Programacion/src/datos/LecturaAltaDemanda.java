package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class LecturaAltaDemanda extends Lectura{
	private double energiaConcentrada;
	private String tipoTension;
	private double horaPico;
	private double horaValle;
	private double resto;
	public LecturaAltaDemanda(int idLectura, LocalTime hora, LocalDate fecha, Inspector inspector, Medidor medidor,
			double energiaConcentrada, String tipoTension, double horaPico, double horaValle, double resto) {
		super(idLectura, hora, fecha, inspector, medidor);
		this.energiaConcentrada = energiaConcentrada;
		this.tipoTension = tipoTension;
		this.horaPico = horaPico;
		this.horaValle = horaValle;
		this.resto = resto;
	}
	public double getEnergiaConcentrada() {
		return energiaConcentrada;
	}
	public void setEnergiaConcentrada(double energiaConcentrada) {
		this.energiaConcentrada = energiaConcentrada;
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
		return "LecturaAltaDemanda [energiaConcentrada=" + energiaConcentrada + ", tipoTension=" + tipoTension
				+ ", horaPico=" + horaPico + ", horaValle=" + horaValle + ", resto=" + resto + "]";
	}
	

}
