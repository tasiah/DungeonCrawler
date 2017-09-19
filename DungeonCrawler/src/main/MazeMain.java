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
		
		System.out.println("Welcome to my dungeon crawler!");
		System.out.println();
		
		// new game instantiation
		Player p = new Player(console);
		MonsterManager monsterManager = new MonsterManager();
		
		playGame(console, p, monsterManager);
		while (playAgain(console)) {
			System.out.println();
			System.out.println();
			reset(console, p, monsterManager);
			playGame(console, p, monsterManager);
		}
		
		console.close();
		System.out.println();
		System.out.println("Thanks for playing!");
	}
	
	// gives introduction for game and prompts user for dimensions of the maze;
	// returns a new maze created from user input 
	public static Maze getMaze(Scanner console) {
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
	
	public static void playGame(Scanner console, Player p, MonsterManager monsterManager) {
		System.out.printf("\n%s's starting health is %d.\n\n", p.getName(), p.getHealth());
		System.out.println("Type \"north\", \"south\", \"east\", or "
				+ "\"west\" to move in that direction, or \"attack\".");
		System.out.println();

		// play game until Player reaches exit or dies
		while(!p.atExit() && p.alive()) {
			p.move();
			monsterManager.moveCreatures();
		}
		
		// end-of-game message
		System.out.println();
		if (p.atExit()) {
			System.out.println("Congratulations! You found the exit!");
		} else {
			System.out.println("GAME OVER. You have died.");
		}
	}
	
	// returns whether user responds with some variation of "yes"
	// to the question "play again?"
	public static boolean playAgain(Scanner console) {
		System.out.print("Play again? ");
		return Character.toLowerCase(console.next().charAt(0)) == 'y';
	}
	
	public static void reset(Scanner console, Player p, MonsterManager m) {
		System.out.print("Would you like a new maze? ");
		if (Character.toLowerCase(console.next().charAt(0)) == 'y') {
			Creature.newMaze();
		} else {
			Creature.resetMaze();
		}
		
		System.out.println();
		System.out.print("Would you like a new name? ");
		if (Character.toLowerCase(console.next().charAt(0)) == 'y') {
			p.reset(Player.getName(console));
		} else {
			p.reset(p.getName());
		}
		
		m.reset();
		System.out.println();
	}
}
