package monster;
import player.Player;
import maze.Maze;
import creature.*;

public class Monster extends Creature{
	
	public Monster(int health, Maze maze) {
		super(health, maze);
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
