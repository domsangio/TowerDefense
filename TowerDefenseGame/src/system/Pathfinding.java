package system;

import tiles.Tile;

public class Pathfinding {

	private static Graph graph;
	
	public Pathfinding(Tile[][] map) {
		graph = new Graph();
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == Tile.path) {
					graph.addNode(new Node(map[i].length * j + i));
				}
			}
		}
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == Tile.path) {
					//add in the adjacent ones too
					if(i - 1 >= 0 && j >= 0 && i - 1 < map.length &&
						j < map[i].length && map[i - 1][j] == Tile.path) {
						graph.addDoubleEdge(map[i].length * j + i, map[i].length * j + i - 1);
					}
				}
			}
		}
	}
	
	public String toString() {
		
	}
	
	//public static
}
