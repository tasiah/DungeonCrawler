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
		
}
