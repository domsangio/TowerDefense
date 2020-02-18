package system;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpawnSystem {

	private List<Node> spawns;
	
	public SpawnSystem() {
		spawns = new ArrayList<>();
	}
	
	public SpawnSystem(ArrayList<Node> spawns) {
		this.spawns = spawns;
	}
	
	/**
	 * Fairly juvenile, but should work fine
	 * @return a random node to start from
	 */
	public Node getSpawn() {
		return spawns.get(new Random().nextInt(spawns.size()));
	}
}
