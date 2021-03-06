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
	protected String name;
	protected Cell cell;
	
	static {
		maze = MazeMain.getMaze(new Scanner(System.in));
	}
	
	public static void newMaze() {
		maze = MazeMain.getMaze(new Scanner(System.in));
	}
	
	public static void resetMaze() {
		maze.reset();
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
	// random amount between 10-20, though there is a 10%
	// chance that the attack either misses or doubles;
	// otherwise, attack nothing
	public void attack() {
		if (creatureAhead != null) {
			int chance = r.nextInt(10);
			if (chance == 0) {
				System.out.printf("%s's attack missed!\n", name);
			} else {
				int attack = r.nextInt(10) + 10;
				if (chance == 1) {
					System.out.print("Critical hit! ");
					attack *= 2;
				}
				creatureAhead.setHealth(creatureAhead.getHealth() - attack);
				System.out.printf("%s attacked %s for %d health.\n", name,
						creatureAhead.getName(), attack);
				if (creatureAhead.getHealth() <= 0) {
					System.out.printf("%s killed %s.\n", name, creatureAhead.getName());
					creatureAhead.getCell().setOccupied(null);
					creatureAhead = null;
				}
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
		return this instanceof Player;
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
