package alianza;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.management.ImmutableDescriptor;

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

	public void romperAlianza(Personaje personaje){

		Calendar actual = Calendar.getInstance();
	
		if(cantTotalMin(personaje.limiteMinimoPermanenciaAlianza, actual)>=3){
			Iterator<Personaje> iter = integrantes.iterator();
			while (iter.hasNext()) 	{
				Personaje user = iter.next();
				if(user.equals(personaje)) { //con personaje veo el usuario
					user.setAlianzaAct(null);
					iter.remove();
				}
			}
		}
	}
	
	public void generarNuevaAlianza(Personaje personaje){
		Calendar actual = Calendar.getInstance();
		integrantes.add(personaje);
		personaje.setAlianzaAct(this);
		personaje.setLimiteMinimoPermanenciaAlianza(actual);
	}

	public int cantMiembrosQueHayAlianza(){
		return this.integrantes.size();
	}

	public ArrayList<Personaje> obtenerIntegrantes() {
		return integrantes;
	}

	public int obtenerIdAlianza() {
		return id;
	}

	public void setIdAlianza(int idAlianza) {
		this.id = idAlianza;
	}

	public void setIntegrantes(ArrayList<Personaje> integrantes) {
		this.integrantes = integrantes;
	}

	public long cantTotalMin(Calendar tiempIni ,Calendar tiempFin){

		long totalMinutos=0;
		totalMinutos=((tiempFin.getTimeInMillis()-tiempIni.getTimeInMillis())/1000/60);
		return totalMinutos;
	}
	
	public static boolean puedenAtacarse(Personaje p1, Personaje p2){
		
		if(p1.obtenerAlianzaAct() == p2.obtenerAlianzaAct())
			return false;	
		return true;
	}
	 
}
