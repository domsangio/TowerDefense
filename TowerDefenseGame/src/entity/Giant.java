package entity;

import java.awt.Graphics;

import main.Game;

public class Giant extends Enemy {

	public static final double GIANT_MOVEMENT_SPEED = 0.5;
	public static final double GIANT_HEALTH = 4d;
	
	public static final int GIANT_DEFAULT_WIDTH = 20;
	public static final int GIANT_DEFAULT_HEIGHT = 20;
	
	public Giant(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		
		health *= GIANT_HEALTH;
		movementSpeed *= GIANT_MOVEMENT_SPEED;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
