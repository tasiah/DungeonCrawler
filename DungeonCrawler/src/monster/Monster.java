package monster;
import maze.Maze;
import creature.*;

public class Monster extends Creature{
	
	public Monster(int health, Maze maze) {
		super("monster", maze.getDimX(), maze.getDimY(), health);
	}

	
}
