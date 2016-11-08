package npc;

import output.Sprite;

public class Resistencia extends Npc{
	public Resistencia() {
		super();
		this.nombre="Resistencia";
		this.salud=this.nivel*100;
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
	public void revivir() {
	
	}
	
	public Sprite getSprite()
	{
		return super.getSprite();
	}
	
}
