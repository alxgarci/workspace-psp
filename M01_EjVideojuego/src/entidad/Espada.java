package entidad;

public class Espada extends Arma {
	@Override
	public int usar() {
		int dmg = (getDmgMax() + getDmgMin())/2;
		return dmg;
	}
}
