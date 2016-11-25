package world.tiles;

import world.gfx.Assets;

public class SocketTile extends Tile {

	public SocketTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
