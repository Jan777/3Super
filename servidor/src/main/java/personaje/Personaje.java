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
	protected String SpritePath;
	
	public abstract String getSpritepath();
	public final boolean atacar(Atacable atacado) {
		if (puedeAtacar() && atacado.estaVivo()) {
			atacado.serAtacado(this.obtenerPuntosDeAtaque());
			energia -= this.obtenerPuntosDeAtaque(); // Te cansas despues de atacar
			if(!atacado.estaVivo())
				despuesDeAtacar(atacado.darExperiencia());
			return true;
		}
		return false;
	}

	// Despues de atacar me fijo si subio de nivel con la experiencia obtenida
	// si paso de nivel, la experiencia se me resetea a 0, y me tiene que sumar
	// el resto de experiencia que sobro.
	// sino solamente me suma la experiencia obtenida.
	
	protected void despuesDeAtacar(int experienciaObtenida) {
		if( this.experiencia + experienciaObtenida >= this.getTopeExperienciaNivel()){
			this.experiencia = this.experiencia + experienciaObtenida - getTopeExperienciaNivel();
			subirDeNivel();
		}
		else{
			this.experiencia += experienciaObtenida;
		}
	}
	
	protected void subirDeNivel(){
		if(this.nivel < 32){
			this.nivel++;
		}
	}
	
	//HACER METODO REVIVIR
	//METODO MORIR?? dropea items y luego revive, etc
	//La ENERGIA tendria que subirse cada tanto tiempo si no nunca lo va a terminar de matar
	
	public void revivir() {
		this.serCurado();
		this.serEnergizado();
	}
	
	public abstract boolean puedeAtacar();
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	@Override
	public void serAtacado(int daño) {
		if ( ( daño - (this.obtenerPuntosDeDefensa()) /10 ) > 0)
			this.salud -= (daño - (this.obtenerPuntosDeDefensa()) /10 );
	}


	public void serCurado() {
		this.salud = this.getmaxsalud();
	}

	public void serEnergizado() {
		this.energia = this.getmaxenergia();
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	///////////////////////
	
	public int obtenerPuntosDeAtaque() {
		return getatk() + this.fuerza;
	}

	protected abstract int getatk();

	/////////////////////////////
	
	public int obtenerPuntosDeSalud() {
		return calcularPuntosDeSalud()+getmaxsalud(); // Modificadores + valor inherente
	}
	public abstract int calcularPuntosDeSalud(); //Este metodo sirve para poder calcular el valor de lo0s modificadores.
	///////////////////////
	public int obtenerPuntosDeEnergia() {
		return calcularPuntosDeEnergia()+getmaxenergia(); // Modificadores + valor inherente
	}
	public abstract int calcularPuntosDeEnergia();
	
	///////////////
	
	public int obtenerPuntosDeIngenio() {
		return calcularPuntosDeIngenio()+this.ingenio; // Modificadores + valor inherente
	}
	
	public abstract int calcularPuntosDeIngenio();
	
	public abstract int obtenerPuntosDeDefensa();

	@Override
	public int darExperiencia() {
		return  getExperiencia()/10; //Es igual al anterior em el caso default, y es compatible con otras formulas de experiencia.
	}

	public int getTopeExperienciaNivel() {
		return this.nivel * 100;
	}


	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}
	
	public abstract int getmaxsalud();
	public abstract int getmaxenergia();
	
	
	
}


