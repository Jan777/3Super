package equipamiento;

import personaje.*;

public class ConParlantesOver extends PersonajeEquipado{
	public ConParlantesOver(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
