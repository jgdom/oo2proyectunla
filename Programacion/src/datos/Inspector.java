package datos;

import java.util.Set;

public class Inspector {
	
	private int idInspector;
	private DatosPersonales dPersonales;
	private String cuil;
	private Set<Zona> zonas;
	private Set<Lectura> lectura;

	public Inspector() {}
	
	public Inspector(DatosPersonales dPersonales, String cuil) throws Exception {
		super();
		this.dPersonales = dPersonales;
		this.cuil = cuil;
	}
	
	public int getIdInspector() {
		return idInspector;
	}
	
	protected void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}
	
	public DatosPersonales getdPersonales() {
		return dPersonales;
	}
	
	public void setdPersonales(DatosPersonales dPersonales) {
		this.dPersonales = dPersonales;
	}
	
	public String getCuil() throws Exception {
		return cuil;
	}
	
	public void setCuil(String cuil)throws Exception {
		//if(!validarCuil(cuil))throw new Exception("ERROR cuil ingresado incorrecto");por ahora no lo usemos
		this.cuil = cuil;
	}
	
	public Set<Zona> getZonas() {
		return zonas;
	}
	
	public void setZonas(Set<Zona> zonas) {
		this.zonas = zonas;
	}
	
	public Set<Lectura> getLectura() {
		return lectura;
	}
	
	public void setLectura(Lectura lectura) {
		this.lectura.add(lectura);
	}
	
	@Override
	public String toString() {
		return "Inspector [idInspector=" + idInspector + ", cuil=" + cuil + "]" ;
	}

	/*private boolean validarCuil(String cuil) {
		boolean valido = false;
		int vaux;
		int v1=0,v2=0,v3=0;
		int mult=5;
		if(Integer.parseInt(cuil.substring(0, 2)) == 20  || 
		   Integer.parseInt(cuil.substring(0, 2)) == 27 ) {
			for(int i = 0 ; i<cuil.length();i++) {	
				vaux= Integer.parseInt(cuil.substring(i,i+1));
				v1+= vaux * mult;
				mult = mult-1;
				if(mult == 2) mult = 7;
				
			}
			v2 = v1 % 11;
			v3 = 11 - v2;
			if(v3 == Integer.parseInt(cuil.substring(10,11))) valido = true;	
			
		}
		return valido;
	}por ahora no lo usemos */
	
	public boolean equals(Inspector i) {
		return this.idInspector == i.getIdInspector();
	}
	
	public boolean agregarZona(Zona z) {
		return zonas.add(z);
	}
	
	public boolean eliminarZona(Zona z) {
		return zonas.remove(z);
	}
	
}
