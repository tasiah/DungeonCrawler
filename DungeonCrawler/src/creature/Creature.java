package creature;
import java.util.*;
import maze.Maze;

public class Creature {
	protected int health;
	protected int x;
	protected int y;
	protected Random r;
	
	public Creature(int health, Maze maze) {
		r = new Random();
		this.health = health;
		this.x = r.nextInt(maze.getDimX());
		this.y = r.nextInt(maze.getDimY());
	}
	
	public Creature(int x, int y, int health, Maze maze) {
		r = new Random();
		this.health = health;
		this.x = x;
		this.y = y;
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
	
	public boolean creatureNorth(Creature c) {
		return c.getX() == x && c.getY() == y + 1;
	}
	
	public boolean creatureSouth(Creature c) {
		return c.getX() == x && c.getY() == y - 1;
	}
	
	public boolean creatureEast(Creature c) {
		return c.getX() == x + 1 && c.getY() == y;
	}
	
	public boolean creatureWest(Creature c) {
		return c.getX() == x - 1 && c.getY() == y;
	}
	
	
}
