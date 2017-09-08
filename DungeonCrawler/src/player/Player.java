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
		if (y + 1 >= maze.getDim()) {
			System.out.println("end of map");
		} else if (maze.getCell(x, y).north) {
			System.out.println("wall");
		} else {
			y++;
			System.out.println("moved north");
		}
	}
	
	public void moveSouth(Maze maze) {
		if (y - 1 < 0) {
			System.out.println("end of map");
		} else if (maze.getCell(x, y).south) {
			System.out.println("wall");
		} else {
			y--;
			System.out.println("moved south");
		}
	}
	
	public void moveEast(Maze maze) {
		if (x + 1 >= maze.getDim()) {
			System.out.println("end of map");
		} else if (maze.getCell(x, y).east) {
			System.out.println("wall");
		} else {
			x++;
			System.out.println("moved east");
		}
	}
	
	public void moveWest(Maze maze) {
		if (x - 1 < 0) {
			System.out.println("end of map");
		} else if (maze.getCell(x, y).west) {
			System.out.println("wall");
		} else {
			x--;
			System.out.println("moved west");
		}
	}
		
}
