package comunicacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import logica.MapaLogico;


public class ClientThread implements Runnable {
    private Socket socket;
    private Scanner sc;
    private PrintWriter out;
    private ArrayList<MapaLogico> listaml= new ArrayList<MapaLogico>();
    private ObjectMapper mapper= new ObjectMapper();

    public ClientThread(Socket socket) {
        this.socket = socket;
        inicializar();
    }

    @Override
    public void run() {
        try {
            this.sc = new Scanner(this.socket.getInputStream());
            this.out = new PrintWriter(this.socket.getOutputStream());
            this.out.flush();

            while (true) {
                recibirDatos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void recibirDatos() {
        if (this.sc.hasNext()) {
            String mensajeEntrante = this.sc.nextLine();
            System.out.println(mensajeEntrante);
        }
    }

    public void enviarDatos(String mensajeSaliente) {
        this.out.println(mensajeSaliente);
        this.out.flush();
    }

    public void desconectar() throws Exception {
        this.out.println(" se ha retirado de la sala");
        this.out.flush();
        this.socket.close();
        System.exit(0);
    }
    
    public void inicializar (){
    	do{
//    		String mapainjason= sc.nextLine();
    		try {
				listaml.add(mapper.readValue(sc.nextLine(), MapaLogico.class));
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}while (this.sc.hasNext());
    }
    public ArrayList<MapaLogico> getML (){
    
    	if (listaml.isEmpty()) return null;
    	return listaml;
    }
}
