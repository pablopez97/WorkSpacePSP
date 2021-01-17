package ejercicioCasa;

import java.util.ArrayList;
import java.util.Scanner;

public class MainCasa {
	
	
	
	public static void main(String[] args) {
		
		Persona persona = null;
		Direccion direccion;
		
		int precio;
		
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		Scanner sc = new Scanner(System.in);
		
		leerDatosPersonas(listaPersonas, sc, persona);
		
		direccion = leerDireccion(sc);
		
		System.out.println("Introduzca el precio de la nueva casa que va a comprar: ");
		precio = Integer.parseInt(sc.nextLine());
		
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>(); 
		
		leerDatosHabitaciones(sc, listaHabitaciones);
		
		Casa casa = new Casa(persona, direccion, precio, listaHabitaciones, listaPersonas);
		
		System.out.println(casa);
		
		System.out.println("Los metros cuadrados totales de la casa seran: " +casa.m2totales());
		
		sc.close();
		
	}

	private static void leerDatosHabitaciones(Scanner sc, ArrayList<Habitacion> listaHabitaciones) {
		Habitacion habitacion;
		double m2;
		int numH;
		int opc;
		
		System.out.println("Introduzca el numero de estancias que hay en la casa: ");
		numH = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < numH; i++) {
			
			System.out.println("Indice el tipo de estancia");
			
			for(int j=0; j < TipoHabitacion.values().length;j++) {
				TipoHabitacion th = TipoHabitacion.values()[j];
				System.out.println(j+"-"+th);
			}
			
			opc=Integer.parseInt(sc.nextLine());
			
			System.out.println("Introduzca el tamaño de la habitacion en metros cuadrados:");
			m2 = Double.parseDouble(sc.nextLine());
			
			habitacion = new Habitacion(m2, TipoHabitacion.values()[opc]);
			
			listaHabitaciones.add(habitacion);
			
		}
	}

	private static Direccion leerDireccion(Scanner sc) {
		Direccion direccion;
		String tipoV;
		String nombreC;
		String cp;
		System.out.println("Introduzca la direccion de la casa");
		System.out.println("Tipo de vía:");
		tipoV=sc.nextLine();
		
		System.out.println("Nombre de la vía");
		nombreC=sc.nextLine();
		
		System.out.println("Codigo postal:");
		cp=sc.nextLine();
		
		direccion = new Direccion(nombreC, tipoV, cp);
		return direccion;
	}

	private static void leerDatosPersonas(ArrayList<Persona> listaPersonas, Scanner sc, Persona persona) {
		
		String nombre;
		int edad;
		String dni;
		int nump;
		System.out.println("Por favor introduzca los datos del propietario de esta nueva casa:");
		System.out.println("Nombre: ");
		nombre=sc.nextLine();
		
		System.out.println("Edad: ");
		edad=Integer.parseInt(sc.nextLine());
		
		System.out.println("DNI: ");
		dni=sc.nextLine();
		
		persona = new Persona(nombre, edad, dni);
		
		System.out.println("Introduzca el numero de personas que viven en esta casa:");
		nump=Integer.parseInt(sc.nextLine());
		
		listaPersonas.add(persona);
		
		for (int i = 0; i < nump; i++) {
			
			System.out.println("Por favor introduzca los datos del habitante" +(i+2)+ ":");
			System.out.println("Nombre: ");
			nombre=sc.nextLine();
			
			System.out.println("Edad: ");
			edad=Integer.parseInt(sc.nextLine());
			
			System.out.println("DNI: ");
			dni=sc.nextLine();
			
			persona = new Persona(nombre, edad, dni);
			
			listaPersonas.add(persona);
			
		}
	}

}
