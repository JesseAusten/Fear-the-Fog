package CoreGame;

public class Tile {

	private boolean passable;
	private boolean destructable;
	private boolean isAlive;
	private int column;
	private int row;

	public Tile(boolean passable, boolean destructable, boolean isAlive, int column, int row) {

		this.passable = passable;
		this.destructable = destructable;
		this.isAlive = isAlive;
		this.column = column;
		this.row = row;

	}

	public boolean getPassable() {

		return passable;

	}

	public boolean getDestructable() {

		return destructable;

	}

	public boolean getIsAlive() {

		return isAlive;

	}

	public void setPassable(boolean passable) {

		this.passable = passable;

	}

	public void setDestructable(boolean destructable) {

		this.destructable = destructable;

	}
	
	public void setIsAlive(boolean isAlive) {
		
		this.isAlive = isAlive;
	
	}
	
	public void setColumn(int column) {
		
		this.column = column;
		
	}
	
	public void setRow(int row) {
		
		this.row = row;
	}

}
