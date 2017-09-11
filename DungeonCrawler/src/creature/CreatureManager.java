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
	
	public void moveCreatures() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getHealth() > 0) {
				list.get(i).randMove();
			}
		}
	}
	
	
	
}
