package uem.dam.ej1;

import java.util.ArrayList;

public class Casa {
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Inquilino> listaInquilinos;
	private Propietario propietario;
	private Direccion direccion;
	private double precio;
	
	public Casa(ArrayList<Habitacion> habitaciones, ArrayList<Inquilino> inquilinos, Propietario propietario, Direccion direccion,
			double precio) {
		super();
		this.listaHabitaciones = habitaciones;
		this.listaInquilinos = inquilinos;
		this.propietario = propietario;
		this.direccion = direccion;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "Casa [habitaciones=" + listaHabitaciones.toString() + "\n, inquilinos=" + listaInquilinos.toString()
				+ "\n, propietario=" + propietario + "\n, direccion=" + direccion + "]" + "\n precio:" + precio + "\n m2 = " + metrosCuadrados();
	}
	
	public double metrosCuadrados() {
		double m2 = 0;
		for (int i = 0; i < listaHabitaciones.size(); i++) {
			m2 += listaHabitaciones.get(i).getM2();
		}
		return m2;
		
	}
}
