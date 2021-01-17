package guerreros;

public abstract class Arma {
	
	private int danio;
	private String tipo;
	

	public int getDanio() {
		return danio;
	}





	public void setDanio(int danio) {
		this.danio = danio;
	}





	public String getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	


	public abstract void usar();
	
}
