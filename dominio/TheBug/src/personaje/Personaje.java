package personaje;

public abstract class Personaje implements Atacable {
	protected String nombre;
	protected int salud;
	protected int energia;
	protected int fuerza;
	protected int ingenio;
	protected boolean sexo;
	protected int nivel = 1;
	protected int experiencia = 0;
	
	
	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(calcularPuntosDeAtaque());
			energia -= calcularPuntosDeAtaque();
			despuesDeAtacar();
		}
	}

	protected void despuesDeAtacar() { }
	
	public abstract boolean puedeAtacar();
	public abstract int calcularPuntosDeAtaque();
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	@Override
	public void serAtacado(int daño) {
		this.salud -= daño;
	}

	public void serCurado() {
		this.salud = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
	}
	
	public int getSalud() {
		return this.salud;
	}

	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}

	public abstract int obtenerPuntosDeDefensa();

	
	
	
}
