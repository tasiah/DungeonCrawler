package player;
import maze.*;
import creature.*;

public class Player extends Creature {
	
	public Player(Maze maze) {
		super("you", 100);
		cell = maze.getEntrance();
		Creature.maze = maze;
	}
	
	
	public void moveNorth() {
		if (cell.hasNorthWall()) {
			System.out.println("wall");
		} else if (maze.northCell(cell).isOccupied()) {
			creatureAhead = maze.northCell(cell).getOccupied();
			System.out.println("creature");
		} else {
			cell.setOccupied(null);
			cell = maze.northCell(cell);
			cell.setOccupied(this);
			System.out.println("moved north");
			if(atEntrance()) {
				System.out.println("were we here before?");
			}
		}
	}
	
	public void moveSouth() {
		if (cell.hasSouthWall()) {
			System.out.println("wall");
		} else if (maze.southCell(cell).isOccupied()) {
			creatureAhead = maze.southCell(cell).getOccupied();
			System.out.println("creature");
		} else {
			cell.setOccupied(null);
			cell = maze.southCell(cell);
			cell.setOccupied(this);
			if(atEntrance()) {
				System.out.println("were we here before?");
			}
		}
	}
	
	public void moveEast() {
		if (cell.hasEastWall()) {
			System.out.println("wall");
		} else if (maze.eastCell(cell).isOccupied()) {
			creatureAhead = maze.eastCell(cell).getOccupied();
			System.out.println("creature");
		} else {
			cell.setOccupied(null);
			cell = maze.eastCell(cell);
			cell.setOccupied(this);
			if(atEntrance()) {
				System.out.println("were we here before?");
			}
		}
	}
	
	public void moveWest() {
		if (cell.hasWestWall()) {
			System.out.println("wall");
		} else if (maze.westCell(cell).isOccupied()) {
			creatureAhead = maze.westCell(cell).getOccupied();
			System.out.println("creature");
		} else {
			cell.setOccupied(null);
			cell = maze.westCell(cell);
			cell.setOccupied(this);
			if(atEntrance()) {
				System.out.println("were we here before?");
			}
		}
	}
	
	public boolean atExit() {
		return maze.getExit() == cell;
	}
	
	public boolean atEntrance() {
		return maze.getEntrance() == cell;
	}
	
	/*public void moveNorth() {
		if (maze.northWall(x, y)) {
			System.out.println("wall");
		} else {
			creatureAhead = CreatureManager.creatureNorth(this);
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
	}*/
}
