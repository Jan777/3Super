package personaje;

import java.awt.Point;

public class Humano extends Personaje{
	
	public Humano(String name) {
		
			
			super();
			super.setSpritePath("/servidor/src/main/resources/Sprites/GIF/Humano/Programador/HumanoProgramadorQuieto.gif");
		
		
	}

	@Override
	public boolean puedeAtacar() {
		return energia >= 10;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Point p) {
		// TODO Auto-generated method stub
		
	}




	
}
