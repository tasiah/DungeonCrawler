package run;
import player.*;
import maze.Maze;
import java.util.*;

public class Run {
	
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		Maze maze = giveIntro(console);
		Player p = new Player(maze);
		
		
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
	
	public static Maze giveIntro(Scanner console) {
		System.out.println("Welcome to my dungeon crawler!");
		System.out.print("Your dungeon will be a (insert integer)");
		int x = console.nextInt();
		System.out.print(" by (insert integer)");
		int y = console.nextInt();
		System.out.println("maze");
		System.out.println("Can reach the end without dying?");
		return new Maze(x, y);
		
	}
}
