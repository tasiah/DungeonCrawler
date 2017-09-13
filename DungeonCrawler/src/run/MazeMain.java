package run;
import maze.Maze;
import java.util.*;
import creature.*;

/*
 * MazeMain is the driver class that operates the maze and accepts
 * user input.
 */
public class MazeMain {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		Maze maze = giveIntro(console);
		Player p = new Player(maze);
		MonsterManager monsterManager = new MonsterManager();
		monsterManager.addMonster(50);
		
		System.out.println("Type \"north\", \"south\", \"east\", or "
				+ "\"west\", to move in that direction, or \"attack\".");

		// game continues until Player reaches exit or dies
		while(!p.atExit() && p.alive()) {
			boolean validMove = false;
			
			// a valid move is one that either successfully moves
			// cells or attacks
			while (!validMove) {
				switch(console.next()) {
					case "north":
						validMove = p.moveNorth();
						break;
					case "south":
						validMove = p.moveSouth();
						break;
					case "west":
						validMove = p.moveWest();
						break;
					case "east":
						validMove = p.moveEast();
						break;
					case "attack":
						p.attack();
						validMove = true;
						break;
				}
			}
			monsterManager.moveCreatures();
	}
		System.out.println("yer a winner");
		console.close();
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
		System.out.println("Beware! There are monsters lurking.");
		System.out.println("Can you find the exit without dying?");
		System.out.println();
		return new Maze(x, y);
	}
	
	// returns a user-determined integer greater than 0
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
