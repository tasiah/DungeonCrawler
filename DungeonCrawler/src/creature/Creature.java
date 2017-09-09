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
	
}
