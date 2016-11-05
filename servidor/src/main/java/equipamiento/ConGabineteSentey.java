package equipamiento;

import personaje.*;

public class ConGabineteSentey extends PersonajeEquipado {
	
	public ConGabineteSentey(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() + 5;
	}

}
