package maze;

public class Cell {
	public boolean visited;
	public boolean north; // is there a wall north of the cell?
	public boolean east;
	public boolean south;
	public boolean west;
	
	public Cell() {
		visited = false;
		north = true;
		east = true;
		south = true;
		west = true;
	}
}