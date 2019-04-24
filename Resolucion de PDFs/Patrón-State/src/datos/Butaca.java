package datos;

public class Butaca {
	private int idButaca;
	private String butaca;

	public Butaca(int idButaca, String butaca) {
		this.idButaca = idButaca;
		this.butaca = butaca;
	}

	/*---------- GETs y SETs ----------*/
	public int getIdButaca() {
		return idButaca;
	}

	public void setIdButaca(int idButaca) {
		this.idButaca = idButaca;
	}

	public String getButaca() {
		return butaca;
	}

	public void setButaca(String butaca) {
		this.butaca = butaca;
	}
}
