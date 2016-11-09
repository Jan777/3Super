package servidor;

//import chat.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    //SALAS DE CHAT DISPONIBLES
	public static ArrayList<ArrayList> listaMundos = new ArrayList<>();
	
    public static ArrayList<Socket> listaDeConexionesMundo1 = new ArrayList<>();
    public static ArrayList<Socket> listaDeConexionesMundo2 = new ArrayList<>();
    public static ArrayList<Socket> listaDeConexionesMundo3 = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        listaMundos.add(listaDeConexionesMundo1);
        listaMundos.add(listaDeConexionesMundo2);
        listaMundos.add(listaDeConexionesMundo3);
    	try {
            final int PORT = 4445;
            ServerSocket server = new ServerSocket(PORT);
            ObjectMapper mapper = new ObjectMapper();

            while (true) {
                System.out.println("Esperando un cliente");
                Socket socket = server.accept();
                //CREAR THREAD LOGUEO
                /// De aca para abajo hay q psarlo al thread de logueo
                //NO SE PARA QUE PUSIERON EL ServerLog
                //ServerLog log = new ServerLog(socket,listaMundos);
                
                
                Scanner sc = new Scanner(socket.getInputStream());
                String input = sc.nextLine();

                User user = mapper.readValue(input, User.class);

                ServerThread mundo;

                switch (user.getMundo()) {
                    case 1:
                        listaDeConexionesMundo1.add(socket);
                        mundo = new ServerThread(socket, listaDeConexionesMundo1, user.getNombre());
                        Thread nuevoProcesoParalelo1 = new Thread(mundo);
                        nuevoProcesoParalelo1.start();
                        break;
                    case 2:
                        listaDeConexionesMundo2.add(socket);
                        mundo = new ServerThread(socket, listaDeConexionesMundo2, user.getNombre());
                        Thread nuevoProcesoParalelo2 = new Thread(mundo);
                        nuevoProcesoParalelo2.start();
                        break;
                    case 3:
                        listaDeConexionesMundo3.add(socket);
                        mundo = new ServerThread(socket, listaDeConexionesMundo3, user.getNombre());
                        Thread nuevoProcesoParalelo3 = new Thread(mundo);
                        nuevoProcesoParalelo3.start();
                        break;
                    default:
                        break;
                        
                }
                /// HASTA ACA
                System.out.println("Client conectado a Sala " + user.getMundo() + " desde: " + socket.getLocalAddress().getHostName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
