package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	//Tile stuff
	
	public static Tile[] tiles = new Tile[128];
	public static Tile map = new MapTile(0);
	public static Tile path = new PathTile(1);
	public static Tile tower = new TowerTile(2);
	public static Tile gate = new GateTile(3);
	
	
	
	//Class stuff
	
	protected BufferedImage texture;
	protected final int id;
	
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isPlaceable() {
		return true;
	}
	
	public int getId() {
		return id;
	}
}