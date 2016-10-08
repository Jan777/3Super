package equipamiento;

import personaje.*;

public class ConMonitorBenq extends PersonajeEquipado{
	public ConMonitorBenq(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
