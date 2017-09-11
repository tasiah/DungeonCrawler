package monster;
import creature.*;

public class Monster extends Creature{
	
	public Monster(int health) {
		super("monster", health);
	}
	
	public void move() {
		if (creatureAhead != null && creatureAhead.isPlayer()) {
			attack();
		} else {
			int randMove = r.nextInt(4);
			if (randMove == 0) {
				moveNorth();
			} else if (randMove == 1) {
				moveSouth();
			} else if (randMove == 2) {
				moveEast();
			} else {
				moveWest();
			}
		}
	}
	


	
}
