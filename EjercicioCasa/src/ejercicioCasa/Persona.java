package ejercicioCasa;

public class Persona {
	
	private String nombre;
	private int edad;
	private String dni;
	
	public Persona(String nombre, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", edad: " + edad + " y dni=" + dni;
	}
	
	
	
}
