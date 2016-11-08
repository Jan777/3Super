package equipamiento;

import personaje.*;

public class ConImpresoraHP extends PersonajeEquipado{
	public ConImpresoraHP(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() *2;
	}

	@Override
	public String getSpritepath() {
		// TODO Auto-generated method stub
		return null;
	}


}
