package creature;
import java.util.*;
import maze.*;

public class Creature {
	protected int health;
	protected Random r;
	protected static Maze maze;
	protected Creature creatureAhead;
	protected String name;
	protected Cell cell;
	
	public Creature(String name, int health) {
		this.name = name;
		this.health = health;
		r = new Random();
		creatureAhead = null;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	
	public void attack() {
		if (creatureAhead != null) {
			int attack = r.nextInt(10) + 10;
			creatureAhead.setHealth(creatureAhead.getHealth() - attack);
			System.out.println(name + " attacked " + creatureAhead.getName()
					+ " for " + attack + "health");
			if (creatureAhead.getHealth() <= 0) {
				System.out.println(name + " killed " + creatureAhead.getName());
				creatureAhead.getCell().setOccupied(null);
				creatureAhead = null;
			}
		} else {
			System.out.println(name + " attacked nothing");
		}
	}
	
	public Cell getCell() {
		return cell;
	}

	public String getName() {
		return name;
	}
	
	public boolean isPlayer() {
		return name.equals("you");
	}
	
	public Creature getCreatureAhead() {
		return creatureAhead;
	}
	
	public void randMove(List<Cell> list) {
		list.clear();
		if (!cell.hasNorthWall() && !maze.northCell(cell).isOccupied()) {
			list.add(maze.northCell(cell));
		}
		if (!cell.hasSouthWall() && !maze.southCell(cell).isOccupied()) {
			list.add(maze.southCell(cell));
		}
		if (!cell.hasEastWall() && !maze.eastCell(cell).isOccupied()) {
			list.add(maze.eastCell(cell));
		}
		if (!cell.hasWestWall() && !maze.westCell(cell).isOccupied()) {
			list.add(maze.westCell(cell));
		}
		if (!list.isEmpty()) {
			Cell newCell = list.get(r.nextInt(list.size()));
			cell.setOccupied(null);
			cell = newCell;
			cell.setOccupied(this);
		}
	}
	
	public boolean hasPlayerNearby() {
		if (!cell.hasNorthWall() && maze.northCell(cell).isOccupied() && maze.northCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.northCell(cell).getOccupied();
		} else if (!cell.hasSouthWall() && maze.southCell(cell).isOccupied() && maze.southCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.southCell(cell).getOccupied();
		} else if (!cell.hasEastWall() && maze.eastCell(cell).isOccupied() && maze.eastCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.eastCell(cell).getOccupied();	
		} else if (!cell.hasWestWall() && maze.westCell(cell).isOccupied() && maze.westCell(cell).getOccupied().isPlayer()) {
			creatureAhead = maze.westCell(cell).getOccupied();
		} else {
			creatureAhead = null;
		}
		return creatureAhead != null;
	}
	
}
