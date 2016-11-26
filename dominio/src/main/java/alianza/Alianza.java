package alianza;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import personaje.Personaje;

public class Alianza {

	private static int CONTALIANZA = 1; 
	private ArrayList <Personaje> integrantes; 
	private String nombre;
	private int id;
	
	
	public Alianza(String nombre){
		integrantes = new ArrayList<Personaje>();
		this.nombre=nombre;
	}

	public Alianza(){
		//nombre=nombreParametro;
		integrantes = new ArrayList<Personaje>();
		id = this.obtenerProxAlianza();
		

	}

	private int obtenerProxAlianza(){
		return CONTALIANZA++;
	}
	
	public void añadirPerAAlianza(Personaje p){
		Calendar actual = Calendar.getInstance();
		integrantes.add(p);
		p.setAlianzaAct(this);
		p.setLimiteMinimoPermanenciaAlianza(actual);

	}
	
	public void eliminarAlianza(){
		Iterator<Personaje> iter = integrantes.iterator();
		while (iter.hasNext()) 	{
			Personaje user = iter.next();
			user.setAlianzaAct(null);
		}

		this.integrantes.clear();

	}

	public int cantMiembrosQueHayAlianza(){
		return this.integrantes.size();
	}

	public ArrayList<Personaje> obtenerIntegrantes() {
		return integrantes;
	}

}
