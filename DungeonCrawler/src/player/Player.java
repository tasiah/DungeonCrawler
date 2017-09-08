package player;
import maze.*;


public class Player {
	private int x;
	private int y;
	
	public Player() {
		x = 0;
		y = 0;
	}
	
	public void moveNorth(Maze maze) {
		if (maze.getCell(x, y).north) {
			System.out.println("wall");
		} else if (y + 1 >= maze.getDim()) {
			if (x > maze.getDim() / 2) {
				System.out.println("you did it");
			} else {
				System.out.println("end of map");
			}
		} else {
			y++;
			System.out.println("moved north");
		}
	}
	
	public void moveSouth(Maze maze) {
		if (maze.getCell(x, y).south) {
			System.out.println("wall");
		} else if (y - 1 >= maze.getDim()) {
			if (x > maze.getDim() / 2) {
				System.out.println("you did it");
			} else {
				System.out.println("end of map");
			}
		} else {
			y--;
			System.out.println("moved south");
		}
	}
	
	public void moveEast(Maze maze) {
		if (maze.getCell(x, y).east) {
			System.out.println("wall");
		} else if (x + 1 >= maze.getDim()) {
			if (y > maze.getDim() / 2) {
				System.out.println("you did it");
			} else {
				System.out.println("end of map");
			}
		} else {
			x++;
			System.out.println("moved east");
		}
	}
	
	public void moveWest(Maze maze) {
		if (maze.getCell(x, y).west) {
			System.out.println("wall");
		} else if (x - 1 >= maze.getDim()) {
			if (y > maze.getDim() / 2) {
				System.out.println("you did it");
			} else {
				System.out.println("end of map");
			}
		} else {
			x--;
			System.out.println("moved west");
		}
	}
		
}
