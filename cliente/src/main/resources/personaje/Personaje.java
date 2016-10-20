package personaje;

public abstract class Personaje implements Atacable {
	protected String nombre;
	protected int salud;
	protected int energia;
	protected int fuerza;
	protected int ingenio;
	protected int saludpornivel=this.nivel*10;
	protected int energiapornivel=this.nivel*10;
	protected int fuerzapornivel=this.nivel*10;
	protected int ingeniopornivel=this.nivel*10;
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
	
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	@Override
	public void serAtacado(int daño) {
		this.salud -= daño;
		//this.salud -= ((this.obtenerPuntosDeDefensa()/10)*daño);
	}

	public void serCurado() {
		this.salud = this.saludpornivel;
	}

	public void serEnergizado() {
		this.energia = this.energiapornivel;
	}
	
	public int getSalud() {
		return this.salud;
	}
	
///////////////////////
	
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque()+this.fuerza;
	}
	public abstract int calcularPuntosDeAtaque();
	
	/////////////////////////////
	
	public int obtenerPuntosDeSalud() {
		return calcularPuntosDeSalud()+this.salud;
	}
	public abstract int calcularPuntosDeSalud();
	///////////////////////
	public int obtenerPuntosDeEnergia() {
		return calcularPuntosDeEnergia()+this.energia;
	}
	public abstract int calcularPuntosDeEnergia();
	
	///////////////
	
	public int obtenerPuntosDeIngenio() {
		return calcularPuntosDeIngenio()+this.ingenio;
	}
	public abstract int calcularPuntosDeIngenio();
	
	
	public abstract int obtenerPuntosDeDefensa();

	
	
	
}


