package creature;
import java.util.*;

/*
 * The MonsterManager class controls all monsters in its list.
 */
public class MonsterManager {
	private List<Monster> list;
	
	// creates a new MonsterManager with 0 monsters
	public MonsterManager() {
		list = new ArrayList<Monster>();
	}
	
	// adds new Monster to list with given health
	public void addMonster(int health) {
		list.add(new Monster(health));
	}
	
	// moves all Monsters in list if their health > 0
	public void moveCreatures() {
		for (Monster m : list) {
			if (m.alive()) {
				m.move();
			}
		}
	}
	
}
