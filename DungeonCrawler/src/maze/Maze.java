package maze;
import java.util.*;

public class Maze {
	private int n; // dimension of maze
	private Cell[][] maze;
	private Random r;
	private List<Cell> list;
	private Stack<Cell> s;
	private int visitedCount;
	
	public Maze(int dim) {
		n = dim;
		maze = new Cell[n][n];
		list = new ArrayList<Cell>();
		
		// initialize maze
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = new Cell();
				maze[i][j].x = i;
				maze[i][j].y = j;
			
			}
		}
		r = new Random();
		s = new Stack<Cell>();
		visitedCount = 0;
		generate(maze[0][0], s);
		
		// exit at upper left corner
		//maze[n-1][n-1].north = false;
		//maze[n-1][n-1].east = false;
	}
	
	// generate maze using depth-first search using recursive backtracking
	/*private void generate(int x, int y) {
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
	} */
	
	public void generate(Cell cell, Stack<Cell> s) {
		System.out.println("gen");
		cell.visited = true;
		if (++visitedCount < n * n) {
			Cell neighbor = randNeighbor(cell);
			if (neighbor != null) {
				s.push(cell);
				removeWall(cell, neighbor);
				generate(neighbor, s);
			} else if (!s.isEmpty()) {
				generate(s.pop(), s);
			}
		}
	}
	
	public Cell randNeighbor(Cell cell) {
		list.clear();
		if (cell.y + 1 < n && !maze[cell.x][cell.y + 1].visited) {
			list.add(maze[cell.x][cell.y + 1]);
		}
		if (cell.y - 1 >= 0 && !maze[cell.x][cell.y - 1].visited) {
			list.add(maze[cell.x][cell.y - 1]);
		}
		if (cell.x + 1 < n && !maze[cell.x + 1][cell.y].visited) {
			list.add(maze[cell.x + 1][cell.y]);
		}
		if (cell.x - 1 >= 0 && !maze[cell.x - 1][cell.y].visited) {
			list.add(maze[cell.x - 1][cell.y]);
		}
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(r.nextInt(list.size()));
		}
	}
	
	public void removeWall(Cell cell, Cell neighbor) {
		System.out.println("remove");
		if (neighbor.y == cell.y + 1) {
			cell.north = false; // remove neighboring wall
			neighbor.south = false;
		} else if (neighbor.y == cell.y - 1) {
			cell.south = false;
			neighbor.north = false;
		} else if (neighbor.x == cell.x + 1) {
			cell.east = false;
			neighbor.west = false;
		} else { // neighbor.x == cell.x -1						
			cell.west = false;
			neighbor.east = false;
		}
	}
	
	public int getDim() {
		return n;
	}
	
	public Cell getCell(int x, int y) {
		return maze[x][y];
	}
}
