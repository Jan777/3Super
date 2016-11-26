package personaje;

import java.awt.Point;

public class Holograma extends Personaje{
	
	public Holograma()
	{
		
			super();
			super.setSpritePath("<Hardcodee el sprite aqui>");
		
	}

	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}




	
}
