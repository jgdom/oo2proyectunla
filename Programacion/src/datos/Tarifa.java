package datos;

public class Tarifa {
	
	protected int idTarifa;
	protected String servicio;

	public Tarifa() {}

	public Tarifa(String servicio) {
		this.servicio = servicio;
	}

	public int getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Tarifa [idTarifa=" + idTarifa + ", servicio=" + servicio + "]";
	}


	

}
