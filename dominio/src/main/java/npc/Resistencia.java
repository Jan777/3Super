package npc;

import java.awt.Point;


public class Resistencia extends Npc{
	public Resistencia() {
		super();
		nivel=1;
		this.nombre="Resistencia";
		this.salud=this.nivel*100;
	}

	@Override
	public void revivir() {
	
	}

}
