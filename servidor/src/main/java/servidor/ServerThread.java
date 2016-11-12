package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.Scanner;

public class ServerThread implements Runnable, Observer {// The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
    Socket socket;
    Scanner input;
    String mensaje = "";
    ArrayList<String> mensajes= new ArrayList<String>();
    ArrayList<Socket> listaDeConexiones = new ArrayList<>();
    String nickName;
    final int mTPS=30;
    long millis=0;
    final int MPT= 1000/mTPS; //millisegundos por tick.
    int ticks=0;

    //CONSTRUCTOR DEL CHAT
    public ServerThread(Socket socket, ArrayList<Socket> listaDeSala, String alias) {
        this.socket = socket;
        this.listaDeConexiones = listaDeSala;
        this.nickName = alias;
    }
    public boolean estaConectado() throws IOException {
        if (!this.socket.isConnected()) {// SI EL SOCKET ESTA DESCONECTADO LO ELIMINA DE MI LISTA DE CONEXIONES.
            for (int x = 0; x < this.listaDeConexiones.size(); x++) {
                if (this.listaDeConexiones.get(x) == this.socket) {
                    this.listaDeConexiones.remove(x);
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public void run() {//SOBRECARGAR DE RUN QUE SE REALIZARA CUANDO INICIE EL THREAD CREADO EN "SERVIDOR"

    	MapaObstaculos mO= new MapaObstaculos(32, 32, 0.5);
        MapaAlianza mA= new MapaAlianza("Alianza1");
        mA.RegistrarAlianza(this);
        
    	
    	try {
            this.input = new Scanner(this.socket.getInputStream()); // OBTENGO EL CANAL DE ENTRADA DEL SOCKET

            
                if (this.estaConectado()) { // VERIFICO QUE EL SOCKET ESTE CONECTADO, SI NO LO ESTA CIERRO ESE SOCKET.
                    if (!this.input.hasNext()) { // SI NO HA TIENE MENSAJE ACTUAL BUCLEO A LA ESPERA DE UNO
                        return;
                    }
                }
            

                
            long millis = System.currentTimeMillis();
            while (true) { 
            	

                   if ((System.currentTimeMillis() - millis) >=MPT && ticks <= mTPS){
                    	millis=System.currentTimeMillis();
                    	
                    	mA.procesar();
                    	
                    	if (++ticks > mTPS)
                    		ticks=0;
                    	
                    	
                    }
                                     
                    this.mensaje = this.input.nextLine(); // GUARDO EN MENSAJE EL TEXTO RECIBIDO
                    System.out.println(this.nickName + " dice: " + this.mensaje);
                    
   

                    for (int x = 0; x < this.listaDeConexiones.size(); x++) { // RECORRE TODA LA LISTA DE CONEXIONES DE LA SALA PARA ENVIAR EL MENSAJE RECIBIDO A TODOS.
                        Socket tempSocket = this.listaDeConexiones.get(x);
                        PrintWriter tempOut = new PrintWriter(tempSocket.getOutputStream()); // OBTENGO EL CANAL DE SALIDA PARA ENVIARLE EL MENSAJE A EL SOCKET
                        for (String m : mensajes){
                        tempOut.println(this.nickName + ": " + this.mensaje); // ENVIA EL MENSAJE
                        tempOut.flush();} // LIMPIO EL BUFFER DE SALIDA
                        System.out.println("mensaje enviado a: " + tempSocket.getLocalAddress().getHostName());
                    }
                }

            }
         catch (Exception e) {
            e.printStackTrace();
        }

    }
	@Override
	public void update(Observable arg0, Object arg1) {
		
		mensajes.add(arg0.getClass().toString() + "cambio su estado");
		
	}

}
