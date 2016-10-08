package equipamiento;

import personaje.*;

public class ConMonitorSamsung extends PersonajeEquipado{
	public ConMonitorSamsung(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
