package creature;
import java.util.*;
import maze.*;

public class MonsterManager {
	private List<Monster> list;
	private List<Cell> cellList;
	
	public MonsterManager() {
		list = new ArrayList<Monster>();
		cellList = new ArrayList<Cell>();
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
					m.randMove(cellList);
				}
			}
		}
	}
	
}
