package personaje;

public class Holograma extends Personaje{
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
}
