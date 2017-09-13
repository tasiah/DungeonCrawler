package creature;
import maze.*;

/*
 * A Player is a Creature that that spawns at the
 * entrance of the maze and is controlled by user input.
 */
public class Player extends Creature {
	
	// creates a new Player on the given maze
	public Player(Maze maze) {
		super("you", 100);
		cell = maze.getEntrance();
		Creature.maze = maze;
		cell.setOccupied(this);
	}
	
	// checks whether the Cell north of Player is valid, in
	// which valid means it's neither walled off nor occupied;
	// returns whether the Player successfully moves north;
	// notes if Player has returned to the entrance of the maze
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
	
	// checks whether the Cell south of Player is valid, in
	// which valid means it's neither walled off nor occupied;
	// returns whether the Player successfully moves south
	// notes if Player has returned to the entrance of the maze
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
	
	// checks whether the Cell east of Player is valid, in
	// which valid means it's neither walled off nor occupied;
	// returns whether the Player successfully moves east
	// notes if Player has returned to the entrance of the maze
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
	
	// checks whether the Cell west of Player is valid, in
	// which valid means it's neither walled off nor occupied;
	// returns whether the Player successfully moves west
	// notes if Player has returned to the entrance of the maze
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
	
	// returns whether Player is at the exit of the maze
	public boolean atExit() {
		return maze.getExit() == cell;
	}
	
	// returns whether Player is at the entrance of the maze
	public boolean atEntrance() {
		return maze.getEntrance() == cell;
	}

}
