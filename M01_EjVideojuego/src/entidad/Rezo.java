package entidad;

public class Rezo extends Arma {
	@Override
	public int usar() {
		int dmg = (getDmgMax() + getDmgMin())/2;
		System.out.println("PÁRATE PORFAVOR");
		return dmg;
	}

}
