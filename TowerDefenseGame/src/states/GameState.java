package states;

import java.awt.Graphics;

import main.Game;
import waves.Wave;
import worlds.World;

public class GameState extends State {

	private World world;
	private Wave waves;
	
	public GameState(Game game) {
		super(game);
		world = new World(game, "res/worlds/world1.txt");
		waves = new Wave(game, "res/worlds/world1waves.txt");
	}
	
	
	@Override
	public void tick() {
		world.tick();
		waves.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		waves.render(g);
	}

}
