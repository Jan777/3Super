package comunicacion;

import personaje.Personaje;

public class Credenciales{
	public String getNombre() {
		return nombre;
	}

	public String getPass() {
		return pass;
	}

	String nombre;
	String pass;

	public Credenciales(String nom, String pass){
		this.nombre=nom;
		this.pass=pass;

		
	}
	
	public Mensaje empaquetar(int id){
		return new Mensaje (id,0,this);
	}

}
