package personaje;

public abstract class Personaje implements Atacable {
	protected String nombre;
	protected int salud;
	protected int energia;
	protected int fuerza;
	protected int ingenio;
	//protected int saludpornivel=this.nivel*10;
	//protected int energiapornivel=this.nivel*10;
	//protected int fuerzapornivel=this.nivel*10;
	//protected int ingeniopornivel=this.nivel*10;
	protected boolean sexo;
	protected int nivel = 1;
	protected int topeExperienciaNivel = 100; //nivel 1 necesita 100 de exp. despues se actualiza en subirDeNivel()
	protected int experiencia = 0;
	
	
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
		if( this.experiencia + experienciaObtenida >= topeExperienciaNivel){
			this.experiencia = this.experiencia + experienciaObtenida - topeExperienciaNivel;
			subirDeNivel();
		}
		else{
			this.experiencia += experienciaObtenida;
		}
	}
	
	protected void subirDeNivel(){
		if(this.nivel < 32){
			this.nivel++;
			this.topeExperienciaNivel = nivel*100;
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

	//CLASE pelea
	//metodo turno(jugador1)
	//{ atacar.jugador2();
	//  estavivo?
	//  desaparecer de la pantalla.
	//  sino pasar el turno a otro.

	public void serCurado() {
		this.salud = 490 + this.nivel*10; //Le agregue el 490
	}

	public void serEnergizado() {
		this.energia = 490 + this.nivel*10; //Le agregue el 490
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	///////////////////////
	
	public int obtenerPuntosDeAtaque() {
		return 10+this.fuerza;
	}

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

	@Override
	public int darExperiencia() {
		return this.nivel*10;
	}

	public int getTopeExperienciaNivel() {
		return topeExperienciaNivel;
	}

	public void setTopeExperienciaNivel(int topeExperienciaNivel) {
		this.topeExperienciaNivel = topeExperienciaNivel;
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
	
	
	
}


