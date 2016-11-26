package equipamiento;
import personaje.*;


public abstract class PersonajeEquipado extends Personaje{ //TODO: no me esta convenciendo extender personaje. Capaz una clase llamada equipo y que sea un atributo de personaje? Asi como esta, un equipamiento tiene que poder moverse, atacar, etc.

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

}
