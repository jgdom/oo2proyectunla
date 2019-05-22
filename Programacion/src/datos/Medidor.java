package datos;
import java.util.Set;
public class Medidor {
	
	private long nroSerie;
	private String direccion;
	private boolean esBaja;
	private Zona zona;
	private Tarifa tarifa;
	private Set<Lectura> lectura;
	private Cliente cliente;
	
	public Medidor() {}

	public Medidor(String direccion, boolean esBaja, Zona zona) {
		super();
		this.direccion = direccion;
		this.esBaja = esBaja;
		this.zona = zona;
	}

	public long getNroSerie() {
		return nroSerie;
	}

	protected void setNroSerie(long nroSerie) {
		this.nroSerie = nroSerie;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEsBaja() {
		return esBaja;
	}

	public void setEsBaja(boolean esBaja) {
		this.esBaja = esBaja;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Set<Lectura> getLectura() {
		return lectura;
	}

	public void setLectura(Set<Lectura> lectura) {
		this.lectura = lectura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Medidor [nroSerie=" + nroSerie + ", direccion=" + direccion + ", esBaja=" + esBaja + ", zona=" + zona
				+ ", tarifa=" + tarifa + ", lectura=" + lectura + "]";
	}
	
	public boolean equals(Medidor m) {
		return this.nroSerie == m.getNroSerie();
	}
	

}
