package personaje;

public class Bot extends Personaje{

	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}

	@Override
	public String getSpritepath() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
