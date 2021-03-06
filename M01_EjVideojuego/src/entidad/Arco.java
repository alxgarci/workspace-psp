package entidad;

public class Arco extends Arma {
	@Override
	public int usar() {
		int dmg = (getDmgMax() + getDmgMin())/2;
		return dmg;
	}
}
