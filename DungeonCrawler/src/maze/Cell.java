package maze;

public class Cell {
	protected boolean visited;
	protected boolean north; // is there a wall north of the cell?
	protected boolean east;
	protected boolean south;
	protected boolean west;
	protected final int x; // added final to prevent it from changing
	protected final int y;
	
	public Cell(int x, int y) {
		visited = false;
		north = true;
		east = true;
		south = true;
		west = true;
		this.x = x;
		this.y = y;
	}
}
