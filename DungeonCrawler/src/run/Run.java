package run;
import player.*;
import maze.Maze;
import java.util.*;
import monster.*;

public class Run {
	
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		Maze maze = giveIntro(console);
		Player p = new Player(maze);
		Monster m = new Monster(50, maze);
		
		System.out.println("what do?");
		String action = console.next();
		while(!action.equals("end")) {
			System.out.print(p.getHealth());
			switch(action) {
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
				case "attack":
					p.attack();
					break;
			}
			action = console.next();
	}
		console.close();
	}
	
	public static Maze giveIntro(Scanner console) {
		System.out.println("Welcome to my dungeon crawler!");
		System.out.println();
		System.out.println("Your dungeon is an x by y maze");
		System.out.print("   in which x is");
		int x = getDim(console);
		System.out.print("and y is");
		int y = getDim(console);
		System.out.println();
		System.out.println("Can you find the end without dying?");
		System.out.println();
		return new Maze(x, y);
	}
	
	// ensure user inputs an integer greater than 0
	public static int getDim(Scanner console) {
		int dim = -1;

		while (dim <= 0) {
			System.out.print(" (input an integer greater than 0) ");
			if (!console.hasNextInt()) {
				console.next();
			} else {
				dim = console.nextInt();
			}
			System.out.print("   ");
		}
		return dim;
	}
}
