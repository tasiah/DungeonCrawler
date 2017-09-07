package maze;

public class Cell {
	public boolean visited;
	public boolean north;
	public boolean east;
	public boolean south;
	public boolean west;
	
	public Cell() {
		visited = true;
		north = true;
		east = true;
		south = true;
		west = true;
	}
}
