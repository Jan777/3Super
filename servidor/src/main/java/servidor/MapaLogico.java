package servidor;

import java.util.Random;

public class MapaLogico {
	int w,h;
	boolean celdas[][];
	Random rnd;
	public MapaLogico()
	{
		w=32;
		h=32;
		rnd = new Random();
		celdas= new boolean[w][h];
		
		for (int i=0; i < h; i++) 
			for (int j=0; j < w; j++) 
				celdas[i][j]= (rnd.nextDouble()+0.5)>1;
	}
	
	public boolean ocupada(int x, int y)
	{
		return celdas[x][y];
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}
	
	public String toString()
	{
		String aux = new String("");
		for (int i=0; i < h; i++) {
			for (int j=0; j < w; j++) 
				if (celdas[i][j]) aux += "*";
				else aux += ".";
		aux+= '\n';}
		return aux;
	}
	
	

}
