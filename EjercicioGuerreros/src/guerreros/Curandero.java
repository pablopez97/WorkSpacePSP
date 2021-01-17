package guerreros;

public class Curandero extends Personaje{
	
	private int sabiduria = 20;
	
	@Override
	public void Atacar(Personaje rival) {
		
		arma.usar();
		
		int danio = getArma().getDanio();
		
		if(getArma() instanceof Rezo) {
			
			danio = danio + sabiduria;
			
		}
		
		System.out.println("El curandero " +getNombre()+ " ataca a " +rival.getNombre()+ 
				"y le produce un daño total de: " +danio);
		
		int vidaRes = rival.getVida() - danio;
		
		rival.setVida(vidaRes);
		
	}
	
}
