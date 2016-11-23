package servidor;

//import org.codehaus.jackson.map.ObjectMapper;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //MUNDOS DISPONIBLES
//    public static ArrayList<Socket> listaDeConexionesMundoFisico = new ArrayList<>();
//    public static ArrayList<Socket> listaDeConexionesMundoEnlace = new ArrayList<>();
		

    
    public static void main(String[] args) throws Exception {
    	CommHandler sala=null;

    	try {
            final int PORT = 4445;
            @SuppressWarnings("resource") //no cierro server
			ServerSocket server = new ServerSocket(PORT);
            //ObjectMapper mapper = new ObjectMapper();

            while (true) {
                System.out.println("Esperando un cliente");
                Socket socket = server.accept();

                //CREAR THREAD LOGUEO
                /// De aca para abajo hay q psarlo al thread de logueo
                //ServerLog log = new ServerLog(socket,listaDeConexionesMundoFisico,listaDeConexionesMundoEnlace);
                if (sala==null){
                sala = new CommHandler();
                Thread thread = new Thread(sala);
                thread.start();
                }	
                sala.addSocket(socket);

                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    	
    	
    }
}
