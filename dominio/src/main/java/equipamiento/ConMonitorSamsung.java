package equipamiento;

import personaje.Personaje;

public class ConMonitorSamsung extends PersonajeEquipado{
	public ConMonitorSamsung(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeFuerza() {
		return super.obtenerPuntosDeFuerza() *3;
	}


}
