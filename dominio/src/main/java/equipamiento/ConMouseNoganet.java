package equipamiento;

import personaje.*;

public class ConMouseNoganet extends PersonajeEquipado{
	
	public ConMouseNoganet(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeFuerza() {
		return super.obtenerPuntosDeFuerza() - 10;
	}


}
