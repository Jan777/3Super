package partida;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import comunicacion.Jugador;
import partida.entidades.dinamicas.GameNpc;
import partida.entidades.dinamicas.Player;
import partida.estados.GameState;
import partida.estados.State;
import partida.gfx.Assets;
import partida.gfx.Camara;
import partida.input.KeyManager;

public class Partida implements Runnable {

	private Display display; //esta es la ventana
	private int width, height; // con su alto y ancho
	public String title;
	
	private ArrayList<Player> listaJugadores;
	private ArrayList<GameNpc> listaNpcs;
	private Queue<Jugador> colaBuffer;
	
	Socket socket;
	Jugador jugadorMio;
	Jugador jugadorRecibido;
	Player player;
	Scanner sc;
	
	private VentanaPelea ventanaPelea;
	private boolean estaPeleando;	
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private GameState gameState;
	//Input
	private KeyManager keyManager;
	
	//Camera
	private Camara gameCamera;
	
	//Handler
	private Handler handler;
	
	public Partida(String title, int width, int height, Socket socket){
		this.width = width;
		this.height = height;
		this.title = title;
		this.socket = socket;
		//jugadorMio = new Jugador();
		jugadorRecibido = new Jugador();
		keyManager = new KeyManager();
		player = new Player(handler,0,0);
		estaPeleando = false;
	}
	
	private void init(){
		display = new Display(title, width, height); //creo la ventana del juego
		display.getFrame().addKeyListener(keyManager);
		Assets.init(); //en Assets recorto todas las imagenes y las guardo
					   //en un BufferedImage
		handler = new Handler(this);
		gameCamera = new Camara(handler, 0, 0);
		gameState = new GameState(handler);
		State.setState(gameState);
	}
	
	private void tick(){ //este metodo hace el update todo el tiempo
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render() throws JsonGenerationException, JsonMappingException, IOException{ //este metodo dibuja en la pantalla todo
		
	    String jsonInString;
	    float x = this.gameState.getWorld().getEntityManager().getPlayer().getX();
	    float y = this.gameState.getWorld().getEntityManager().getPlayer().getY();
	    //Humano = this.gameState.getWorld().getEntityManager().getPlayer().getPersonaje();
	    jugadorMio = new Jugador(x,y);
	    
		ObjectMapper mapper = new ObjectMapper();
		jsonInString = mapper.writeValueAsString(jugadorMio);
		PrintWriter out = new PrintWriter(socket.getOutputStream()); //OBTENGO EL CANAL DE SALIDA DEL SOCKET HACIA EL SERVIDOR
		out.println(jsonInString);
		out.flush();
		
		
		bs = display.getCanvas().getBufferStrategy(); //BufferStrategy es lo que la computadora le avisa que tiene que dibujar
		if(bs == null){
			display.getCanvas().createBufferStrategy(3); //si recien arranco el juego, crea el bstrategy, vamos a usar 3 buffers
			return;
		}
		g = bs.getDrawGraphics();

		g.clearRect(0, 0, width, height); //rectangulo que limpia la pantalla

		//aca dibujo
		if(State.getState() != null)
			State.getState().render(g);

		sc = new Scanner(socket.getInputStream());
		String input = sc.nextLine();
		jugadorRecibido = mapper.readValue(input, Jugador.class);
		
		colaBuffer.add(jugadorRecibido);
		
		Jugador jugadorATratar = colaBuffer.remove();
		
		if(jugadorATratar.getId() != jugadorMio.getId()){
		
			Player player = new Player(handler, jugadorATratar.getX(),jugadorATratar.getY());
		
		
			player.render(g);
			
				if(estaPeleando == false)
				{
					if( Math.abs(this.gameState.getWorld().getEntityManager().getPlayer().getX() - player.getX() ) < 30
								&& Math.abs(this.gameState.getWorld().getEntityManager().getPlayer().getY()) - player.getY() < 30
								&& this.gameState.getWorld().getEntityManager().getHandler().getKeyManager().pelea == true )
					{
						ventanaPelea = new VentanaPelea(this.gameState.getWorld().getEntityManager().getPlayer(), player, this);
						ventanaPelea.setVisible(true);
						estaPeleando = true;
						this.gameState.getWorld().getEntityManager().getHandler().getKeyManager().pelea = false;
					}
				}
		}

		for (GameNpc npc : listaNpcs) {
			npc.render(g);
			
			if(estaPeleando == false)
			{
				if( Math.abs(this.gameState.getWorld().getEntityManager().getPlayer().getX() - npc.getX() ) < 30
							&& Math.abs(this.gameState.getWorld().getEntityManager().getPlayer().getY()) - npc.getY() < 30
							&& this.gameState.getWorld().getEntityManager().getHandler().getKeyManager().pelea == true )
				{
					ventanaPelea = new VentanaPelea(this.gameState.getWorld().getEntityManager().getPlayer(), npc,this);
					ventanaPelea.setVisible(true);
					estaPeleando = true;
					this.gameState.getWorld().getEntityManager().getHandler().getKeyManager().pelea = false;
				}
			}
		}
		
		if(jugadorRecibido.getMurioIndex() >= 0 ){
			//int index = jugadorRecibido.getMurioIndex();
			listaNpcs.remove(jugadorRecibido.getMurioIndex());
			jugadorMio.setMurioIndex(-1);
		}
		
		
		//termino de dibujar aca
		bs.show(); //muestro lo que tiene el bufferstrategy
		g.dispose(); //hago dispose de los graficos
	}
		
	
	public void run(){
		init();
		
		int fps = 20;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;

		colaBuffer = new LinkedList();
		listaNpcs = new ArrayList<GameNpc>();

		GameNpc npc1 = new GameNpc(handler, 500, 200, 'C');
		listaNpcs.add(npc1);
		GameNpc npc2 = new GameNpc(handler, 600, 50, 'C');
		listaNpcs.add(npc2);
		GameNpc npc3 = new GameNpc(handler, 50, 50, 'C');
		listaNpcs.add(npc3);
		GameNpc npc4 = new GameNpc(handler, 500, 500, 'C');
		listaNpcs.add(npc4);
		GameNpc npc5 = new GameNpc(handler, 600, 100, 'R');
		listaNpcs.add(npc5);
		GameNpc npc6 = new GameNpc(handler, 300, 500, 'R');
		listaNpcs.add(npc6);
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				try {
					render();
				} catch (IOException e) {
					e.printStackTrace();
				}
				delta--;
			}
			
			if(timer >= 1000000000){
				timer = 0;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public Camara getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running) //si ya esta empezado, no hace nada, es por las dudas
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running) //lo mismo que en start, si ya esta running=false sale.
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(null,"ERROR DE THREAD"); 
		}
	}
	
	public boolean isEstaPeleando() {
		return estaPeleando;
	}

	public void setEstaPeleando(boolean estaPeleando) {
		this.estaPeleando = estaPeleando;
	}

	public ArrayList<GameNpc> getListaNpcs() {
		return listaNpcs;
	}

	public Socket getSocket() {
		return socket;
	}

	public Jugador getJugadorMio() {
		return jugadorMio;
	}

	public void setJugadorMio(Jugador jugadorMio) {
		this.jugadorMio = jugadorMio;
	}

}