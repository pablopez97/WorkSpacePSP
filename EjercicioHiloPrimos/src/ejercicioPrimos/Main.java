package ejercicioPrimos;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int num1, num2, num3;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca 3 numeros primos");
		System.out.println("Numero 1:");
		
		num1=Integer.parseInt(sc.nextLine());
		
		System.out.println("Numero 2:");
		
		num2=Integer.parseInt(sc.nextLine());
		
		System.out.println("Numero 3:");
		
		num3=Integer.parseInt(sc.nextLine());
		
		HiloPrimos hilo1 = new HiloPrimos(num1);
		
		HiloPrimos hilo2 = new HiloPrimos(num2);
		
		HiloPrimos hilo3 = new HiloPrimos(num3);
		
		Thread h1 = new Thread(hilo1);
		Thread h2 = new Thread(hilo2);
		Thread h3 = new Thread(hilo3);
		
		h1.setName("Hilo1");
		h2.setName("Hilo2");
		h3.setName("Hilo3");
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		
		hilo1.start();
		
		
		sc.close();
		
	}
	
}
