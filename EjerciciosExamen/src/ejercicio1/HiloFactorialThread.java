package ejercicio1;

public class HiloFactorialThread extends Thread{
	
	private double numero;

	public HiloFactorialThread(double numero) {
		super();
		this.numero = numero;
	}
	
	
	@Override
	public void run() {
		
		System.out.println("Iniciando calculo del numero factorial "+numero);
			
		double factorial = 1;
		double numero2=numero;
		
		while(numero!=0) {
			
			factorial = factorial*numero;
			numero--;
			
		}
		
		System.out.println("El factorial del numero"+numero2+" es: "+factorial);
		
	}
	
}
