package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	
	public static BufferedImage enemy, tower, map, path;
	
	private final static int HEIGHT, WIDTH = HEIGHT = 32;
	
	public static void init() {
		SpriteSheet spriteSheet = 
				new SpriteSheet(ImageLoader.loadImage("/textures/PixelSpriteGame.png"));
		
		enemy = spriteSheet.crop(0, 0, WIDTH, HEIGHT);
		tower = spriteSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		path = spriteSheet.crop(2*WIDTH, 0, WIDTH, HEIGHT);
		map = spriteSheet.crop(3*WIDTH, 0, WIDTH, HEIGHT);
		
	}
	
	
}
