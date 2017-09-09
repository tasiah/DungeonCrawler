package creature;
import java.util.*;
import maze.Maze;

public class Creature {
	protected int health;
	protected int x;
	protected int y;
	protected Random r;
	private static CreatureManager cm;
	
	public Creature(int health, Maze maze) {
		r = new Random();
		this.health = health;
		this.x = r.nextInt(maze.getDimX());
		this.y = r.nextInt(maze.getDimY());
	}
	
	public Creature(int x, int y, int health) {
		r = new Random();
		this.health = health;
		this.x = x;
		this.y = y;
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
	
	public void attack(Creature c) {
		c.setHealth(c.getHealth() - (r.nextInt(10) + 10));
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
	
	
}
