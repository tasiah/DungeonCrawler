package main;
import maze.Maze;
import java.util.*;
import creature.*;

/*
 * MazeMain is the driver class that operates the maze and its
 * creatures and accepts user input.
 */
public class MazeMain {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		Player p = new Player(getName(console));
		MonsterManager monsterManager = new MonsterManager();
		monsterManager.addMonster(50);
		
		System.out.printf("%s's starting health is %d.\n\n\n", p.getName(), p.getHealth());
		System.out.println("Type \"north\", \"south\", \"east\", or "
				+ "\"west\", to move in that direction, or \"attack\".");

		// game continues until Player reaches exit or dies
		while(!p.atExit() && p.alive()) {
			boolean validMove = false;
			
			// a valid move is one that either successfully moves
			// cells or attacks
			while (!validMove) {
				// allow user to use any combination of upper-/lower-case
				// and even words as long as first letter is valid
				switch(Character.toLowerCase(console.next().charAt(0))) {
					case 'n':
						validMove = p.moveNorth();
						break;
					case 's':
						validMove = p.moveSouth();
						break;
					case 'w':
						validMove = p.moveWest();
						break;
					case 'e':
						validMove = p.moveEast();
						break;
					case 'a':
						p.attack();
						validMove = true;
						break;
					default:
						System.out.println("Please input a valid move.");
				}
			}
			monsterManager.moveCreatures();
	}
		System.out.println("yer a winner");
		console.close();
	}
	
	public static String getName(Scanner console) {
		System.out.println();
		System.out.print("What is your name? ");
		String name = console.next();
		System.out.println();
		System.out.printf("Well, %s... beware! There are monsters lurking.\n", name);
		System.out.println("Can you find the exit without dying?");
		System.out.println();
		return name;
	}
	
	// gives introduction for game and prompts user for dimensions of the maze;
	// returns a new maze created from user input 
	public static Maze giveIntro(Scanner console) {
		System.out.println("Welcome to my dungeon crawler!");
		System.out.println();
		System.out.println("Your dungeon is a randomly generated x by y maze");
		System.out.print("   in which x is");
		int x = getDim(console);
		System.out.print("and y is");
		int y = getDim(console);
		System.out.println();
		return new Maze(x, y);
	}
	
	// returns a user-determined integer greater than 0
	private static int getDim(Scanner console) {
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
