package maze;
import java.util.*;

public class Maze {
	private int n; // dimension of maze
	private Cell[][] maze;
	private Random r;
	private List<String> list;
	
	public Maze(int dim) {
		n = dim;
		maze = new Cell[n][n];
		list = new ArrayList<String>();
		
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
			String neighbor = randNeighbor(x, y);
				
			if (neighbor != null) {
				if (neighbor.equals("north")) {
					maze[x][y].north = false; // remove neighboring wall
					maze[x][y + 1].south = false;
					generate(x, y + 1);
				} else if (neighbor.equals("south")) {
					maze[x][y].south = false;
					maze[x][y - 1].north = false;
					generate(x, y - 1);
				} else if (neighbor.equals("east")) {
					maze[x][y].east = false;
					maze[x + 1][y].west = false;
					generate(x + 1, y);
				} else { // neighbor.equals("west")						
					maze[x][y].west = false;
					maze[x - 1][y].east = false;
					generate(x - 1, y);
				}
			}
			
		}
	}
	
	public String randNeighbor(int x, int y) {
		list.clear();
		if (y + 1 < n && !maze[x][y + 1].visited) {
			list.add("north");
		}
		if (y - 1 >= 0 && !maze[x][y - 1].visited) {
			list.add("south");
		}
		if (x + 1 < n && !maze[x + 1][y].visited) {
			list.add("east");
		}
		if (x - 1 >= 0 && !maze[x - 1][y].visited) {
			list.add("west");
		}
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(r.nextInt(list.size()));
		}
	}
	
	public int getDim() {
		return n;
	}
	
	public Cell getCell(int x, int y) {
		return maze[x][y];
	}
}
