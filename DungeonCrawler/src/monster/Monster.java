package monster;
import player.Player;
import java.util.*;
import maze.Maze;

public class Monster {
	private int health;
	private Random r;
	private int x;
	private int y;
	
	public Monster(int health, Maze maze) {
		this.health = health;
		r = new Random();
		x = r.nextInt(maze.getDimX());
		y = r.nextInt(maze.getDimY());
	}
	
	public void attack(Player p) {
		p.setHealth(p.getHealth() - (r.nextInt(10) + 10));
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
}
