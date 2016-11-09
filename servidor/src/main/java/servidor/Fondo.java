package servidor;

import output.Sprite;

public class Fondo extends MapaLogico {

	Sprite tileset;
	Fondo()
	{
		super(32,32,0); //Hago el fondo sin obstaculos.
		tileset = new Sprite("tilesetpath");
		
	}
	@Override
	public boolean ocupada(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Sprite getSprite(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
