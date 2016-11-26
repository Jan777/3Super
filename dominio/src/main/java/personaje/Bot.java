package personaje;

import java.awt.Point;

public class Bot extends Personaje{

	public Bot()
	{
		super();
		super.setSpritePath("<Hardcodee el sprite aqui>");
	}
	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}



	
}
