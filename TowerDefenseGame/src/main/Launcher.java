package main;

public class Launcher {

	public static final int WIDTH = 1028, HEIGHT = 20 * 32;
	
	public static void main(String[] args) {
		Game game = new Game("Tower Defense");
		game.start();
	}
	
}
