package main;

public class PrimoRunnable implements Runnable {
	
	private int num;
	
	public PrimoRunnable(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println("- - - [NUEVO NÚMERO] - - -");
		
		String nombre = "[" + Thread.currentThread().getName().toUpperCase() + "] ";
		
		System.out.println(nombre + "Arrancando hilo: ");
		
		System.out.println(esPrimo(num) ? num + " Es primo" : num + " No es primo");
		
		System.out.println(nombre + "Fin");
		
	}
	
	public boolean esPrimo(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
