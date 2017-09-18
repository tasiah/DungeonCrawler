package maze;
import creature.*;

public class Cell {
	protected boolean visited;
	protected boolean north; // is there a wall north of the cell?
	protected boolean east;
	protected boolean south;
	protected boolean west;
	protected final int x; // added final to prevent it from changing
	protected final int y;
	private Creature occupied;
	protected boolean hasItem;
	
	// creates new cell with given x, y coordinate
	public Cell(int x, int y) {
		visited = false;
		north = true;
		east = true;
		south = true;
		west = true;
		this.x = x;
		this.y = y;
		occupied = null; // null since no creature occupies this cell
	}
	
	// returns whether cell has a north wall
	public boolean hasNorthWall() {
		return north;
	}
	
	// returns whether cell has south wall
	public boolean hasSouthWall() {
		return south;
	}
	
	// returns whether cell has east wall
	public boolean hasEastWall() {
		return east;
	}
	
	// returns whether cell has west wall
	public boolean hasWestWall() {
		return west;
	}
	
	// returns whether cell is occupied
	public boolean isOccupied() {
		return occupied != null;
	}
	
	// returns Creature that occupies cell
	public Creature getOccupied() {
		return occupied;
	}
	
	// sets cell's occupied to given creature
	public void setOccupied(Creature c) {
		occupied = c;
	}
	
	// returns whether cell hasItem
	public boolean hasItem() {
		return hasItem;
	}
	
}
