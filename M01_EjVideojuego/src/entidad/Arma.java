package entidad;

public abstract class Arma {
	private int dmgMin;
	private int dmgMax;
	private String tipo;
	private Personaje personaje;
	
	public abstract int usar();

	public int getDmgMin() {
		return dmgMin;
	}

	public void setDmgMin(int dmgMin) {
		this.dmgMin = dmgMin;
	}

	public int getDmgMax() {
		return dmgMax;
	}

	public void setDmgMax(int dmgMax) {
		this.dmgMax = dmgMax;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	@Override
	public String toString() {
		return "Arma [dmgMin=" + dmgMin + ", dmgMax=" + dmgMax + ", tipo=" + tipo + ", personaje=" + personaje + "]";
	}
}
