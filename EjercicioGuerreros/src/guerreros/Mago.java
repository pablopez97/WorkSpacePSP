package guerreros;

public class Mago extends Personaje{
	
	private int inteligencia = 25;
	
	public void Atacar(Personaje rival) {
		
		arma.usar();
		
		int danio = getArma().getDanio();
		
		if(getArma() instanceof Hechizo) {
			
			danio = danio + inteligencia;
			
		}
		
		System.out.println("El mago " +getNombre()+ " ataca a " +rival.getNombre()+ 
				"y le produce un daño total de: " +danio);
		
		int vidaRes = rival.getVida() - danio;
		
		rival.setVida(vidaRes);
		
	}
}
	

