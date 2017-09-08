package maze;
import java.util.*;

public class Maze {
	private int n; // dimension of maze
	private Cell[][] maze;
	private Random r;
	
	public Maze(int dim) {
		n = dim;
		maze = new Cell[n][n];
		
		// initialize maze
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = new Cell();
			}
		}
		r = new Random();
		
		generate(0, 0);
	}
	
	// generate maze using depth-first search using recursive backtracking
	private void generate(int x, int y) {
		// if cell is in dimensions of maze
		if (x >= 0 && x < n && y >= 0 && y < n) {
			maze[x][y].visited = true;
				
			// if current cell has unvisited neighbors
			if (!maze[x][y + 1].visited || !maze[x][y - 1].visited
					|| !maze[x + 1][y].visited || !maze[x - 1][y].visited) { 
				boolean chosen = false;
				do {
					// randomly choose an unvisited neighbor
					int n = r.nextInt(4);
					if (n == 0 && !maze[x][y + 1].visited) {
						maze[x][y].north = false; // remove neighboring wall
						maze[x][y + 1].south = false;
						generate(x, y + 1);
						chosen = true;
					} else if (n == 1 && !maze[x][y - 1].visited) {
						maze[x][y].south = false;
						maze[x][y - 1].north = false;
						generate(x, y - 1);
						chosen = true;
					} else if (n == 2 && !maze[x + 1][y].visited) {
						maze[x][y].east = false;
						maze[x + 1][y].west = false;
						generate(x + 1, y);
						chosen = true;
					} else if (n == 3 && !maze[x - 1][y].visited) {							
						maze[x][y].west = false;
						maze[x - 1][y].east = false;
						generate(x - 1, y);
						chosen = true;
					}
				} while (!chosen); // ensures that an unvisited neighbor is chosen
								
			}
		}
	}
	
	public int getDim() {
		return n;
	}
	
	public Cell getCell(int x, int y) {
		return maze[x][y];
	}
}
