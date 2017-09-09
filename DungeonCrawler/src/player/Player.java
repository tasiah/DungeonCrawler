package player;
import maze.*;


public class Player {
	private int x;
	private int y;
	
	public Player(Maze maze) {
		x = maze.getEntrance().x;
		y = maze.getEntrance().y;
	}
	
	public void moveNorth(Maze maze) {
		if (maze.getCell(x, y).north) {
			System.out.println("wall");
		} else {
			y++;
			if (atExit(maze)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved north");
				if (atEntrance(maze)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public void moveSouth(Maze maze) {
		if (maze.getCell(x, y).south) {
			System.out.println("wall");
		} else {
			y--;
			// moving south will never move the player to the exit
			System.out.println("moved south");
			if (atEntrance(maze)) {
				System.out.println("were we here before?");
			}
		}
	}
	
	public void moveEast(Maze maze) {
		if (maze.getCell(x, y).east) {
			System.out.println("wall");
		} else {
			x++;
			if (atExit(maze)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved east");
				if (atEntrance(maze)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public void moveWest(Maze maze) {
		if (maze.getCell(x, y).west) {
			System.out.println("wall");
		} else {
			x--;
			if (atExit(maze)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved west");
				if (atEntrance(maze)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public boolean atExit(Maze maze) {
		return maze.getExit().x == x && maze.getExit().y == y;
	}
	
	public boolean atEntrance(Maze maze) {
		return maze.getEntrance().x == x && maze.getEntrance().y == y;
	}
		
}
