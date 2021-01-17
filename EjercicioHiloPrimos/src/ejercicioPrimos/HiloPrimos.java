
package ejercicioPrimos;

public class HiloPrimos implements Runnable{
		
		private int num;

		public HiloPrimos(int num) {
			super();
			this.num = num;
		}



		@Override
		public void run() {
			
			int contador = 2;
			  boolean primo=true;
			  while ((primo) && (contador!=num)){
			    if (num % contador == 0)
			      primo = false;
			    contador++;
			  }
			  
			  if(primo) {
				  System.out.println("El numero "+num+" es un numero primo");
			  }else {
				  System.out.println("El numero "+num+" NO es un numero primo");
			  }
			
		}
		
}
		
