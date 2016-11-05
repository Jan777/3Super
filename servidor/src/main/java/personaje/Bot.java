package personaje;

public class Bot extends Personaje{

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
		return 0;
	}

	@Override
	public int calcularPuntosDeEnergia() {
		return 0;
	}

	@Override
	public int calcularPuntosDeIngenio() {
		return 10;
	}

	@Override
	public void revivir() {
		
	}
}
