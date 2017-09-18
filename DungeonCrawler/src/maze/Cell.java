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
	
	public boolean hasNorthWall() {
		return north;
	}
	
	public boolean hasSouthWall() {
		return south;
	}
	
	public boolean hasEastWall() {
		return east;
	}
	
	public boolean hasWestWall() {
		return west;
	}
	
	public boolean isOccupied() {
		return occupied != null;
	}
	
	public Creature getOccupied() {
		return occupied;
	}
	
	public void setOccupied(Creature c) {
		occupied = c;
	}
	
	public boolean hasItem() {
		return hasItem;
	}
	
}
