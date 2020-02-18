package waves;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

import entity.Enemy;
import main.Game;
import utils.Utils;

public class Wave {
	
	private Game game;			//reference to the game object
	private int numWaves;		//number of waves
	private int waveTick;
	private int[] waves;		//number of monster in each wave
	private Queue<Enemy> enemies;
	private int currentWaveNumber;
	private int gameTime;
	
	public Wave(Game game, String path) {
		this.game = game;
		this.enemies = new LinkedList<>();
		
		currentWaveNumber = 0;
		waveTick = 0;
		gameTime = 0;
		
		loadWaves(path);
	}
	
	/**
	 * Method to load the world in and create it
	 * @param path to the current world being loaded
	 */
	private void loadWaves(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");		//splits the file by spaces
		
		numWaves = Utils.parseString(tokens[0]);		//first element of a world
		
		waves = new int[numWaves];
		
		for(int i = 0; i < numWaves; i++) {
			waves[i] = Utils.parseString(tokens[i + 1]);
		}
	}
	
	public void tick() {
		//add enemys
		//move enemies
		waveTick++;
		gameTime++;
		/*
		 * Every 30 ticks we load in 1 percent of the wave
		 */
		if(waveTick == 45) {
			//send new monsters
			
		}
		
		if(gameTime == 1800) {
			//send new wave
			
			//queue rest of monsters up?
			
			currentWaveNumber++;
			gameTime = 0;
			
		}
		
	}

	public void render(Graphics g) {
		
	}
}
