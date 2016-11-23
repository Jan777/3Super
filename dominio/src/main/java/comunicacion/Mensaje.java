package comunicacion;

import java.io.IOException;
import java.io.Serializable;

public class Mensaje {
	
	int idEmisor;
	int idReceptor;
	Object msg;
	
	Mensaje(int idEmisor, int idReceptor, Object paquete){
		this.idEmisor=idEmisor;
		this.idReceptor=idReceptor;
		empaquetar (paquete);
	}
	
	
	void empaquetar(Object Mensaje) {
		msg = Mensaje;
	}
	
	public Object desenpaquetar(){
		return msg;
	}
	
	boolean SoyReceptor(int id){
		return id==idReceptor? true:false;
	}
	
	boolean SoyEmisor(int id){
		return id==idEmisor? true:false;
	}
	

	
	

	
}
