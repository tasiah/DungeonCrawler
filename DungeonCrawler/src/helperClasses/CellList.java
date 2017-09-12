package helperClasses;
import java.util.*;
import maze.Cell;

/*
 * This class allows users to input cells into a CellList and then randomly
 * pick one from said list. Note that the user can only pick one cell from
 * the current CellList before it clears.
 */
public class CellList {
	private static List<Cell> list;
	private static Random r;
	
	static {
		list = new ArrayList<Cell>();
		r = new Random();
	}
	
	// adds the given cell to list
	public static void add(Cell c) {
		list.add(c);
	}
	
	// randomly returns a cell from list
	// or null if list is empty;
	// clears list after retrieving cell
	public static Cell pickRandom() {
		if (list.isEmpty()) {
			return null;
		} else {
			Cell cell = list.get(r.nextInt(list.size()));
			list.clear();
			return cell;
		}
	}
	
	public static boolean hasCells() {
		return !list.isEmpty();
	}

}
