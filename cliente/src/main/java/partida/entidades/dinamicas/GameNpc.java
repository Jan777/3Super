package partida.entidades.dinamicas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import npc.Capacitor;
import npc.Npc;
import npc.Resistencia;
import partida.Handler;
import partida.gfx.Assets;

public class GameNpc extends Creature {
	private char identificacion; //identifico si es Capacitor o Resistencia
	private Npc npc;
	
	public Npc getNpc() {
		return npc;
	}

	public void setNpc(Capacitor npc) {
		this.npc = npc;
	}
	
	public char getIdentificacion(){
		return identificacion;
	}

	public GameNpc(Handler handler, float x, float y, char id) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		identificacion = id;

		if(id == 'C'){
			npc = new Capacitor();
		} else {
			npc = new Resistencia();
		}
		
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
	}

	public void render(Graphics g) {
		BufferedImage imagen = null;
		if (identificacion == 'C') //aca me fijo que imagen uso depende la identificacion
			imagen = Assets.npcCap;
		else
			imagen = Assets.npcRes;
		g.drawImage( imagen, (int) (x - handler.getGameCamera().getxOffset()),
				   (int) (y - handler.getGameCamera().getyOffset()), width, height, null );
	}
	

	public void tick() {
		
	}

}
