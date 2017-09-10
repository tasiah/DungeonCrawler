package creature;
import java.util.*;

public class Creature {
	protected int health;
	protected int x;
	protected int y;
	protected Random r;
	private static CreatureManager cm;
	protected Creature creatureAhead;
	protected String name;
	
	public Creature(String name, int health) {
		this.name = name;
		this.health = health;
		r = new Random();
		creatureAhead = null;
		cm.addCreature(this);
	}
	
	
	static {
		cm = new CreatureManager();
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
	
	public Creature creatureNorth() {
		return cm.creatureNorth(this);
	}
	
	public Creature creatureSouth() {
		return cm.creatureSouth(this);
	}
	
	public Creature creatureEast() {
		return cm.creatureEast(this);
	}
	
	public Creature creatureWest() {
		return cm.creatureWest(this);
	}
	
	public String getName() {
		return name;
	}
	
	
	
}
