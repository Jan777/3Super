package comunicacion;

import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



import logica.MapaLogico;
import logica.MapaObstaculos;

import org.codehaus.jackson.map.ObjectMapper;


public class CommHandler implements Runnable {

	protected LinkedBlockingQueue<Mensaje> mensajes;
	ObjectMapper mapper = new ObjectMapper();
	protected ArrayList <Socket> sockets; //sockets a añadir
	protected ArrayList <Link> links; 
	protected boolean running = false;
	Socket socket = null;
	int id;
	ArrayList<MapaLogico> mapaslogicos;


	public CommHandler(int id)//Solo para cliente
	{

		running = true;
		this.id=id;
	}

	public void addSocket(Socket sck){
		sockets.add(sck);
	}
	
	public boolean Login(Credenciales cr){

		mensajes.add(cr.empaquetar(this.id));
		
		
		return false;
	}
		
	public void run() {
		while (running)
			try {
				for (Socket s : sockets){
					links.add(new Link(s));
				
					sockets.remove(s);
				}
			}

		catch (Exception e)
		{ e.printStackTrace();}

		}




	  class Link {//Sabias que se podian definir clases en classes?

		private ObjectInputStream in;
		private ObjectOutputStream out;
		private Socket socket;
		private int clientId;
		private volatile boolean online;
		private volatile boolean stillAlive;
		private volatile boolean iniciado = false;
		
		Link(Socket sck){
			this.socket = sck;
		}

		private void localStart() {
			if (!stillAlive || online)
				return;

			if (iniciado)
				return;
			synchronized (this) {
				if (iniciado)
					return;
				iniciado = true;
				online = true;
			}
			
			try{
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			}
			catch (Exception e){
				e.printStackTrace();
			}
			Thread lector = new Thread(new Lectura(), "Cliente: " + clientId + " reading thread");
			lector.setDaemon(true);
			lector.start();

		}
		public int getClientId() {
			return clientId;
		}
		protected ObjectInputStream getInputStream() {
			return in;
		}
		protected ObjectOutputStream getOutputStream() {
			return out;
		}
		protected Socket getSocket() {
			return socket;
		}
		public boolean isOnline() {
			return online;
		}
		public void Apagar() { //REVISAR
			if (!stillAlive)
				return;
			synchronized (this) { //Si algun dia hacemos multithread, esto puede servir. Osea, lo puse al dope.
				if (!stillAlive)
					return;
				stillAlive = false;
			}
		}
	  

		private class Lectura implements Runnable { // Its classes all the way down

			public void run() { // Se hace en otro thread, para que no sea bloqueante. Escritura no tiene tanto drama

				try{
					while (isOnline()) {
						Mensaje msg = null;
						try {
							msg = (Mensaje)in.readObject();
						} 
						catch (IOException e1) {
							e1.printStackTrace();
						}	

						try {
							mensajes.put(msg);
						} 
						catch (Exception e) {
							e.printStackTrace();
						}

					}	
				} catch (RuntimeException rte) {
					rte.printStackTrace();
					Apagar();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}


		private class Routear implements Runnable { //Yo dawng, i heard you like classes
			public void run() {//Manda Cada Mensaje al metodo que orresponda
				while (isOnline())
					try {
						Mensaje msg = mensajes.take();
						if (msg == null)
							continue;
						if (msg.SoyEmisor(id))
							out.writeObject(msg);
						if (msg.SoyReceptor(id))//
							mensajes.put(msg);//TODO revisar que server tenga acceso a la cola. O que halla un metodo para enviar al padre. algo asi.
						continue;

					

					} catch (InterruptedException e) {
					} catch (RuntimeException rte) {
						rte.printStackTrace();
						Apagar();
					} catch (Throwable t) {
						t.printStackTrace();
					}
			}

		}


	}
	
}



