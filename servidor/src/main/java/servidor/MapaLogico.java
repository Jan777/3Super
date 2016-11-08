package servidor;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

// Aunque se puede usar por si misma, la idea es heredar de mapa logico. Esta clase sirve para saber si  cada celda esta ocupada o no.
public class MapaLogico extends Observable{
	int w,h;
	boolean celdas[][];
	Random rnd;
	public MapaLogico()
	{
		super();
		
		w=32;
		h=32;
		rnd = new Random();
		celdas= new boolean[w][h];
		
		for (int i=0; i < h; i++) 
			for (int j=0; j < w; j++) 
				celdas[i][j]= (rnd.nextDouble()+0.5)>1;
	}
	
	public MapaLogico(double razon) //rango va desde 0% hasta 100%
	{
		super();
		
		razon -= 0.5;
		
		razon=Math.max(razon, -0.5);
		
		razon=Math.min(razon, 0.5);
		
		w=32;
		h=32;
		rnd = new Random();
		celdas= new boolean[w][h];
		
		for (int i=0; i < h; i++) 
			for (int j=0; j < w; j++) 
				celdas[i][j]= (rnd.nextDouble()+razon)>1;
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
	
	public String toString() //Para test de generacion
	{
		String aux = new String("");
		for (int i=0; i < h; i++) {
			for (int j=0; j < w; j++) 
				if (celdas[i][j]) aux += "*";
				else aux += ".";
		aux+= '\n';}
		return aux;
	}
	
	public void monitorear(Observer o)
	{
		this.addObserver(o);
	}
	
	
	
	
	
	

}
