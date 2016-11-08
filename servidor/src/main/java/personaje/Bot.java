package personaje;

public class Bot extends Personaje{

	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}

	@Override
	public String getSpritePath() {
		return super.getSpritePath();
	}


	
}
