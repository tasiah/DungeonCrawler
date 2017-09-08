package run;
import player.*;
import maze.*;
import java.util.*;

public class Run {
	
	
	public static void main(String[] args) {

		
		Player p = new Player();
		Maze maze = new Maze(3);
		
		giveIntro();
		
		Scanner console = new Scanner(System.in);
		System.out.println("what do?");
		String thing = console.next();
		while(!thing.equals("end")) {
			switch(thing) {
				case "north":
					p.moveNorth(maze);
					break;
				case "south":
					p.moveSouth(maze);
					break;
				case "west":
					p.moveWest(maze);
					break;
				case "east":
					p.moveEast(maze);
					break;
			}
			thing = console.next();
	}
		console.close();
	}
	
	public static void giveIntro() {
		System.out.println("Can I navigate the maze?");
	}
}
