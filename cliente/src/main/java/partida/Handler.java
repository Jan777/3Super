package partida;

import partida.gfx.Camara;
import partida.input.KeyManager;
import partida.mapa.Mapa;

public class Handler {
	
	private Partida game;
	private Mapa world;
	
	public Handler(Partida game){
		this.game = game;
	}
	
	public Camara getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Partida getGame() {
		return game;
	}

	public void setGame(Partida game) {
		this.game = game;
	}

	public Mapa getWorld() {
		return world;
	}

	public void setWorld(Mapa world) {
		this.world = world;
	}

}
