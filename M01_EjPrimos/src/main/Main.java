package main;

public class Main {
	
	public static void main(String[] args) {
		PrimoRunnable hilo1 = new PrimoRunnable(34);
		Thread h1 = new Thread(hilo1);
		h1.setName("numero1");
		
		PrimoRunnable hilo2 = new PrimoRunnable(11);
		Thread h2 = new Thread(hilo2);
		h2.setName("numero2");
		
		PrimoRunnable hilo3 = new PrimoRunnable(22);
		Thread h3 = new Thread(hilo3);
		h3.setName("numero3");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		h1.start();
		h2.start();
		h3.start();
	}

}
