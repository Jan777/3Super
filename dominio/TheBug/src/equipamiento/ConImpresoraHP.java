package equipamiento;

import personaje.*;

public class ConImpresoraHP extends PersonajeEquipado{
	public ConImpresoraHP(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
