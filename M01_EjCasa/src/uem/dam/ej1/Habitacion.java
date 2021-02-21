package uem.dam.ej1;

public class Habitacion {
	private double m2;
	private TipoHab tipoHab;
	
	public Habitacion(double m2, TipoHab tipoHab) {
		super();
		this.m2 = m2;
		this.tipoHab = tipoHab;
	}

	@Override
	public String toString() {
		return "Habitaciones [m2=" + m2 + ", tipoHab=" + tipoHab + "]";
	}

	public double getM2() {
		return m2;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}

	public void setTipoHab(TipoHab tipoHab) {
		this.tipoHab = tipoHab;
	}
	
	

}
