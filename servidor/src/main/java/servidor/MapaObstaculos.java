package servidor;

import java.util.Random;

import output.Sprite;
import servidor.Obstaculo;

public class MapaObstaculos extends MapaLogico {
	private static final long serialVersionUID = 1L;
	
	Obstaculo[][] obstaculos;

	MapaObstaculos(int w, int h, double razon){
		this.w=w;
		this.h=h;
		this.razon=razon;
		this.rnd=new Random();
		razon -= 0.5;
		razon=Math.max(razon, -0.5);
		razon=Math.min(razon, 0.5);
		obstaculos = new Obstaculo[w][h];
		for (int i=0 ; i<this.w; i++)
			for (int j=0 ; j<this.h; j++)
				obstaculos[i][j]= new Obstaculo(i,j,rnd.nextDouble()>razon?1:0);
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
