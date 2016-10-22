package equipamiento;

import personaje.*;
public class ConGabineteThermaltake extends PersonajeEquipado{
	public ConGabineteThermaltake(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() *2;
	}

}
