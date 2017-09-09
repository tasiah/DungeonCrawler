package maze;
import java.util.*;

public class Maze {
	private int n; // dimension of maze
	private Cell[][] maze;
	private Random r;
	private List<Cell> list;
	
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

		generate(maze[0][0], new Stack<Cell>());
		

	}
	
	// generate a maze using depth-first search via recursive backtracking
	private void generate(Cell cell, Stack<Cell> s) {
		cell.visited = true;	
		Cell neighbor = randNeighbor(cell);
		if (neighbor != null) {
			s.push(cell);
			removeWall(cell, neighbor);
			generate(neighbor, s);
		} else if (!s.isEmpty()) {
			generate(s.pop(), s);
		}
	}
	
	private Cell randNeighbor(Cell cell) {
		list.clear();
		if (north(cell) != null && !north(cell).visited) {
			list.add(north(cell));
		}
		if (south(cell) != null && !south(cell).visited) {
			list.add(south(cell));
		}
		if (east(cell) != null && !east(cell).visited) {
			list.add(east(cell));
		}
		if (west(cell) != null && !west(cell).visited) {
			list.add(west(cell));
		}
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(r.nextInt(list.size()));
		}
	}
	
	private void removeWall(Cell cell, Cell neighbor) {
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
	
	public Cell north(Cell cell) {
		if (cell.y + 1 < n) {
			return maze[cell.x][cell.y + 1];
		} else {
			return null;
		}
	}
	
	public Cell south(Cell cell) {
		if (cell.y - 1 >= 0) {
			return maze[cell.x][cell.y - 1];
		} else {
			return null;
		}
	}
	
	public Cell east(Cell cell) {
		if (cell.x + 1 < n) {
			return maze[cell.x + 1][cell.y];
		} else {
			return null;
		}
	}
	
	public Cell west(Cell cell) {
		if (cell.x - 1 >= 0) {
			return maze[cell.x - 1][cell.y];
		} else {
			return null;
		}
	}
	
	public int getDim() {
		return n;
	}
	
	public Cell getCell(int x, int y) {
		return maze[x][y];
	}
}
