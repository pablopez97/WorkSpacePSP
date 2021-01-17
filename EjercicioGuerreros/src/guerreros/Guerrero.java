package guerreros;

public class Guerrero extends Personaje{
	
	private int fuerza = 35;
	
	@Override
	public void Atacar(Personaje rival) {
		
		arma.usar();
		
		int danio = getArma().getDanio();
		
		if(getArma() instanceof Espada || getArma() instanceof Arco) {
			
			danio = danio + fuerza;
			
		}
		
		System.out.println("El guerrero " +getNombre()+ " ataca a " +rival.getNombre()+ 
				"y le produce un daño total de: " +danio);
		
		int vidaRes = rival.getVida() - danio;
		
		rival.setVida(vidaRes);
		
	}
}
	

