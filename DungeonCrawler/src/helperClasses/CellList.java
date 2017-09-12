package helperClasses;
import java.util.*;
import maze.Cell;

public class CellList {
	private static List<Cell> list;
	private static Random r;
	
	static {
		list = new ArrayList<Cell>();
		r = new Random();
	}
	
	public static void add(Cell c) {
		list.add(c);
	}
	
	public static Cell pickRandom() {
		Cell cell = list.get(r.nextInt(list.size()));
		list.clear();
		return cell;
	}
}
