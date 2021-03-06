package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SockerServer {

	public static final String IP_SERVER = "localHost";
	public static final int PUERTO = 2017;

	public static void main(String[] args) {
		
		System.out.println("------APLICACION DE SERVIDOR--------");
		System.out.println("------------------------------------");
		
		ServerSocket servidorSocket = null;
		Socket socketConexion = null;
		
		//ESTOS OBJETOS TRABAJARAN CON LA INFORMACION DE ENTRADA Y SALIDA DE LOS SOCKET
		PrintStream salida = null;
		InputStreamReader entrada = null;
		
		try {
			servidorSocket = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER,PUERTO);
			//CON ESTO DECIMOS AL SOCKET QUE ESCUCHE LAS PETICIONES TANTO DE LA IP COMO DEL PUERTO
			
			servidorSocket.bind(direccion);
			
			//ESTAMOS CONTINUAMENTE ESCUCHANDO PARA ESO HACEMOS LO SIGUIENTE
			
			while(true) {
				
				System.out.println("SERVIDOR: Esperando peticion...");
				//CUANDO SE ESTABLECE LA CONEXION UN SOCKET ES CREADO QUE SE ENCARGARÁ DE 
				//LLEVAR ACABAO LA COMUNICACION
				
				socketConexion = servidorSocket.accept();
				//EL PROGRAMA SE QUEDARA PARADO HASTA QUE ENTRE LA PETICION DE UN CLIENTE
				
				entrada = new InputStreamReader(socketConexion.getInputStream());
				//LEEMOS LOS DATOS DE ENTRADA CARACTER A CARACTER
				
				BufferedReader bf = new BufferedReader(entrada);
				//CON ESTE BUFFERED READER LEEMOS TODO FRASE A FRASE
				
				//EL SERVIDOR SE QUEDA AQUI PARADO HASTA QUE RECIBA INFORMACION DEL CLIENTE
				String stringRecibido = bf.readLine();
				//MUY IMPORTANTE ES QUE LA INFORMACION QUE RECIBIMOS EN EL SERVIDOR SIEMPRE
				//ES EN FORMATO STRING
				
				System.out.println("SERVIDOR: Me ha llegado del cliente: "+ stringRecibido);
				String[] operadores = stringRecibido.split("-");
				
				int numero1 = Integer.parseInt(operadores[0]);
				int numero2 = Integer.parseInt(operadores[1]);
				int operador = Integer.parseInt(operadores[2]);
				
				int resultado = 0;
				
				if(operador == 1) {
					
					resultado = numero1+numero2;
					
				}else if(operador == 2) {
					
					resultado = numero1 - numero2;
				
				}else if(operador == 3) {
					
					resultado = numero1 * numero2;
					
				}else if(operador == 4) {
					
					resultado = numero1 / numero2;
					
				}else {
					
					System.out.println("HA INTRODUCIDO UNA OPCIO NO COMPUTABLE");
					resultado = 0;
					
				}
				
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println(resultado);
				
			}
			
			
		} catch (IOException excepcion) {
			
			System.out.println(excepcion);
			
		}finally {
			try {
				if(salida !=null && entrada !=null) {
					
					salida.close();
					entrada.close();
					socketConexion.close();
					
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
