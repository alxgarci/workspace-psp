package main;

import entidad.Arma;
import entidad.Curandero;
import entidad.Espada;
import entidad.Guerrero;
import entidad.Hechizo;
import entidad.Personaje;

public class Videojuego {
	public static void main(String[] args) {
		
		Guerrero g1 = new Guerrero();
		g1.setNombre("Guerrero del Clash of Clans");
		g1.setFuerza(20);
		g1.setVida(90);
		Arma gEspada = new Espada();
		gEspada.setDmgMax(35);
		gEspada.setDmgMin(22);
		gEspada.setTipo("Metal del bueno");
		g1.setArma(gEspada);
		g1.setIniciativa(12);
		
		Curandero c1 = new Curandero();
		c1.setNombre("Sanadora");
		c1.setVida(110);
		c1.setIniciativa(9);
		Arma cHechizo = new Hechizo();
		cHechizo.setDmgMax(25);
		cHechizo.setDmgMin(22);
		cHechizo.setTipo("Rabia");
		c1.setArma(cHechizo);
		
		Personaje pGanador = null;
		
		boolean muerte = false;
		while (!muerte) {
			g1.atacar(c1);
			if (c1.getVida() <= 0) {
				pGanador = g1;
				muerte = true;
				System.out.println(c1.getNombre() + " murió");
			} else {
				c1.atacar(g1);
				if (g1.getVida() <= 0) {
					pGanador = c1;
					muerte = true;
					System.out.println(g1.getNombre() + " murió");
				}
			}
		}
		
		System.out.println("El ganador es: " + pGanador);
	}

}
