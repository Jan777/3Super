package equipamiento;

import personaje.*;

public class ConMouseNoganet extends PersonajeEquipado{
	public ConMouseNoganet(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
