package creature;

import java.util.Scanner;

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
			System.out.println("Woah! Was that Monster always there?");
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
			System.out.println("Woah! Was that Monster always there?");
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
			System.out.println("Woah! Was that Monster always there?");
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
			System.out.println("Woah! Was that Monster always there?");
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
	
	// accepts user-input through console and
	// moves player accordingly
	public void move(Scanner console) {
		boolean validMove = false;
		
		// a valid move is one that either successfully moves
		// to another cell or attacks
		while (!validMove) {
			// allow user to use any combination of upper-/lower-case
			// and words/punctuation as long as first letter is valid
			switch(Character.toLowerCase(console.next().charAt(0))) {
				case 'n':
					validMove = moveNorth();
					break;
				case 's':
					validMove = moveSouth();
					break;
				case 'w':
					validMove = moveWest();
					break;
				case 'e':
					validMove = moveEast();
					break;
				case 'a':
					attack();
					validMove = true;
					break;
				default:
					System.out.println("Please input a valid move. ");
			}
		}
	}

}
