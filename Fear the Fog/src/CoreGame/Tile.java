package CoreGame;

public class Tile {

	private boolean passable;
	private boolean destructable;
	private boolean isAlive;
	private int row;
	private int col;

	public Tile(boolean passable, boolean destructable, boolean isAlive, int row, int col) {

		this.passable = passable;
		this.destructable = destructable;
		this.isAlive = isAlive;
		this.row = row;
		this.col = col;

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
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
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
	
	public void setRow(int row) {
		
		this.row = row;
	}
	
	public void setColumn(int column) {
		
		this.col = col;
		
	}

}
