package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerThread implements Runnable {// The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
    Socket socket;
    Scanner input;
    String mensaje = "";
    ArrayList<Socket> listaDeConexiones = new ArrayList<>();
    String nickName;

    //CONSTRUCTOR DEL CHAT
    public ServerThread(Socket socket, ArrayList<Socket> listaDeSala, String alias) {
        this.socket = socket;
        this.listaDeConexiones = listaDeSala;
        this.nickName = alias;
    }

    @Override
    public void run() {//SOBRECARGAR DE RUN QUE SE REALIZARA CUANDO INICIE EL THREAD CREADO EN "SERVIDOR"

        try {
            this.input = new Scanner(this.socket.getInputStream()); // OBTENGO EL CANAL DE ENTRADA DEL SOCKET

            while (true) {

                    this.mensaje = this.input.nextLine(); // GUARDO EN MENSAJE EL TEXTO RECIBIDO
                    System.out.println(this.nickName + " dice: " + this.mensaje);

                    for (int x = 0; x < this.listaDeConexiones.size(); x++) { // RECORRE TODA LA LISTA DE CONEXIONES DE LA SALA PARA ENVIAR EL MENSAJE RECIBIDO A TODOS.
                        Socket tempSocket = this.listaDeConexiones.get(x);
                        PrintWriter tempOut = new PrintWriter(tempSocket.getOutputStream()); // OBTENGO EL CANAL DE SALIDA PARA ENVIARLE EL MENSAJE A EL SOCKET
                        tempOut.println(this.nickName + ": " + this.mensaje); // ENVIA EL MENSAJE
                        tempOut.flush(); // LIMPIO EL BUFFER DE SALIDA
                        System.out.println("mensaje enviado a: " + tempSocket.getLocalAddress().getHostName());
                    }
                }

            }
         catch (Exception e) {
            e.printStackTrace();
        }

    }

}
