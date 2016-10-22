package equipamiento;

import personaje.*;

public class ConMouseThermaltake extends PersonajeEquipado{
	public ConMouseThermaltake(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() *2;
	}
}
