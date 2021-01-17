package guerreros;

public abstract class Personaje {
	
	public Arma arma;
	private String nombre;
	private int vida;

	public Arma getArma() {
		return arma;
	}



	public void setArma(Arma arma) {
		this.arma = arma;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getVida() {
		return vida;
	}



	public void setVida(int vida) {
		this.vida = vida;
	}



	public abstract void  Atacar(Personaje p);
	
}
