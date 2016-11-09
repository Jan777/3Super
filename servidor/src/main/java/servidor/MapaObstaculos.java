package servidor;

import output.Sprite;
import servidor.Obstaculo;

public class MapaObstaculos extends MapaLogico {
	
	Obstaculo[][] obstaculos;

	MapaObstaculos(int w, int h, double razon){
		
		this.w=w;
		this.h=h;
		this.razon=razon;
		razon -= 0.5;
		razon=Math.max(razon, -0.5);
		razon=Math.min(razon, 0.5);
		obstaculos = new Obstaculo[w][h];
		for (Obstaculo[] fila : obstaculos)
			for (Obstaculo o : fila)
				o.setid(super.rnd.nextDouble()>razon?1:0);
		
		
	}
	@Override
	public boolean ocupada(int x, int y) {
	
		return obstaculos[x][y].getOcupado();
	}
	
	public Sprite getSprite(int x, int y){
//		if (obstaculos[x][y].getOcupado())
			return obstaculos[x][y].getSprite();
		
	}
}
