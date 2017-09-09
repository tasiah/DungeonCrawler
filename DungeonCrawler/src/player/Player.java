package player;
import maze.Maze;
import creature.Creature;

public class Player extends Creature {
	
	public Player(Maze maze) {
		super(maze.getStartingX(), maze.getStartingY(), 100);
	}
	
	public void moveNorth(Maze maze) {
		if (maze.northWall(x, y)) {
			System.out.println("wall");
		} else {
			y++;
			if (maze.atExit(x, y)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved north");
				if (maze.atEntrance(x, y)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public void moveSouth(Maze maze) {
		if (maze.southWall(x, y)) {
			System.out.println("wall");
		} else {
			y--;
			// moving south will never move the player to the exit
			System.out.println("moved south");
			if (maze.atEntrance(x, y)) {
				System.out.println("were we here before?");
			}
		}
	}
	
	public void moveEast(Maze maze) {
		if (maze.eastWall(x, y)) {
			System.out.println("wall");
		} else {
			x++;
			if (maze.atExit(x, y)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved east");
				if (maze.atEntrance(x, y)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public void moveWest(Maze maze) {
		if (maze.westWall(x, y)) {
			System.out.println("wall");
		} else {
			x--;
			if (maze.atExit(x, y)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved west");
				if (maze.atEntrance(x, y)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
}
