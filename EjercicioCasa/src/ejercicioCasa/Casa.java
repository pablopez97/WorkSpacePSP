package ejercicioCasa;

import java.util.ArrayList;

public class Casa {
	
	private Persona persona;
	private Direccion direccion;
	private double precio;
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Persona> listaPersonas;
	
	public Casa(Persona persona, Direccion direccion, double precio, ArrayList<Habitacion> listaHabitaciones,
			ArrayList<Persona> listaPersonas) {
		super();
		this.persona = persona;
		this.direccion = direccion;
		this.precio = precio;
		this.listaHabitaciones = listaHabitaciones;
		this.listaPersonas = listaPersonas;
	}

	@Override
	public String toString() {
		return "Datos de esta casa:\n" + " Direccion:\n\n" + direccion + "\n Precio de la casa: " + precio + "\n Datos de la habitaciones: "
				+ listaHabitaciones + "\n Datos de las personas que viven en esta casa: " + listaPersonas;
	}
	
	public double m2totales() {
		
		double m2t=0;
		
		for (int i = 0; i< listaHabitaciones.size(); i++) {
			
			m2t= m2t + listaHabitaciones.get(i).getM2();
			
		}
		
		return m2t;
	}
	
}
