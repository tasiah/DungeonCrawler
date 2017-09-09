package maze;
import java.util.*;

public class Maze {
	private int dim; // dimension of maze
	private Cell[][] maze;
	private Random r;
	private Cell entrance;
	private Cell exit;

	
	public Maze(int n) {
		dim = n;
		maze = new Cell[dim][dim];
		r = new Random();
		
		// initialize maze
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				maze[i][j] = new Cell();
				maze[i][j].x = i;
				maze[i][j].y = j;
			
			}
		}
		
		entrance = maze[r.nextInt(dim)][0];
		exit = maze[r.nextInt(dim)][dim];
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
		if (list.isEmpty()) { // cell has no unvisited neighbors
			return null;
		} else { // return a random unvisited neighbor from list
			return list.get(r.nextInt(list.size()));
		}
	}
	
	// remove wall between cell and neighbor
	private void removeWall(Cell cell, Cell neighbor) {
		System.out.println(1);
		if (neighbor == north(cell)) {
			cell.north = false;
			neighbor.south = false;
		} else if (neighbor == south(cell)) {
			cell.south = false;
			neighbor.north = false;
		} else if (neighbor == east(cell)) {
			cell.east = false;
			neighbor.west = false;
		} else { // neighbor == west(cell)				
			cell.west = false;
			neighbor.east = false;
		}
	}
	
	// return cell north of given cell
	public Cell north(Cell cell) {
		if (cell.y + 1 < dim) {
			return maze[cell.x][cell.y + 1];
		} else {
			return null;
		}
	}
	
	// return cell south of given cell
	public Cell south(Cell cell) {
		if (cell.y - 1 >= 0) {
			return maze[cell.x][cell.y - 1];
		} else {
			return null;
		}
	}
	
	// return cell east of given cell
	public Cell east(Cell cell) {
		if (cell.x + 1 < dim) {
			return maze[cell.x + 1][cell.y];
		} else {
			return null;
		}
	}
	
	// return cell west of given cell
	public Cell west(Cell cell) {
		if (cell.x - 1 >= 0) {
			return maze[cell.x - 1][cell.y];
		} else {
			return null;
		}
	}
	
	public int getDim() {
		return dim;
	}
	
	public Cell getCell(int x, int y) {
		return maze[x][y];
	}
	
	public Cell getEntrance() {
		return entrance;
	}
	
	public Cell getExit() {
		return exit;
	}
}
