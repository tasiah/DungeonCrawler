package creature;
import helperClasses.CellList;


public class Monster extends Creature{
	
	public Monster(int health) {
		super("monster", health);
		cell = maze.getRandCell();
		while (cell.isOccupied()) {
			cell = maze.getRandCell();
		}
		cell.setOccupied(this);
		System.out.println(cell.getY());
	}
	
	public void randMove() {
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
	
		// only move if there are available spaces
		if (CellList.hasCells()) { 
			cell.setOccupied(null);
			cell = CellList.pickRandom();
			cell.setOccupied(this);
		}
	}
	
	public boolean hasPlayerNearby() {
		if (!cell.hasNorthWall() && maze.northCell(cell).isOccupied() && maze.northCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.northCell(cell).getOccupied();
		} else if (!cell.hasSouthWall() && maze.southCell(cell).isOccupied() && maze.southCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.southCell(cell).getOccupied();
		} else if (!cell.hasEastWall() && maze.eastCell(cell).isOccupied() && maze.eastCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.eastCell(cell).getOccupied();	
		} else if (!cell.hasWestWall() && maze.westCell(cell).isOccupied() && maze.westCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.westCell(cell).getOccupied();
		} else {
			creatureAhead = null;
		}
		return creatureAhead != null;
	}
	
}
