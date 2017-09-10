package creature;
import java.util.*;

public class CreatureManager {
	private List<Creature> list;
	
	public CreatureManager() {
		list = new ArrayList<Creature>();
	}
	
	public void addCreature(Creature c) {
		list.add(c);
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
