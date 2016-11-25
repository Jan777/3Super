package servidor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.codehaus.jackson.map.ObjectMapper;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Server {
    //MUNDOS DISPONIBLES
    public static ArrayList<Socket> listaDeConexionesMundoFisico = new ArrayList<>();
    public static ArrayList<Socket> listaDeConexionesMundoEnlace = new ArrayList<>();
    private static int puerto;
    private static String IPServidor;

    
    public static void main(String[] args) throws Exception {

    	try {
    		leerArchivoConfig();
            @SuppressWarnings("resource") //no cierro server
			ServerSocket server = new ServerSocket(puerto);
            //ObjectMapper mapper = new ObjectMapper();

            while (true) {
                System.out.println("Esperando un cliente");
                Socket socket = server.accept();

                //CREAR THREAD LOGUEO
                /// De aca para abajo hay q psarlo al thread de logueo
                ServerLog log = new ServerLog(socket,listaDeConexionesMundoFisico,listaDeConexionesMundoEnlace);           
                Thread thread = new Thread(log);
                thread.start();
                /// HASTA ACA
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    	
    	
    }
    private static void leerArchivoConfig() throws IOException {
    	Scanner entrada = null;
    	try {
			entrada = new Scanner(new File(PATH_CONFIGURACION));
			
			if(entrada.hasNextLine()) {
				IPServidor = entrada.nextLine().substring(3);
				puerto = Integer.parseInt(entrada.nextLine().substring(7));
			}
			
		} catch (FileNotFoundException e) {
			 JOptionPane.showMessageDialog(null, "No se puede cargar la configuracion del servidor");
		} finally {
			entrada.close();
		}
    	//entrada.close();
    }
    private static final String PATH_CONFIGURACION = "config/propiedades.config";
}
