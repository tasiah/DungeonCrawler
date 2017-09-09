package player;
import maze.Maze;
import monster.Monster;
import java.util.*;

public class Player {
	private int x;
	private int y;
	private int health;
	private Random r;
	
	public Player(Maze maze) {
		x = maze.getStartingX();
		y = maze.getStartingY();
		health = 100;
		r = new Random();
	}
	
	public void moveNorth(Maze maze) {
		if (maze.northWall(x, y)) {
			System.out.println("wall");
		} else {
			y++;
			if (maze.atExit(x, y)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved north");
				if (maze.atEntrance(x, y)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public void moveSouth(Maze maze) {
		if (maze.southWall(x, y)) {
			System.out.println("wall");
		} else {
			y--;
			// moving south will never move the player to the exit
			System.out.println("moved south");
			if (maze.atEntrance(x, y)) {
				System.out.println("were we here before?");
			}
		}
	}
	
	public void moveEast(Maze maze) {
		if (maze.eastWall(x, y)) {
			System.out.println("wall");
		} else {
			x++;
			if (maze.atExit(x, y)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved east");
				if (maze.atEntrance(x, y)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public void moveWest(Maze maze) {
		if (maze.westWall(x, y)) {
			System.out.println("wall");
		} else {
			x--;
			if (maze.atExit(x, y)) {
				System.out.println("you did it");
			} else {
				System.out.println("moved west");
				if (maze.atEntrance(x, y)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void attack(Monster m) {
		m.setHealth(m.getHealth() - (r.nextInt(10) + 10));
	}

}
