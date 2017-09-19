package creature;
import helperClasses.CellList;

/*
 * A Monster is a Creature that randomly spawns
 * and moves within a maze.
 */
public class Monster extends Creature{
	
	// creates a new monster with the given health
	public Monster(int health) {
		super("Monster", health);
		
		cell = maze.getRandCell();
		
		// ensures that only one creature spawns at 
		// a cell
		while (cell.isOccupied()) {
			cell = maze.getRandCell();
		}
		cell.setOccupied(this);
	}
	
	// attacks creatureAhead and prints out creatureAhead's health
	public void attack() {
		super.attack();
		if (creatureAhead != null) {
			System.out.printf("%s's health is now %d.\n", creatureAhead.getName(),
					creatureAhead.getHealth());
		}
	}
	
	// attacks if Player is adjacent to monster;
	// otherwise randomly moves to a valid cell
	public void move() {
		if (hasPlayerNearby()) {
			attack();
		} else {
			randMove();
		}
	}
	
	// randomly moves monster to a valid cell, where valid means that the
	// cell is neither walled off or occupied
	private void randMove() {
		if (!cell.hasNorthWall() && !maze.northCell(cell).isOccupied()) {
			CellList.add(maze.northCell(cell));
		}
		if (!cell.hasSouthWall() && !maze.southCell(cell).isOccupied()) {
			CellList.add(maze.southCell(cell));
		}
		if (!cell.hasEastWall() && !maze.eastCell(cell).isOccupied()) {
			CellList.add(maze.eastCell(cell));
		}
		if (!cell.hasWestWall() && !maze.westCell(cell).isOccupied()) {
			CellList.add(maze.westCell(cell));
		}
		
		// does not move if there are no valid cells (CellList.isEmpty())
		moveTo(CellList.pickRandom());
	}
	
	// returns whether the monster has a player adjacent to it;
	// if so, updates creatureAhead accordingly
	private boolean hasPlayerNearby() {
		if (!cell.hasNorthWall() && maze.northCell(cell).isOccupied() 
				&& maze.northCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.northCell(cell).getOccupied();
		} else if (!cell.hasSouthWall() && maze.southCell(cell).isOccupied() 
				&& maze.southCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.southCell(cell).getOccupied();
		} else if (!cell.hasEastWall() && maze.eastCell(cell).isOccupied() 
				&& maze.eastCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.eastCell(cell).getOccupied();	
		} else if (!cell.hasWestWall() && maze.westCell(cell).isOccupied() 
				&& maze.westCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.westCell(cell).getOccupied();
		} else {
			creatureAhead = null;
		}
		
		// note: a monster only cares if creatureAhead.isPlayer();
		// it will ignore other monsters
		return creatureAhead != null;
	}
	
}
