package maze;
import java.util.*;
import helperClasses.CellList;

/*
 * The Maze class randomly generates a maze with a random starting point along
 * the southern border and a random ending point along the northern border.
 */
public class Maze {
	private final int dimX; // dimension of maze in x direction
	private final int dimY; // dimension of maze in y direction
	private Cell[][] maze;
	private Random r;
	private final Cell entrance;
	private final Cell exit;

	// creates a new x by y Maze
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
		
		// randomly choose a starting point from along the southern border
		entrance = maze[r.nextInt(dimX)][0];
		// randomly choose an ending point from along the northern border
		exit = maze[r.nextInt(dimX)][dimY - 1];
		
		generate();
		addItems();
	}
	
	// generates a maze starting from its entrance
	private void generate() {
		entrance.visited = true;
		generate(entrance);
	}
	
	// generates a maze using depth-first search via recursive backtracking
	// list is for randNeighbor efficiency, and is a parameter until I find
	// a better way to implement it	that's still efficient
	private void generate(Cell cell) {
		Cell neighbor = randNeighbor(cell);
		if (neighbor != null) {
			neighbor.visited = true;
			removeWall(cell, neighbor);
			generate(neighbor);
			generate(cell); // backtracking part of recursive backtracking
		}
	}
	
	// since the maze is generated through a depth-fist search, there's 
	// probably going to be a lot of long pathways with dead-ends (at least
	// in the larger mazes); so, to make crawling these paths not so
	// worthless, there will be items at the end to reward the player
	private void addItems() {
		for (Cell[] row : maze) {
			for (Cell cell : row) {
				if (cell.has3Walls()  && cell != entrance && cell != exit) {
					cell.hasItem = true;
				}
			}
		}
	}
	
	// randomly chooses and returns an unvisited neighbor cell
	private Cell randNeighbor(Cell cell) {
		// if north cell is unvisited, add it to list
		if (northCell(cell) != null && !northCell(cell).visited) {
			CellList.add(northCell(cell));
		}
		if (southCell(cell) != null && !southCell(cell).visited) {
			CellList.add(southCell(cell));
		}
		if (eastCell(cell) != null && !eastCell(cell).visited) {
			CellList.add(eastCell(cell));
		}
		if (westCell(cell) != null && !westCell(cell).visited) {
			CellList.add(westCell(cell));
		}
		return CellList.pickRandom();
	}
	
	// removes wall between cell and neighbor
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
	
	// returns cell north of given cell
	public Cell northCell(Cell cell) {
		if (cell.y + 1 < dimY) {
			return maze[cell.x][cell.y + 1];
		} else {
			return null;
		}
	}
	
	// returns cell south of given cell
	public Cell southCell(Cell cell) {
		if (cell.y - 1 >= 0) {
			return maze[cell.x][cell.y - 1];
		} else {
			return null;
		}
	}
	
	// returns cell east of given cell
	public Cell eastCell(Cell cell) {
		if (cell.x + 1 < dimX) {
			return maze[cell.x + 1][cell.y];
		} else {
			return null;
		}
	}
	
	// returns cell west of given cell
	public Cell westCell(Cell cell) {
		if (cell.x - 1 >= 0) {
			return maze[cell.x - 1][cell.y];
		} else {
			return null;
		}
	}
	
	// returns exit of maze
	public Cell getExit() {
		return exit;
	}
	
	// returns entrance of maze
	public Cell getEntrance() {
		return entrance;
	}
	
	// returns a random cell within the maze
	public Cell getRandCell() {
		return maze[r.nextInt(dimX)][r.nextInt(dimY)];
	}
	
	// reset maze by setting all cells' occupied to null and 
	// replacing items
	public void reset() {
		for (Cell[] row : maze) {
			for (Cell cell : row) {
				if (cell.has3Walls()  && cell != entrance && cell != exit) {
					cell.hasItem = true;
				}
				cell.setOccupied(null);
			}
		}
	}
}
