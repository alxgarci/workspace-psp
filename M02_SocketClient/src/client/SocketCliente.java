package client;

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
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE         ");
		System.out.println("-----------------------------------");
		
		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;
		
		InetSocketAddress direccionServer = new InetSocketAddress(IP_SERVER, PUERTO);
		Scanner sc = new Scanner(System.in);
		
		try {
			
			boolean continuar = true;
			
			while (continuar) {
				socketCliente = new Socket();
				socketCliente.connect(direccionServer);
				System.out.println("Conexión establecida... a " + IP_SERVER + " por el puerto " + PUERTO);
				
				entrada = new InputStreamReader(socketCliente.getInputStream());
				salida = new PrintStream(socketCliente.getOutputStream());
				
				System.out.println("Introduzca los numeros\n");
				String num1 = sc.nextLine();
				String num2 = sc.nextLine();
				
				System.out.println("Introduzca la operacion a realizar:");
				System.out.println(" 0- Suma");
				System.out.println(" 1- Resta");
				System.out.println(" 2- Multiplicacion");
				System.out.println(" 3- Division\n");
				String operacion = sc.nextLine();
				
				String operandos = num1 + "-" + num2 + "-" + operacion;
				salida.println(operandos);
				
				BufferedReader bf = new BufferedReader(entrada);
				
				String lineaRecibida = bf.readLine();
				System.out.println("CLIENTE: El servidor me ha respondido: " + lineaRecibida);
				
				System.out.println("Continuar? (S/N)");
				if (sc.nextLine().equalsIgnoreCase("n")) {
					continuar = false;
				}
				
			}
		} catch (UnknownHostException e) {
			System.out.println("[[ No encuentro el servidor en la dirección " + IP_SERVER + " ]]");
		} catch (IOException e) {
			System.out.println("[[ Error de entrada/salida ]]");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
