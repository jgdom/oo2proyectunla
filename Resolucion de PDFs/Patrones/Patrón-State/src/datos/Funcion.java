package datos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Funcion {
	private String pelicula;
	private GregorianCalendar fechaHora;
	private List<Boleto> boletos;

	public Funcion(String pelicula, GregorianCalendar fechaHora) {
		this.pelicula = pelicula;
		this.fechaHora = fechaHora;
		this.cargarBoletos();
	}

	/*---------- METODOS ----------*/
	protected void cargarBoletos() {
		List<Boleto> lstBoleto = new ArrayList<Boleto>();
		for (int i = 0; i < 50; i++) {
			lstBoleto.add(new Boleto(new Butaca((i + 1), "Asiento " + (i + 1))));
		}
		this.setBoletos(lstBoleto);
	}

	public Boleto verBoleto(int index) {
		return this.getBoletos().get(index);
	}

	/*---------- GETs y SETs ----------*/
	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public List<Boleto> getBoletos() {
		return boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}
}
