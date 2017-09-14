package creature;
import java.util.*;
import main.MazeMain;

import maze.*;

/*
 * A Creature has a name, health, and the ability
 * to attack another creature and move between cells.
 */
public class Creature {
	protected int health;
	private Random r;
	protected static Maze maze;
	protected Creature creatureAhead;
	private String name;
	protected Cell cell;
	
	static {
		maze = MazeMain.giveIntro(new Scanner(System.in));
	}
	
	// creates a new Creature with given name and health
	public Creature(String name, int health) {
		this.name = name;
		this.health = health;
		r = new Random();
		creatureAhead = null;
	}
	
	// returns Creature's health
	public int getHealth() {
		return health;
	}
	
	// sets health to given integer
	public void setHealth(int health) {
		this.health = health;
	}
	
	// returns whether Creature is alive (health > 0)s
	public boolean alive() {
		return health > 0;
	}
	
	// if creatureAhead exists, attack creatureAhead for a 
	// random amount between 10-20; otherwise, attack nothing
	public void attack() {
		if (creatureAhead != null) {
			int attack = r.nextInt(10) + 10;
			creatureAhead.setHealth(creatureAhead.getHealth() - attack);
			System.out.println(name + " attacked " + creatureAhead.getName().toLowerCase()
					+ " for " + attack + " health");
			if (creatureAhead.getHealth() <= 0) {
				System.out.println(name + " killed " + creatureAhead.getName().toLowerCase());
				creatureAhead.getCell().setOccupied(null);
				creatureAhead = null;
			}
		} else {
			System.out.println(name + " attacked nothing");
		}
	}
	
	// returns Creature's cell
	private Cell getCell() {
		return cell;
	}

	// returns Creature's name
	public String getName() {
		return name;
	}
	
	// returns whether Creature is the player
	public boolean isPlayer() {
		return name.equals("you");
	}
	
	// moves creature from current cell to given newCell
	public void moveTo(Cell newCell) {
		if (newCell != null) {
			cell.setOccupied(null);
			cell = newCell;
			cell.setOccupied(this);
		}
	}
	
}
