package equipamiento;

import personaje.*;

public class ConParlantesOver extends PersonajeEquipado{
	public ConParlantesOver(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
	
	@Override
	public int calcularPuntosDeDefensa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcularPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
	}
}
