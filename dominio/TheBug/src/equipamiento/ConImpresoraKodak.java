package equipamiento;

import personaje.*;

public class ConImpresoraKodak extends PersonajeEquipado{
	public ConImpresoraKodak(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
