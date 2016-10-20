package personaje;

public class Humano extends Personaje{
	
	public Humano(String name) {
		
		this.nombre = name;
		this.salud = 500; //LO HARCODEO DESPUES VEMOS ALGUNA OTRA MANERA
		this.energia = 500;
		this.fuerza = 30;
		this.nivel = 1;
		this.experiencia = 0;
		//this.ingeniopornivel  QUE VENDRIA A REPRESENTAR??
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return 10;
	}

	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return 0;
	}

	@Override
	public int calcularPuntosDeSalud() {
		return 10;
	}

	@Override
	public int calcularPuntosDeEnergia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcularPuntosDeIngenio() {
		// TODO Auto-generated method stub
		return 0;
	}
}
