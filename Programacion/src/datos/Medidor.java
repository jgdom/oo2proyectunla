package datos;

public class Medidor {
	
	private long nroSerie;
	private String direccion;
	private boolean esBaja;
	private Zona zona;
	private Tarifa tarifa;
	private Lectura lectura;
	
	public Medidor() {}
	
	public Medidor(long nroSerie, String direccion, boolean esBaja, Zona zona, Tarifa tarifa, Lectura lectura) {
		super();
		this.nroSerie = nroSerie;
		this.direccion = direccion;
		this.esBaja = esBaja;
		this.zona = zona;
		this.tarifa = tarifa;
		this.lectura = lectura;
	}
	

}
