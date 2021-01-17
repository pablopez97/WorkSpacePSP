package guerreros;

public class BatallaMain {

	public static void main(String[] args) {

		boolean finPartida = true;
		
		Personaje g1 = new Guerrero();
		g1.setNombre("Atila el uno");
		g1.setVida(100);
		Arma arma = new Espada();
		arma.setTipo("espada");
		arma.setDanio(20);
		g1.setArma(arma);
		
		Personaje g2 = new Mago();
		g2.setNombre("Merlín");
		g2.setVida(100);
		Arma arma1 = new Rezo();
		arma1.setTipo("rezo");
		arma1.setDanio(10);
		g2.setArma(arma1);
		
		System.out.println("Vida restante del personaje 1: " + g1.getVida());
		System.out.println("Vida restante del personaje 2: " + g2.getVida());
		
		do {
			
			g1.Atacar(g2);
			g2.Atacar(g1);
			
			System.out.println("Vida restante del personaje 1: " + g1.getVida());
			System.out.println("Vida restante del personaje 2: " + g2.getVida());
			
			if(g1.getVida()<0 || g2.getVida()<0) {
				
				finPartida = false;
				
				System.out.println("FIN DE LA PARTIDA");
				
				if(g1.getVida()<0) {
					
					System.out.println("Victoria de " + g2.getNombre());
					
				}else {
					
					System.out.println("Victoria de " +g1.getNombre());
					
				}
				
			}
			
		} while (g1.getVida()>0 && g2.getVida()>0 && finPartida == true);
		
	}

}
