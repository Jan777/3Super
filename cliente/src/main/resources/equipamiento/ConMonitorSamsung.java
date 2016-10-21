package equipamiento;

import personaje.*;

public class ConMonitorSamsung extends PersonajeEquipado{
	public ConMonitorSamsung(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return 0;
	}
	
	@Override
	public int calcularPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() + 5;
	}
	
	@Override
	public int calcularPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
	}
}
