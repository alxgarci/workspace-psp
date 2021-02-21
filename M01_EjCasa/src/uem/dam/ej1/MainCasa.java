package uem.dam.ej1;

import java.util.ArrayList;

public class MainCasa {

	public static void main(String[] args) {
		
		Habitacion h1 = new Habitacion(12, TipoHab.ATICO);
		Habitacion h2 = new Habitacion(24, TipoHab.COCINA);
		Direccion d1 = new Direccion("Calle", "arco", 23424, 12);
		Direccion d2 = new Direccion("Avenida", "Barcelona", 23032, 9);
		Inquilino i1 = new Inquilino("Alejandro", 20, "aoisdjap", d1);
		Inquilino i2 = new Inquilino("Ricardo", 12, "asdasdasd", d2);
		Propietario p1 = new Propietario("Alfonso", 12, "123123P", d1);
		
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		listaHabitaciones.add(h1);
		listaHabitaciones.add(h2);
		
		ArrayList<Inquilino> listaInquilinos = new ArrayList<Inquilino>();
		listaInquilinos.add(i1);
		listaInquilinos.add(i2);
		
		
		Casa c1 = new Casa(listaHabitaciones, listaInquilinos, p1, d1, 130);
		System.out.println(c1.toString());
		
		
	}

}
