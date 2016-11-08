package equipamiento;

import personaje.*;
import output.Sprite;

public class ConImpresoraKodak extends PersonajeEquipado{
	public ConImpresoraKodak(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() - 10;
	}

	@Override
	public String getSpritepath() {
		
		return this.personajeDecorado.getSpritePath();
	}

	@Override
	public Sprite getSprite() {
		return this.personajeDecorado.getSprite();
	}



}
