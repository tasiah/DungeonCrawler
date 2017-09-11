package maze;
import java.util.*;

public class Maze {
	private final int dimX; // dimension of maze in x direction
	private final int dimY; // dimension of maze in y direction
	private Cell[][] maze;
	private Random r;
	private final Cell entrance;
	private final Cell exit;

	
	public Maze(int x, int y) {
		dimX = x;
		dimY = y;
		maze = new Cell[dimX][dimY];
		r = new Random();
		
		// initialize maze
		for (int i = 0; i < dimX; i++) {
			for (int j = 0; j < dimY; j++) {
				maze[i][j] = new Cell(i, j);
			}
		}
		
		entrance = maze[r.nextInt(dimX)][0];
		exit = maze[r.nextInt(dimX)][dimY - 1];
		generate(entrance);
		
	}
	
	private void generate(Cell initial) {
		initial.visited = true;
		generate(initial, new ArrayList<Cell>());
	}
	
	// generate a maze using depth-first search via recursive backtracking
	// list is for randNeighbor efficiency, and is a parameter until I find
	// a better way to implement it	that's still efficient
	private void generate(Cell cell, List<Cell> list) {
		Cell neighbor = randNeighbor(cell, list);
		if (neighbor != null) {
			neighbor.visited = true;
			removeWall(cell, neighbor);
			generate(neighbor, list);
			generate(cell, list); // backtracking part of recursive backtracking
							      // makes sure no neighbor left un-turned
		}
	}
	
	// randomly choose and return an unvisited neighbor cell
	private Cell randNeighbor(Cell cell, List<Cell> list) {
		list.clear();
		
		// if north cell is unvisited, add it to list
		if (northCell(cell) != null && !northCell(cell).visited) {
			list.add(northCell(cell));
		}
		if (southCell(cell) != null && !southCell(cell).visited) {
			list.add(southCell(cell));
		}
		if (eastCell(cell) != null && !eastCell(cell).visited) {
			list.add(eastCell(cell));
		}
		if (westCell(cell) != null && !westCell(cell).visited) {
			list.add(westCell(cell));
		}
		if (list.isEmpty()) { // cell has no unvisited neighbors
			return null;
		} else { // return a random unvisited neighbor from list
			return list.get(r.nextInt(list.size()));
		}
	}
	
	// remove wall between cell and neighbor
	private void removeWall(Cell cell, Cell neighbor) {
		if (neighbor == northCell(cell)) {
			cell.north = false;
			neighbor.south = false;
		} else if (neighbor == southCell(cell)) {
			cell.south = false;
			neighbor.north = false;
		} else if (neighbor == eastCell(cell)) {
			cell.east = false;
			neighbor.west = false;
		} else { // neighbor == westCell(cell)				
			cell.west = false;
			neighbor.east = false;
		}
	}
	
	// return cell north of given cell
	public Cell northCell(Cell cell) {
		if (cell.y + 1 < dimY) {
			return maze[cell.x][cell.y + 1];
		} else {
			return null;
		}
	}
	
	// return cell south of given cell
	public Cell southCell(Cell cell) {
		if (cell.y - 1 >= 0) {
			return maze[cell.x][cell.y - 1];
		} else {
			return null;
		}
	}
	
	// return cell east of given cell
	public Cell eastCell(Cell cell) {
		if (cell.x + 1 < dimX) {
			return maze[cell.x + 1][cell.y];
		} else {
			return null;
		}
	}
	
	// return cell west of given cell
	public Cell westCell(Cell cell) {
		if (cell.x - 1 >= 0) {
			return maze[cell.x - 1][cell.y];
		} else {
			return null;
		}
	}
	
	// returns whether there is a wall north of given point
	public boolean northWall(int x, int y) {
		return maze[x][y].north;
	}
	
	// returns whether there is a wall south of given point
	public boolean southWall(int x, int y) {
		return maze[x][y].south;
	}
	
	// returns whether there is a wall east of given point
	public boolean eastWall(int x, int y) {
		return maze[x][y].east;
	}
	
	// returns whether there is a wall west of given point
	public boolean westWall(int x, int y) {
		return maze[x][y].west;
	}
	
	public boolean atExit(int x, int y) {
		return exit.x == x && exit.y == y;
	}
	
	public boolean atEntrance(int x, int y) {
		return entrance.x == x && entrance.y == y;
	}
	
	public int getStartingX() {
		return entrance.x;
	}
	
	public int getStartingY() {
		return entrance.y;
	}
	
	public int getDimX() {
		return dimX;
	}
	
	public int getDimY() {
		return dimY;
	}
}
