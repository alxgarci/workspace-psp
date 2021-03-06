package entidad;

public class Hechizo extends Arma {
	@Override
	public int usar() {
		int dmg = (getDmgMax() + getDmgMin())/2;
		System.out.println("HECHIZO . . .");
		return dmg;
	}

}
