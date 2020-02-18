package entity;

import java.awt.Graphics;

import main.Game;

public class Swarm extends Enemy {

	public static final double SWARM_HEALTH = 0.25;
	public static final double SWARM_MOVEMENT_SPEED = 2.5;
	
	
	public Swarm(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		
		health *= SWARM_HEALTH;
		movementSpeed *= SWARM_MOVEMENT_SPEED;
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
