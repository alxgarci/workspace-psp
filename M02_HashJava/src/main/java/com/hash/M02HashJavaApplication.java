package com.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hash.modelo.entidad.User;
import com.hash.modelo.persistencia.DaoUser;

@SpringBootApplication
public class M02HashJavaApplication {
	
	private static DaoUser daoUser;
	static Scanner sc;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(M02HashJavaApplication.class, args);
		
		daoUser = context.getBean("daoUser", DaoUser.class);
		sc = new Scanner(System.in);
		
		String op = "";
		
		while (!op.equalsIgnoreCase("S")) {
			
			op = mostrarMenu();
			
			switch (op.toUpperCase()) {
			
			case "LOG":
				try {
					if (logIn() == 1) {
						System.out.println("[ERROR] No se han encontrado el usuario y/o contraseña");
					} else {
						op = "S";
					}					
				} catch (NoSuchAlgorithmException e) {
					System.out.println("[ERROR] No se encuentra el algoritmo");
					e.printStackTrace();
				}
				break;
			case "SIGN":
				try {
					signUp();
				} catch (NoSuchAlgorithmException e) {
					System.out.println("[ERROR] No se encuentra el algoritmo");
					e.printStackTrace();
				}
				break;
			case "S":
				System.out.println("[INFO] Saliendo del programa...");
				break;
			default:
				System.out.println("[ERROR] Introduce una de las opciones aceptadas");
				break;
			}
		}
		sc.close();
		
	}

	private static int logIn() throws NoSuchAlgorithmException {
		System.out.println("Username");
		System.out.print("> ");
		String username = sc.nextLine().toLowerCase();
		
		System.out.println("Password");
		System.out.print("> ");
		String pwd = sc.nextLine();
		
		User user = daoUser.findByUsernameAndPwd(username, pwdToHex(pwd));
		
		if (user != null) {
			System.out.println("[SYS] Logueado correctamente");
			System.out.println("[SYS] " + username);
			return 0;
		} else {
			return 1;
		}
		
		
	}

	private static String pwdToHex(String pwd) throws NoSuchAlgorithmException {
		byte[] pwdByte = pwd.getBytes();
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(pwdByte);
		
		String pwdHex = DatatypeConverter.printHexBinary(md.digest());
		return pwdHex;
	}

	private static void signUp() throws NoSuchAlgorithmException {
		System.out.println("Username");
		System.out.print("> ");
		String username = sc.nextLine().toLowerCase();
		
		System.out.println("Password");
		System.out.print("> ");
		String pwd = sc.nextLine();
		
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwdToHex(pwd));
		
		daoUser.save(user);
		
		System.out.println("[SYS] " + username + " registrado correctamente");
		
		
		
	}

	private static String mostrarMenu() {
		System.out.println("");
		System.out.println("[MENU] Introduce uno de los comandos listados");
		System.out.println("  LOG - Loguearte");
		System.out.println("  SIGN - Registrarte");
		System.out.println("  S - Salir de la ejecución");
		System.out.print("> ");
		String op = sc.nextLine();
		System.out.println("");
		return op;
	}

}
