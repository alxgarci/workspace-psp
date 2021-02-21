package uem.dam.ej1;

public class Direccion {
	private String tipoVia;
	private String nombre;
	private int cp;
	private int num;
	
	public Direccion(String tipoVia, String nombre, int cp, int num) {
		super();
		this.tipoVia = tipoVia;
		this.nombre = nombre;
		this.cp = cp;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Direccion [tipoVia=" + tipoVia + ", nombre=" + nombre + ", cp=" + cp + ", num=" + num + "]";
	}
	
	
	
	

}
