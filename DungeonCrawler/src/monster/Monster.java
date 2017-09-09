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
	
	public boolean attack(Player p) {
		p.setHealth(p.getHealth() - (r.nextInt(10) + 10));
		return true;
	}
}
