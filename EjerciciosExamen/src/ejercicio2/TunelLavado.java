package ejercicio2;

public class TunelLavado {

	public synchronized void lavarCoche(Coche coche) {
		
		System.out.println("\n Iniciando lavado de: "+coche.getMarca()+" "+coche.getModelo()+" matricula: "+coche.getMatricula());
		
		
		try {
			System.out.println("Lavando...");
			Thread.sleep(3000);
			System.out.println("Lavado terminado");
			
			System.out.println("Aclarando...");
			Thread.sleep(3000);
			System.out.println("Aclarado terminado");
			
			System.out.println("Encerando...");
			Thread.sleep(4000);
			System.out.println("Encerando terminado");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("El coche: "+coche.getMarca()+" "+coche.getModelo()+" ha salido del tunel de lavado");
		
	}
	
}
