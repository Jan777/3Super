package personaje;

import java.awt.Point;
import java.awt.Rectangle;

public class Humano extends Personaje{
	
	public Humano(String name) {			
		super();
	}

	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}

	
}
