package ejercicio2;

public class MainLavado {

	public static void main(String[] args) {

		TunelLavado tunel = new TunelLavado();
		
		Coche coche1 = new Coche("Volkswagen", "Golf GTI", "2342 AAA", tunel);
		Coche coche2 = new Coche("MINI", "Cooper S", "2332 AAA", tunel);
		Coche coche3 = new Coche("Mercedes", "CLase A", "2112 AAA", tunel);
		Coche coche4 = new Coche("Toyota", "Supra", "7777 AAA", tunel);
		
		Thread t1 = new Thread(coche1);
		Thread t2 = new Thread(coche2);
		Thread t3 = new Thread(coche3);
		Thread t4 = new Thread(coche4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
