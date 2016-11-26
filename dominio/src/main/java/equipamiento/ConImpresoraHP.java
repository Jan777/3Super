package equipamiento;

import personaje.Personaje;

public class ConImpresoraHP extends PersonajeEquipado{
	public ConImpresoraHP(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() *2;
	}





}
