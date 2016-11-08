package equipamiento;

import personaje.*;

public class ConTecladoRazer extends PersonajeEquipado{
	public ConTecladoRazer(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeFuerza() {
		return super.obtenerPuntosDeFuerza() +20;
	}

	@Override
	public String getSpritepath() {
		// TODO Auto-generated method stub
		return null;
	}

}
