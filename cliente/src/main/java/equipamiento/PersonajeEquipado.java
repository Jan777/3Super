package equipamiento;
import personaje.*;

public abstract class PersonajeEquipado extends Personaje{

	Personaje personajeDecorado;
	int nivelItem;
	String nombre;
	
	public PersonajeEquipado(Personaje personajeDecorado) {
		this.personajeDecorado = personajeDecorado;
	}

	@Override
	public boolean puedeAtacar() {
		return this.personajeDecorado.puedeAtacar();
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return this.personajeDecorado.obtenerPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return this.personajeDecorado.obtenerPuntosDeDefensa();
	}
	
	@Override
	public int calcularPuntosDeSalud() {
		return 0;
	}

	@Override
	public int calcularPuntosDeEnergia() {
		return 0;
	}

	@Override
	public int calcularPuntosDeIngenio() {
		return 0;
	}
	
}
