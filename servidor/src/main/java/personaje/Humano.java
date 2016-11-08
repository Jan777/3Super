package personaje;

public class Humano extends Personaje{
	
	public Humano(String name) {
		
	}

	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}

	@Override
	public String getSpritePath() {
		return super.getSpritePath();
	}



	
}
