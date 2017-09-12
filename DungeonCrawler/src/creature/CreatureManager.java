package creature;
import java.util.*;
import maze.*;

public class CreatureManager {
	private List<Creature> list;
	private List<Cell> cellList;
	
	public CreatureManager() {
		list = new ArrayList<Creature>();
		cellList = new ArrayList<Cell>();
	}
	
	public void addCreature(Creature c) {
		list.add(c);
	}
	
	public void moveCreatures() {
		for (Creature c : list) {
			if(c.getHealth() > 0) {
				if (c.hasPlayerNearby()) {
					c.attack();
				} else {
					c.randMove(cellList);
				}
			}
		}
	}
	
}
