package creature;
import java.util.*;

/*
 * The MonsterManager class controls all monsters in its list.
 */
public class MonsterManager {
	private List<Monster> list;
	private int numMoves;
	
	// creates a new MonsterManager with 0 monsters
	public MonsterManager() {
		list = new ArrayList<Monster>();
		addMonster(50);
		numMoves = 0;
	}
	
	// adds new Monster to list with given health
	public void addMonster(int health) {
		list.add(new Monster(health));
	}
	
	// moves all Monsters in list if their health > 0
	public void moveCreatures() {
		// new monster spawns every 5 moves
		if (++numMoves % 8 == 0) {
			addMonster(50 + numMoves);
		}
		for (Monster m : list) {
			if (m.alive()) {
				m.move();
			}
		}
	}
	
	// resets monsterManager to only 1 monster and 0 moves
	public void reset() {
		list.clear();
		addMonster(50);
		numMoves = 0;
	}
}
