package datos;

public class Medidor {
	private int nroSerie;
	private Cliente cliente;
	private String direccion;
	private boolean esBaja;
	private Zona zona;
	private Tarifa tarifa;
	public Medidor(int nroSerie, Cliente cliente, String direccion, boolean esBaja, Zona zona, Tarifa tarifa) {
		super();
		this.nroSerie = nroSerie;
		this.cliente = cliente;
		this.direccion = direccion;
		this.esBaja = esBaja;
		this.zona = zona;
		this.tarifa = tarifa;
	}
	public int getNroSerie() {
		return nroSerie;
	}
	protected void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	@Override
	public String toString() {
		return "Medidor [nroSerie=" + nroSerie + ", cliente=" + cliente + ", direccion=" + direccion + ", esBaja="
				+ esBaja + ", zona=" + zona + ", tarifa=" + tarifa + "]";
	}
	
}
