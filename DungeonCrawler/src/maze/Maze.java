package maze;

public class Maze {
	private int n; // dimmension of maze
	private Cell[][] maze;
	
	public Maze(int dim) {
		n = dim;
		maze = new Cell[n + 2][n + 2];
		
		// initialize border cells as walls
		for (int x = 0; x < n + 2; x++) {
			maze[x][0].visited = true;
			maze[x][n + 1].visited = true;
		}
		for (int y = 0; y < n + 2; y++) {
			maze[0][y].visited = true;
			maze[n + 1][y].visited = true;
		}
	}
}
