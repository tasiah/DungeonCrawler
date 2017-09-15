package creature;

/*
 * A Player is a Creature that that spawns at the
 * entrance of the maze and is controlled by user input.
 */
public class Player extends Creature {
	
	// creates a new Player
	public Player(String name) {
		super(name, 100);
		cell = maze.getEntrance();
		cell.setOccupied(this);
		isPlayer = true;
	}
	
	// checks whether the Cell north of Player is valid, in
	// which valid means it's neither walled off nor occupied;
	// returns whether the Player successfully moves north;
	// notes if Player has returned to the entrance of the maze
	public boolean moveNorth() {
		if (cell.hasNorthWall()) {
			System.out.println("Oops! There's a wall in the way.");
			return false;
		} else if (maze.northCell(cell).isOccupied()) {
			creatureAhead = maze.northCell(cell).getOccupied();
			System.out.println("Woah! Was that monster always there?");
			return false;
		} else {
			moveTo(maze.northCell(cell));
			System.out.println(getName() + " moved north.");
			if(atEntrance()) {
				System.out.println("Were we here before?");
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
			System.out.println("Oops! There's a wall in the way.");
			return false;
		} else if (maze.southCell(cell).isOccupied()) {
			creatureAhead = maze.southCell(cell).getOccupied();
			System.out.println("Woah! Was that monster always there?");
			return false;
		} else {
			moveTo(maze.southCell(cell));
			System.out.println(getName() + " moved south.");
			if(atEntrance()) {
				System.out.println("Were we here before?");
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
			System.out.println("Oops! There's a wall in the way.");
			return false;
		} else if (maze.eastCell(cell).isOccupied()) {
			creatureAhead = maze.eastCell(cell).getOccupied();
			System.out.println("Woah! Was that monster always there?");
			return false;
		} else {
			moveTo(maze.eastCell(cell));
			System.out.println(getName() + " moved east.");
			if(atEntrance()) {
				System.out.println("Were we here before?");
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
			System.out.println("Oops! There's a wall in the way.");
			return false;
		} else if (maze.westCell(cell).isOccupied()) {
			creatureAhead = maze.westCell(cell).getOccupied();
			System.out.println("Woah! Was that monster always there?");
			return false;
		} else {
			moveTo(maze.westCell(cell));
			System.out.println(getName() + " moved west.");
			if(atEntrance()) {
				System.out.println("Were we here before?");
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
