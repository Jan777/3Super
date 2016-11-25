package partida.entidades.sprites;

import partida.Handler;
import partida.entidades.Entity;

public abstract class EntidadSprite extends Entity {
	
	public EntidadSprite(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
	}

}
