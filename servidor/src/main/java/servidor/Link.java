package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

import comunicacion.Mensaje;
import org.codehaus.jackson.map.ObjectMapper;




public class Link {
		
		private LinkedBlockingQueue<Mensaje> mensajes;
		private ObjectInputStream in;
		private ObjectOutputStream out;
		private Socket socket;
		private int clientId;
		private volatile boolean online;
		private volatile boolean stillAlive;
		private ObjectMapper mapper= new ObjectMapper();
		private volatile boolean iniciado = false;

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
			Thread read = new Thread(new Lectura(), "Client: " + clientId + " reading thread");
			read.setDaemon(true);
			read.start();

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
			synchronized (this) {
				if (!stillAlive)
					return;
				stillAlive = false;
			}
		}
		
	private class Lectura implements Runnable { //Sabias que se podian definir clases en classes?

			public void run() { // Se hace en otro thread, para que no sea bloqueante. Escritura no tiene tanto drama
			
			try{
				while (isOnline()) {
				Mensaje msg = null;
					try {
							String input = in.readLine();
							msg = mapper.readValue(input, Mensaje.class);
							
						} 
							catch (IOException e1) {
								e1.printStackTrace();
							}
							
							
				}	
					Apagar();
					break;
						

					try {
							mensajes.put(new Mensaje(obj, clientId));
						} 
						catch (Exception e) {
									e.printStackTrace();
						}

					
				} catch (RuntimeException rte) {
					rte.printStackTrace();
					Apagar();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
		
		
		 class Routear implements Runnable { //Manda Cada Mensaje al metodo que orresponda
			public void run() {
				while (isOnline())
					try {
						Mensaje m = mensajes.take();
						if (m == null)
							continue;
						
							
							encolarMensaje(Server.this, getClient(m.id), m.msg);
						
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
