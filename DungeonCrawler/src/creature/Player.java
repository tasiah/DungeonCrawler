package creature;
import maze.Maze;

public class Player extends Creature {
	private Monster monsterAhead;
	
	public Player(Maze maze) {
		super("you", 100);
		x = maze.getStartingX();
		y = maze.getStartingY();
		Creature.maze = maze;
		monsterAhead = null;
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
	
	public Monster creatureNorth() {
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
