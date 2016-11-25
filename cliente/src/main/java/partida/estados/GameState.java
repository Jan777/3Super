package partida.estados;

import java.awt.Graphics;

import partida.Handler;
import partida.mapa.Mapa;

public class GameState extends State {
	
	private Mapa world;
	
	public GameState(Handler handler){
		super(handler);
		world = new Mapa(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

	public Mapa getWorld(){
		return world;
	}
}
