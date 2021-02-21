package uem.dam.ej1;

public class Propietario {
	private String nombre;
	private int edad;
	private String dni;
	private Direccion direccion;
	
	public Propietario(String nombre, int edad, String dni, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Inquilino [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", direccion=" + direccion + "]";
	}


}
