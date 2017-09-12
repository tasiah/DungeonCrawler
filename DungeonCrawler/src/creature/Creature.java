package creature;
import java.util.*;
import maze.*;

public class Creature {
	protected int health;
	protected Random r;
	protected static Maze maze;
	protected Creature creatureAhead;
	protected String name;
	protected Cell cell;
	
	public Creature(String name, int health) {
		this.name = name;
		this.health = health;
		r = new Random();
		creatureAhead = null;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	
	public void attack() {
		if (creatureAhead != null) {
			int attack = r.nextInt(10) + 10;
			creatureAhead.setHealth(creatureAhead.getHealth() - attack);
			System.out.println(name + " attacked " + creatureAhead.getName()
					+ " for " + attack + "health");
			if (creatureAhead.getHealth() <= 0) {
				System.out.println(name + " killed " + creatureAhead.getName());
				creatureAhead.getCell().setOccupied(null);
				creatureAhead = null;
			}
		} else {
			System.out.println(name + " attacked nothing");
		}
	}
	
	public Cell getCell() {
		return cell;
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
