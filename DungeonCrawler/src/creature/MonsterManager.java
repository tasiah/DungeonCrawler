package Monster;
import java.util.*;

public class MonsterManager {
	private List<Monster> list;
	private Player p;
	
	public MonsterManager(Player p) {
		list = new ArrayList<Monster>();
		this.p = p;
	}
	
	public void addMonster(Monster c) {
		list.add(c);
	}
	
	public Monster monsterNorth() {
		for (Monster m : list) {
			if (p.getX() == m.getX() && p.getY() == m.getY() + 1) {
				return m;
			}
		}
		return null;
	}
	
	public Monster monsterSouth() {
		for (Monster m : list) {
			if (p.getX() == m.getX() && p.getY() == m.getY() - 1) {
				return m;
			}
		}
		return null;
	}
	
	public Monster MonsterEast(Player p) {
		for (Monster c : list) {
			if (main.getX() == c.getX() + 1 && main.getY() == c.getY()) {
				return c;
			}
		}
		return null;
	}
	
	public Monster MonsterWest(Monster main) {
		for (Monster c : list) {
			if (main.getX() == c.getX() - 1 && main.getY() == c.getY()) {
				return c;
			}
		}
		return null;
	}
	
	public void remove(Monster c) {
		c.MonsterAhead = null;
		list.remove(c);
	}
	
	public void moveMonsters() {
		for (int x = 1; x < list.size(); x++) { 
			c.move();
		}
	}
}
