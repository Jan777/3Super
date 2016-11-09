package servidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

import chat.User;

public class ServerLog implements Runnable {// The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
    Socket socket;
    Scanner input;
    String mensaje = "";
    ArrayList<ArrayList> listaMundos = new ArrayList<>();
    String nickName;
    ObjectMapper mapper = new ObjectMapper();

    //CONSTRUCTOR
    public ServerLog(Socket socket, ArrayList<ArrayList> listaMundos) {
        this.socket = socket;
        this.listaMundos = listaMundos;
       // this.nickName = alias;
    }

    @Override
    public void run() {//SOBRECARGAR DE RUN QUE SE REALIZARA CUANDO INICIE EL THREAD CREADO EN "SERVIDOR"

    	 Scanner sc = new Scanner(socket.getInputStream());
         String input = sc.nextLine();

         User user = mapper.readValue(input, User.class);

         ServerThread chat;
         //user.getNombre() 
         //user.getPass()
         //
         switch (user.getPass()) {
             case 1:
                 listaMundos. .add(socket);
                 chat = new ServerThread(socket, listaDeConexionesSala1, user.getNombre());
                 Thread nuevoProcesoParalelo1 = new Thread(chat);
                 nuevoProcesoParalelo1.start();
                 break;
             case 2:
                 listaDeConexionesSala2.add(socket);
                 chat = new ServerThread(socket, listaDeConexionesSala2, user.getNombre());
                 Thread nuevoProcesoParalelo2 = new Thread(chat);
                 nuevoProcesoParalelo2.start();
                 break;
             case 3:
                 listaDeConexionesSala3.add(socket);
                 chat = new ServerThread(socket, listaDeConexionesSala3, user.getNombre());
                 Thread nuevoProcesoParalelo3 = new Thread(chat);
                 nuevoProcesoParalelo3.start();
                 break;
             default:
                 break;

    }

}
