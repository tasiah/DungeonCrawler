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
	
	
	
}
