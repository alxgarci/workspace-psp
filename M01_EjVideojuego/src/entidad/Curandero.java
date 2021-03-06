package entidad;

public class Curandero extends Personaje{
	
	private int sabiduria;
	
	@Override
	public void atacar(Personaje p) {
		System.out.println("YA ESTA AQUI EL CURANDEROO");
		int dmg = getArma().usar();
		if (getArma() instanceof Rezo) {
			dmg += sabiduria;
		}
		p.setVida(p.getVida() - dmg);
		System.out.println(this.getNombre() + " Hace " + dmg + " dmg");
		
	}

}
