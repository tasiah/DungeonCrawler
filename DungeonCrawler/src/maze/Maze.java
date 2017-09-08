package maze;
import java.util.*;

public class Maze {
	private int n; // dimension of maze
	private Cell[][] maze;
	private int numVisited;
	private Random r;
	
	public Maze(int dim) {
		n = dim;
		maze = new Cell[n][n];
		numVisited = 0;
		r = new Random();
		
		generate(0, 0);
	}
	
	// generate maze using depth-first search using recursive backtracking
	private void generate(int x, int y) {
		// if cell is in dimensions of maze
		if (x > 0 && x < n && y > 0 && y < n) {
			maze[x][y].visited = true;
				
			// if current cell has unvisited neighbors
			if (!maze[x][y + 1].visited | !maze[x][y - 1].visited
					| !maze[x + 1][y].visited | !maze[x - 1][y].visited) { 
				boolean chosen = true;
				do {
					// randomly choose an unvisited neighbor
					int n = r.nextInt(4);
					
					if (n == 0 && !maze[x][y + 1].visited) {
						maze[x][y].north = false;
						maze[x][y + 1].south = false;
						generate(x, y + 1);
					} else if (n == 1 && !maze[x][y - 1].visited) {
						maze[x][y].south = false;
						maze[x][y - 1].north = false;
						generate(x, y - 1);
					} else if (n == 2 && !maze[x + 1][y].visited) {
						maze[x][y].east = false;
						maze[x + 1][y].west = false;
						generate(x + 1, y);
					} else if (n == 3 && !maze[x - 1][y].visited) {							
						maze[x][y].west = false;
						maze[x - 1][y].east = false;
						generate(x - 1, y);
					} else {
						chosen = false;
					}
				} while (!chosen); // ensures that an unvisited neighbor is chosen
								
			}
		}
	}
	
}
