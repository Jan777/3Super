package personaje;

public class Holograma extends Personaje{

	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}

	@Override
	public String getSpritePath() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
