package creature;
import java.util.*;
import maze.*;

public class Creature {
	protected int health;
	protected int x;
	protected int y;
	protected Random r;
	protected static Maze maze;
	protected Creature creatureAhead;
	protected String name;
	protected Cell cell;
	
	public Creature(String name, int health) {
		this.name = name;
		this.health = health;
		r = new Random();
		creatureAhead = null;
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
	
	public void attack() {
		if (creatureAhead != null) {
			int attack = r.nextInt(10) + 10;
			creatureAhead.setHealth(creatureAhead.getHealth() - attack);
			System.out.println(name + " attacked " + creatureAhead.getName()
					+ " for " + attack + "health");
			if (creatureAhead.getHealth() <= 0) {
				System.out.println(name + " killed " + creatureAhead.getName());
				cm.remove(creatureAhead);
			}
		} else {
			System.out.println(name + " attacked nothing");
		}
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
	
	public String getName() {
		return name;
	}
	
	public boolean isPlayer() {
		return name.equals("you");
	}
	
	public Creature getCreatureAhead() {
		return creatureAhead;
	}
	
	public void move() {
		if (creatureAhead != null && creatureAhead.isPlayer()) {
			attack();
		} else {
			int randMove = r.nextInt(4);
			if (randMove == 0) {
				moveNorth();
			} else if (randMove == 1) {
				moveSouth();
			} else if (randMove == 2) {
				moveEast();
			} else {
				moveWest();
			}
		}
	}
	
	public void moveNorth() {
		if (maze.northWall(x, y)) {
			System.out.println("wall");
		} else {
			creatureAhead = creatureNorth();
			if (creatureAhead != null) {
				System.out.println("monster");
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
	}
	
	public void moveSouth() {
		if (maze.southWall(x, y)) {
			System.out.println("wall");
		} else {
			creatureAhead = creatureSouth();
			if (creatureAhead != null) {
				System.out.println("monster");
			} else {
				y--;
				// moving south will never move the player to the exit
				System.out.println("moved south");
				if (maze.atEntrance(x, y)) {
					System.out.println("were we here before?");
				}
			}
		}
	}
	
	public void moveEast() {
		if (maze.eastWall(x, y)) {
			System.out.println("wall");
		} else {
			creatureAhead = creatureEast();
			if (creatureAhead != null) {
				System.out.println("monster");
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
	}
	
	public void moveWest() {
		if (maze.westWall(x, y)) {
			System.out.println("wall");
		} else {
			creatureAhead = creatureWest();
			if (creatureAhead != null) {
				System.out.println("monster");
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
	}
	
}
