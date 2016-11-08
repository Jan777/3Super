package servidor;

import java.util.ArrayList;

import personaje.Atacable;

//Toda entidad que pueda ser atacxable tiene que estar registrada en al menos una alianza. 
//El juego va a tener muchos de estos mapas logicos, uno para cada tipo, y tiene que permitir cambiarse de una alianza a la otra.
public class MapaAlianza extends MapaLogico {
	
	private String nombre;
	private String pathSprite;
	
	private ArrayList<Atacable> miembros;
	
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
		return ma.nombre != this.nombre;
	}
	
	
	

	
}
