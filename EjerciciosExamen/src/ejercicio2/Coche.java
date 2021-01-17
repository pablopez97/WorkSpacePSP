package ejercicio2;

public class Coche implements Runnable{

	private String marca;
	private String modelo;
	private String matricula;
	private TunelLavado tunel;
	
	public Coche(String marca, String modelo, String matricula, TunelLavado tunel) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.tunel = tunel;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	@Override
	public void run() {
		
		tunel.lavarCoche(this);
		
	}
	
}
