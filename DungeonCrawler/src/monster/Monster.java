package monster;
import maze.Maze;
import creature.*;

public class Monster extends Creature{
	
	public Monster(int health, Maze maze) {
		super("monster", health);
		x = r.nextInt(maze.getDimX());
		y = r.nextInt(maze.getDimY());
		cm.addCreature(this);
	}
	
	public void move(Maze maze) {
		if (creatureAhead != null && creatureAhead.isPlayer()) {
			attack();
		} else {
			int randMove = r.nextInt(4);
			if (randMove == 0) {
				moveNorth(maze);
			} else if (randMove == 1) {
				moveSouth(maze);
			} else if (randMove == 2) {
				moveEast(maze);
			} else {
				moveWest(maze);
			}
		}
	}
	
	public void moveNorth(Maze maze) {
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
	
	public void moveSouth(Maze maze) {
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
	
	public void moveEast(Maze maze) {
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
	
	public void moveWest(Maze maze) {
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
