package comunicacion;
import java.net.Socket;
import java.util.ArrayList;
import logica.MapaLogico;

public class Inicializacion extends Mensaje {

	ArrayList<MapaLogico> ml;
	
	
	public Inicializacion(ArrayList<MapaLogico> ml, int receptor){
		super(0, receptor,receptor);
		this.ml=ml;
	}



}
