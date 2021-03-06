package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localHost";
	
	public static void main(String[] args) {
		
		System.out.println("---------APLICACION CLIENTE----------");
		System.out.println("-------------------------------------");
		
		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;
		
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		Scanner sc = new Scanner(System.in);
		
		try {
			
			boolean continuar = true;
			
			do {
				
				socketCliente = new Socket();
				socketCliente.connect(direccionServidor);
				System.out.println("Conexion establecida a..." +IP_SERVER+ "... por el puerto " +PUERTO);
				
				//ASIGNAMOS ESTE NUMERO DE PUERTO
				entrada = new InputStreamReader(socketCliente.getInputStream());
				
				//SERA LO QUE ENVIAREMOS AL SERVIDOR
				salida = new PrintStream(socketCliente.getOutputStream());
				//SERA LO QUE DEVUELVA EL SERVIDOR
				
				System.out.println("Introduzca los numeros con los que desee operar:");
				System.out.println("Numero 1:");
				String numero1 = sc.nextLine();
				System.out.println("Numero 2:");
				String numero2 = sc.nextLine();
				System.out.println("Introduzca un numero indicando la operacion que desee realizar");
				
				System.out.println("1-Suma");
				System.out.println("1-Resta");
				System.out.println("1-Multiplicacion");
				System.out.println("1-Division");
				
				System.out.println("Operador:");
				String operando = sc.nextLine();
				
				String operacion = numero1+"-"+numero2+"-"+operando;
				
				salida.println(operacion);
				
				BufferedReader bf = new BufferedReader(entrada);
				//ESPERAMOS EN ESTE PUNTO A RECIBIR RESPUESTA DEL SERVIDOR
				
				String lineaRecibida = bf.readLine();
				
				System.out.println("CLIENTE: El servidor me ha respondido: " +lineaRecibida);
				
				System.out.println("�Quiere continuar? S/N");
				String sContinuar = sc.nextLine().toLowerCase();
				
				if(sContinuar.equals("n")) {
					
					continuar = false;
					
				}
				
			}while(continuar);
			
		} catch (UnknownHostException excepcion) {
			System.err.println("No encuentro el servidor en la direcci�n" + IP_SERVER);
		} catch (IOException excepcion) {
			System.err.println("Error de entrada/salida");
		} catch (Exception e) {
			System.err.println("Error: " + e);
		} finally {// ES MUYYY IMPORTANTE QUE EN LOS SOCKETS SIEMPRE SE CIERREN LAS CONEXIONES
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
