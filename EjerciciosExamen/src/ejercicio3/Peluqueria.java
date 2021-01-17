package ejercicio3;

public class Peluqueria{

	public synchronized void cortarPelo(Persona persona) {
		
		System.out.println("Sientese para cortarse el pelo don/doña" +persona.getNombre());
		
		try {
			System.out.println("Lavando el pelo...");
			Thread.sleep(4000);
			
			System.out.println("Cortando el pelo...");
			Thread.sleep(6000);
			
			System.out.println("Peinando el pelo...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
		System.out.println("Ale pase por caja "+ persona.getNombre());
		
	}
	
	
	
}
