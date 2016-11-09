package servidor;

import java.io.Serializable;


public class User implements Serializable {
    private int password;
    private String usuario;
    private int mundo;
    public User() {
        
    }
    
    public int getMundo() {
		return mundo;
	}

	public void setMundo(int mundo) {
		this.mundo = mundo;
	}

    public User(int pass, String nombre) {
        this.usuario = nombre;
        this.password = pass;
    }

    public int getPass() {
        return this.password;
    }

    public void setPass(int pass) {
        this.password = pass;
    }

    public String getNombre() {
        return this.usuario;
    }

    public void setNombre(String nombre) {
        this.usuario = nombre;
    }
}
