package entity;

import java.util.LinkedList;

import main.Game;
import system.Node;

public abstract class Enemy extends Entity {
	
	protected int health;
	protected int movementSpeed;
	protected boolean isPoisoned;
	
	public static final int DEFAULT_HEIGHT = 10,
							DEFAULT_WIDTH = 10;
	
	protected LinkedList<Node> Path;
	
	public Enemy(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		
		health = 100;
		movementSpeed = 1;
		isPoisoned = false;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}


	public void setPoisoned(boolean isPoisoned) {
		this.isPoisoned = isPoisoned;
	}


	public int getHealth() {
		return health;
	}


	public int getMovementSpeed() {
		return movementSpeed;
	}


	public boolean isPoisoned() {
		return isPoisoned;
	}
	
	
	
}
