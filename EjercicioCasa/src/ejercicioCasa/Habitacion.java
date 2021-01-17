package ejercicioCasa;

public class Habitacion {
	
	private double m2;
	private TipoHabitacion tipoHabitacion;
	
	public Habitacion(double m2, TipoHabitacion tipoHabitacion) {
		super();
		this.m2 = m2;
		this.tipoHabitacion = tipoHabitacion;
	}

	
	
	public double getM2() {
		return m2;
	}



	@Override
	public String toString() {
		return "Habitacion con " + m2 + " m2 es : " + tipoHabitacion;
	}
	
	
	
}
