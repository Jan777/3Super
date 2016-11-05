package equipamiento;

import personaje.*;

public class ConMonitorSamsung extends PersonajeEquipado{
	public ConMonitorSamsung(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() *3;
	}
}
