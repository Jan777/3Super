package logica;


import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import output.Sprite;

// Aunque se puede usar por si misma, la idea es heredar de mapa logico. Esta clase sirve para saber si  cada celda esta ocupada o no.
public abstract class MapaLogico extends Observable implements Serializable {
	protected int w,h;
	protected  Random rnd;
	protected double razon=0.5;
	public MapaLogico()
	{
		super();
		
		w=32;
		h=32;
		rnd = new Random();
					
	}
	
	public MapaLogico(int w, int h, double razon) //rango va desde 0% hasta 100%
	{
		super();
		
		razon -= 0.5;
		
		razon=Math.max(razon, -0.5);
		
		razon=Math.min(razon, 0.5);
		
		this.razon=razon;
		this.w=w;
		this.h=h;
		rnd = new Random();
		
	}
	
	public abstract boolean ocupada(int x, int y);
	

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}
	
//	public String toString() //Para test de generacion
//	{
//		String aux = new String("");
//		for (int i=0; i < h; i++) {
//			for (int j=0; j < w; j++) 
//				if (celdas[i][j]) aux += "*";
//				else aux += ".";
//		aux+= '\n';}
//		return aux;
//	}
	
	public void monitorear(Observer o)
	{
		this.addObserver(o);
	}
	
	public abstract Sprite getSprite(int x, int y);
		
	


	

	
	
	
	
	
	

}
