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

	@Override
	public String getSpritepath() {
		// TODO Auto-generated method stub
		return null;
	}



}
