package npc;

import java.awt.Point;



public class Capacitor extends Npc{
	
	public Capacitor() {
		super();
		nivel=1;
		this.nombre="Capacitor";
		this.salud=this.nivel*100;
	}

	@Override
	public void revivir() {
	
	}

	
	public String getSpritePath(){
		return "/servidor/src/main/resources/Sprites/GIF/Resistencia/CapacitorIzquierda.gif";
	}


}
