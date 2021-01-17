package ejercicio1;

import java.util.Scanner;

public class MainFactorial {

	public static void main(String[] args) {
		
		System.out.println("Por favor introduzca 5 numeros:");
		
		int numeros[] = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < numeros.length; i++) {
			
			System.out.println("Introduzca el numero"+(i+1));
			
			numeros[i] =Integer.parseInt(sc.nextLine());
			
		}
		
		HiloFactorialThread hilo1 = new HiloFactorialThread(numeros[0]);
		hilo1.setName("Hilo1");
		
		HiloFactorialThread hilo2 = new HiloFactorialThread(numeros[1]);
		hilo2.setName("Hilo2");
		
		HiloFactorialThread hilo3 = new HiloFactorialThread(numeros[2]);
		hilo3.setName("Hilo3");
		
		HiloFactorialRunnable hilo4 = new HiloFactorialRunnable(numeros[3]);
		Thread t4 = new Thread(hilo4);
		
		HiloFactorialRunnable hilo5 = new HiloFactorialRunnable(numeros[4]);
		Thread t5= new Thread(hilo5);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		t4.start();
		t5.start();
		
		System.out.println("Hilos terminados");
		
		sc.close();
		
	}

}
