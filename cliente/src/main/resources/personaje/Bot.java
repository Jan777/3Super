package personaje;

public class Bot extends Personaje{
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcularPuntosDeEnergia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calcularPuntosDeIngenio() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void revivir() {
		// TODO Auto-generated method stub
		
	}
}
