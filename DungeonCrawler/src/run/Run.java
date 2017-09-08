package run;
import player.*;
import maze.*;
import java.util.*;

public class Run {
	
	
	public static void main(String[] args) {

		System.out.println("Can I navigate the maze?");
		
		Player p = new Player();
		Maze m = new Maze(3);
		
		Scanner console = new Scanner(System.in);
		System.out.println("what do?");
		String thing = console.next();
		if (thing.equals("north")) {
			p.moveNorth(m);
		}
		console.close();
	}
}
