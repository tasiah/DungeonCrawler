package creature;
import maze.*;

public class Player extends Creature {
	
	public Player(Maze maze) {
		super("you", 100);
		cell = maze.getEntrance();
		Creature.maze = maze;
		cell.setOccupied(this);
	}
	
	
	public boolean moveNorth() {
		if (cell.hasNorthWall()) {
			System.out.println("wall");
			return false;
		} else if (maze.northCell(cell).isOccupied()) {
			creatureAhead = maze.northCell(cell).getOccupied();
			System.out.println("creature");
			return false;
		} else {
			moveTo(maze.northCell(cell));
			System.out.println("moved north");
			if(atEntrance()) {
				System.out.println("were we here before?");
			}
			return true;
		}
	}
	
	public boolean moveSouth() {
		if (cell.hasSouthWall()) {
			System.out.println("wall");
			return false;
		} else if (maze.southCell(cell).isOccupied()) {
			creatureAhead = maze.southCell(cell).getOccupied();
			System.out.println("creature");
			return false;
		} else {
			moveTo(maze.southCell(cell));
			System.out.println("moved south");
			if(atEntrance()) {
				System.out.println("were we here before?");
			}
			return true;
		}
	}
	
	public boolean moveEast() {
		if (cell.hasEastWall()) {
			System.out.println("wall");
			return false;
		} else if (maze.eastCell(cell).isOccupied()) {
			creatureAhead = maze.eastCell(cell).getOccupied();
			System.out.println("creature");
			return false;
		} else {
			moveTo(maze.eastCell(cell));
			System.out.println("moved east");
			if(atEntrance()) {
				System.out.println("were we here before?");
			}
			return true;
		}
	}
	
	public boolean moveWest() {
		if (cell.hasWestWall()) {
			System.out.println("wall");
			return false;
		} else if (maze.westCell(cell).isOccupied()) {
			creatureAhead = maze.westCell(cell).getOccupied();
			System.out.println("creature");
			return false;
		} else {
			moveTo(maze.westCell(cell));
			System.out.println("moved west");
			if(atEntrance()) {
				System.out.println("were we here before?");
			}
			return true;
		}
	}
	
	public boolean atExit() {
		return maze.getExit() == cell;
	}
	
	public boolean atEntrance() {
		return maze.getEntrance() == cell;
	}

}
