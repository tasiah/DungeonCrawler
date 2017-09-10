package creature;
import java.util.*;
import maze.Maze;

public class Creature {
	protected int health;
	protected int x;
	protected int y;
	protected Random r;
	protected static MonsterManager cm;
	protected static Maze maze;
	protected String name;
	
	public Creature(String name, int health) {
		this.name = name;
		this.health = health;
		r = new Random();
	}
	
	
	static {
		cm = new MonsterManager();
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void attack() {
		if (creatureAhead != null) {
			int attack = r.nextInt(10) + 10;
			creatureAhead.setHealth(creatureAhead.getHealth() - attack);
			System.out.println(name + " attacked " + creatureAhead.getName()
					+ " for " + attack + "health");
			if (creatureAhead.getHealth() <= 0) {
				System.out.println(name + " killed " + creatureAhead.getName());
				cm.remove(creatureAhead);
			}
		} else {
			System.out.println(name + " attacked nothing");
		}
	}
	
	
	public String getName() {
		return name;
	}
	
	public boolean isPlayer() {
		return name.equals("you");
	}
	
	public Creature getCreatureAhead() {
		return creatureAhead;
	}
	
	
}
