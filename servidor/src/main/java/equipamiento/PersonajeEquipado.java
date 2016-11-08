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
	public int obtenerPuntosDeFuerza() {
		return this.personajeDecorado.obtenerPuntosDeFuerza();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return this.personajeDecorado.obtenerPuntosDeDefensa();
	}
	
	@Override
	public int obtenerPuntosDeSalud() {
		return this.personajeDecorado.obtenerPuntosDeSalud();
	}

	@Override
	public int obtenerPuntosDeEnergia() {
		return this.personajeDecorado.obtenerPuntosDeEnergia();
	}

	@Override
	public int obtenerPuntosDeIngenio() {
		return this.personajeDecorado.obtenerPuntosDeIngenio();
	}
	
}
