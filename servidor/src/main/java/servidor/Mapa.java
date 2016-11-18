package servidor;

public class Mapa {
	
	int ancho, //pixeles
		alto, //pixeles
		nceldas, //cantidad de celdas por lado del mapa
		resolucion; //cantidad de pixeles por lado de la celda
	
	SpriteSheet Sprites;
	Mapa()
	{
		ancho=alto=1024;
		nceldas=resolucion=32;
	}

}
