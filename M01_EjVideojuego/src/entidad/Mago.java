package entidad;

public class Mago extends Personaje {
	
	private int inteligencia;
	
	@Override
	public void atacar(Personaje p) {
		int dmg = getArma().usar();
		if (getArma() instanceof Hechizo) {
			dmg += inteligencia;
		}
		p.setVida(p.getVida() - dmg);
		System.out.println(this.getNombre() + " Hace " + dmg + " dmg");
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	
}
