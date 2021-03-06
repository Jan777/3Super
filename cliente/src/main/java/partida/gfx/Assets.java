package partida.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage suelo, suelo2, stone, capacitor, npcCap, npcRes;
	public static BufferedImage[] player_down, player_up, player_left, player_right;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/sheet.png"));
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		//npcCap = new BufferedImage[2];
		
		//me voy moviendo en cuadrados de 32 para recortar las imagenes
		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 5, 0, width, height);
		player_up[0] = sheet.crop(width * 6, 0, width, height);
		player_up[1] = sheet.crop(width * 7, 0, width, height);
		player_right[0] = sheet.crop(width * 4, height, width, height);
		player_right[1] = sheet.crop(width * 5, height, width, height);
		player_left[0] = sheet.crop(width * 6, height, width, height);
		player_left[1] = sheet.crop(width * 7, height, width, height);
		
		npcCap = sheet.crop(width * 4, height * 2, width, height);
		npcRes = sheet.crop(width * 4, height * 3, width, height);
		//npcCap[1] = sheet.crop(width * 5, height * 2, width, height);

		suelo = sheet.crop(width, 0, width, height);
		suelo2 = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		capacitor = sheet.crop(0, 0, width, height * 2);

	}
	
}
