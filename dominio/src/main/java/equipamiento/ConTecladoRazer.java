package equipamiento;

import personaje.*;

public class ConTecladoRazer extends PersonajeEquipado{
	public ConTecladoRazer(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	public int obtenerPuntosDeFuerza() {
		return super.obtenerPuntosDeFuerza() +20;
	}

}
