package equipamiento;

import personaje.*;

public class ConImpresoraKodak extends PersonajeEquipado{
	public ConImpresoraKodak(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() - 10;
	}

	@Override
	public String getSpritepath() {
		// TODO Auto-generated method stub
		return null;
	}


}
