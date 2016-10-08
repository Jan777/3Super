package equipamiento;

import personaje.*;

public class ConParlantesThonetVander extends PersonajeEquipado{
	public ConParlantesThonetVander(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
