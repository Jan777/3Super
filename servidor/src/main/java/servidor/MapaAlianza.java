package servidor;

import java.util.ArrayList;

import output.Sprite;
import personaje.Atacable;

//Toda entidad que pueda ser atacxable tiene que estar registrada en al menos una alianza. 
//El juego va a tener muchos de estos mapas logicos, uno para cada tipo, y tiene que permitir cambiarse de una alianza a la otra.
public class MapaAlianza extends MapaLogico {
	
	private String nombre;
	private ArrayList<Atacable> miembros;
	
	public MapaAlianza(String n)
	{
		super(32,32,0);
		this.nombre=n;
		miembros= new ArrayList<Atacable>();
		
	}
	
	
	
	
	public void addMiembro(Atacable a)
	{
		miembros.add(a);
	}
	public void removeMiembro(Atacable a)
	{
		miembros.remove(a);
	}
	public void switchAlianza(Atacable a, MapaAlianza ma)
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
		// TODO Auto-generated method stub
		return null;
	}


	
	
	

	
}
