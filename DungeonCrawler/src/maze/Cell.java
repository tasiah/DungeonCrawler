package maze;

public class Cell {
	public boolean visited;
	public boolean north; // is there a wall north of the cell?
	public boolean east;
	public boolean south;
	public boolean west;
	public final int x; // added final to prevent it from changing
	public final int y;
	
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
