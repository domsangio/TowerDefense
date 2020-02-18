package worlds;

import java.awt.Graphics;

import main.Game;
import tiles.Tile;
import utils.Utils;

public class World {

	private Game game;			//has a reference to the game
	private int width, height;	//width and height of the world
	private int[][] tiles;		//2d array of tiles on the world
	
	public World(Game game, String path) {
		this.game = game;
		loadWorld(path);
	}
	
	/**
	 * Method to load the world in and create it
	 * @param path to the current world being loaded
	 */
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseString(tokens[0]);		//first element of a world
		height = Utils.parseString(tokens[1]);		//second element of a world
		
		tiles = new int[width][height];				//creates new tile array
		
		/*
		 * loops through and 
		 */
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseString(tokens[x + y * width + 2]);
			}
		}
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.map;
		}
		return t;
	}
	
}
