package monster;
import creature.*;

public class Monster extends Creature{
	
	public Monster(int health) {
		super("monster", health);
		cell = maze.getRandCell();
		while (cell.isOccupied()) {
			cell = maze.getRandCell();
		}
		cell.setOccupied(this);
		System.out.println(cell.getY());
	}
	
}
