package entidad;

public class Guerrero extends Personaje {
	
	private int fuerza;
	
	@Override
	public void atacar(Personaje p) {
		System.out.println("TE TENGOO");
		int dmg = getArma().usar();
		if (getArma() instanceof Espada || getArma() instanceof Arco) {
			dmg += fuerza;
		}
		p.setVida(p.getVida() - dmg);
		System.out.println(this.getNombre() + " Hace " + dmg + " dmg");
		
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

}
