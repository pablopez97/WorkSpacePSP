package ejercicio3;

public class Persona extends Thread{
	
	private String nombre;
	private String dni;
	private int edad;
	private Peluqueria peluqueria;
	
	public Persona(String nombre, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}
	
	
	
	public void setPeluqueria(Peluqueria peluqueria) {
		this.peluqueria = peluqueria;
	}



	public String getNombre() {
		return nombre;
	}



	@Override
	public void run() {
		
		llegarPeluqueria();
		
	}

	private void llegarPeluqueria() {
		
		System.out.println("Hola!! Vengo a cortarme el pelo :)");
		peluqueria.cortarPelo(this);
		
	}
	
}
