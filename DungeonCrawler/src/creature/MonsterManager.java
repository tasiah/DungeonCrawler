package creature;
import java.util.*;

public class MonsterManager {
	private List<Monster> list;
	
	public MonsterManager() {
		list = new ArrayList<Monster>();
	}
	
	public void addMonster(Monster c) {
		list.add(c);
	}
	
	public void moveCreatures() {
		for (Monster m : list) {
			if(m.getHealth() > 0) {
				if (m.hasPlayerNearby()) {
					m.attack();
				} else {
					m.randMove();
				}
			}
		}
	}
	
}
