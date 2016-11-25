package partida.entidades.sprites;

import java.awt.Graphics;

import partida.Handler;
import partida.gfx.Assets;
import partida.tiles.Tile;


public class SpriteNPCCapacitor extends EntidadSprite {

	public SpriteNPCCapacitor(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.npcCap, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

}
