package servidor;

import comun.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    //SALAS DE CHAT DISPONIBLES
    public static ArrayList<Socket> listaDeConexionesMundo1 = new ArrayList<>();
    public static ArrayList<Socket> listaDeConexionesMundo2 = new ArrayList<>();

    
    public static void main(String[] args) throws Exception {

    	try {
            final int PORT = 4445;
            ServerSocket server = new ServerSocket(PORT);
            ObjectMapper mapper = new ObjectMapper();

            while (true) {
                System.out.println("Esperando un cliente");
                Socket socket = server.accept();
                System.out.println("PaseSocket");
                /*
                Scanner sc;
    			sc = new Scanner(socket.getInputStream());
    			String input = sc.nextLine();
    			User user = mapper.readValue(input, User.class);
    			System.out.println(user.getNombre());
    			*/
                
                //CREAR THREAD LOGUEO
                /// De aca para abajo hay q psarlo al thread de logueo
               
                ServerLog log = new ServerLog(socket,listaDeConexionesMundo1,listaDeConexionesMundo2);           
                Thread thread = new Thread(log);
                thread.start();
                /// HASTA ACA
                // System.out.println("Client conectado a Sala " + user.getSala() + " desde: " + socket.getLocalAddress().getHostName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
