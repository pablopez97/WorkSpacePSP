package ejercicioCasa;

public class Direccion {
	
	private String nombreVia;
	private String tipoVia;
	private String cp;
	
	public Direccion(String nombreVia, String tipoVia, String cp) {
		super();
		this.nombreVia = nombreVia;
		this.tipoVia = tipoVia;
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Nombre de la via:" + nombreVia + ", tipo de via: " + tipoVia + "codigo postal: " + cp;
	}
	
	
	
}
