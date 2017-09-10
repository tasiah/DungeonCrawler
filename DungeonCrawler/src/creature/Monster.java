package creature;
import creature.*;

public class Monster extends Creature{
	private static MonsterManager monsterManager;
	
	public Monster(int health) {
		super("monster", health);
		monsterManager.addMonster(this);
	}
	
	static {
		monsterManager = new MonsterManager();
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
