package servidor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observer;

import output.Sprite;
import personaje.Atacable;
import personaje.Personaje;

//Toda entidad que pueda ser atacable tiene que estar registrada en al menos una alianza. 
//El juego va a tener muchos de estos mapas logicos, uno para cada tipo, y tiene que permitir cambiarse de una alianza a la otra.
public class MapaAlianza extends MapaLogico {
	
	private String nombre;
	private ArrayList<Personaje> miembros; //TODO: Redefinir como array Bi-dimensional, como deberia haber sido desde el comienzo
	
	public MapaAlianza(String n)
	{
		super(32,32,0);
		this.nombre=n;
		miembros= new ArrayList<Personaje>();
		
	}
	
	public void RegistrarAlianza(Observer o){
		for (Personaje p : miembros){
			p.addObserver(o);
		}
	}
	
	
	public void addMiembro(Personaje a)
	{
		miembros.add(a);
	}
	public void removeMiembro(Personaje a)
	{
		miembros.remove(a);
	}
	public void switchAlianza(Personaje a, MapaAlianza ma)
	{
		if (ma.miembros.contains(a))
			ma.removeMiembro(a);
		this.addMiembro(a);
	}
	public boolean esHostil(MapaAlianza ma)
	{
		return ma.nombre != this.nombre; //O estas con Nosotros, o estas contra Nosotros. 
	}


	@Override
	public boolean ocupada(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public Sprite getSprite(int x, int y) {
		for (Atacable a : miembros){
			if (a.getPosition()==new Point(x,y))
				return a.getSprite();
		}
		return null;
	}


	public void procesar() {
		// TODO Auto-generated method stub
		
		for (Personaje p : miembros){
			p.step();
		}
		
	}


	
	
	

	
}
