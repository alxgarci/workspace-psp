package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) throws InterruptedException{
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");
		
		ServerSocket serverSocket = null;
		
		Socket socketConexion = null;
		
		PrintStream salida = null;
		InputStreamReader entrada = null;
		
		try {
			serverSocket = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER,PUERTO);
			serverSocket.bind(direccion);
			
			while (true) {
				System.out.println("SERVIDOR: Esperando peticion...");
				
				socketConexion = serverSocket.accept();
				
				entrada = new InputStreamReader(socketConexion.getInputStream());
				
				BufferedReader bf = new BufferedReader(entrada);
				
				String stringRecibido = bf.readLine();
				
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] operadores = stringRecibido.split("-");
				int num1 = Integer.parseInt(operadores[0]);
				int num2 = Integer.parseInt(operadores[1]);
				int operacion = Integer.parseInt(operadores[2]);
				int resultado = 0;
				
				switch (operacion) {
				case 0:
					resultado = num1+num2;
					break;
				case 1:
					resultado = num1-num2;
					break;
				case 2:
					resultado = num1*num2;
					break;
				case 3:
					resultado = num1/num2;
					break;
				default:
					break;
				}
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println(resultado);
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (salida != null && entrada != null) {
					salida.close();
					entrada.close();
					socketConexion.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
