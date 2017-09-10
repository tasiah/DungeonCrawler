package monster;
import maze.Maze;
import creature.*;

public class Monster extends Creature{
	
	public Monster(int health, Maze maze) {
		super("monster", health);
		x = r.nextInt(maze.getDimX());
		y = r.nextInt(maze.getDimY());
	}

	
}
