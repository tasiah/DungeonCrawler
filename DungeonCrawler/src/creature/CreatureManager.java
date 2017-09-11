package creature;
import java.util.*;

public class CreatureManager {
	private static List<Creature> list;
	// separate players and monsters?
	
	public CreatureManager() {
		list = new ArrayList<Creature>();
	}
	
	public void addCreature(Creature c) {
		list.add(c);
	}
	
	public static Creature creatureNorth(Creature main) {
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
		list.remove(c);
	}
	
	public static void moveCreatures() {
		for (int i = 1; i < list.size(); i++) {
			list.get(i).move();
		}
	}
	
	
	
}
