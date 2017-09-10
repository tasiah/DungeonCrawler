package maze;
import creature.*;
import java.util.*;

public class MazeManager {
	private Maze maze;
	private Player player;
	private List<Monster> monsterManager;
	private Random r;
	
	public MazeManager(Maze maze, Player player) {
		this.maze = maze;
		this.player = player;
		monsterManager = new ArrayList<Monster>();
		r = new Random();
	}
	
	public void moveMonsters() {
		for (Monster m : monsterManager) {
			int randMove = r.nextInt(4);
			if (randMove == 0) {
				m.moveNorth();
			} else if (randMove == 1) {
				m.moveSouth();
			} else if (randMove == 2) {
				m.moveEast();
			} else {
				m.moveWest();
			}
		}
	}
	
	private boolean playerAhead(Monster m) {
		return m.get
	}
}
