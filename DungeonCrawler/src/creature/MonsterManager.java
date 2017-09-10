package creature;
import java.util.*;

public class MonsterManager {
	private List<Creature> list;
	
	public MonsterManager() {
		list = new ArrayList<Creature>();
	}
	
	public void addMonster(Monster m) {
		list.add(m);
	}
	
	public Creature creatureNorth(Creature main) {
		for (Creature c : list) {
			if (main.getX() == c.getX() && main.getY() == c.getY() + 1) {
				return c;
			}
		}
		return null;
	}
	
	public Creature creatureSouth(Creature main) {
		for (Creature c : list) {
			if (main.getX() == c.getX() && main.getY() == c.getY() - 1) {
				return c;
			}
		}
		return null;
	}
	
	public Creature creatureEast(Creature main) {
		for (Creature c : list) {
			if (main.getX() == c.getX() + 1 && main.getY() == c.getY()) {
				return c;
			}
		}
		return null;
	}
	
	public Creature creatureWest(Creature main) {
		for (Creature c : list) {
			if (main.getX() == c.getX() - 1 && main.getY() == c.getY()) {
				return c;
			}
		}
		return null;
	}
	
	public void remove(Creature c) {
		c.creatureAhead = null;
		list.remove(c);
	}
	
	
}
