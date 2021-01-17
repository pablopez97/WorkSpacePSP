package ejercicio3;

public class GestionPeluqueria {

	public static void main(String[] args) {
		
		Peluqueria peluqueria = new Peluqueria();
		
		Persona p1 = new Persona("Maria José", "34534534564", 62);
		p1.setPeluqueria(peluqueria);
		
		Persona p2 = new Persona("José", "34534534564", 34);
		p2.setPeluqueria(peluqueria);
		
		Persona p3 = new Persona("Maria", "34534534564", 50);
		p3.setPeluqueria(peluqueria);
		
		Persona p4 = new Persona("Felix", "34534534564", 43);
		p4.setPeluqueria(peluqueria);
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		
	}

}
