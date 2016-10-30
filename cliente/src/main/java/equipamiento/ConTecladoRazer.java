package equipamiento;

import personaje.*;

public class ConTecladoRazer extends PersonajeEquipado{
	public ConTecladoRazer(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() +20;
	}
}
