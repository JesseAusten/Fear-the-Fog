package CoreGame;

public class Tile {

	private boolean passable;
	private boolean destructable;
	private boolean drawable;
	private boolean coreTile;
	private int row;
	private int col;

	public Tile(boolean passable, boolean destructable, boolean drawable, boolean coreTile, int row, int col) {

		this.passable = passable;
		this.destructable = destructable;
		this.drawable = drawable;
		this.row = row;
		this.col = col;
		this.coreTile = coreTile;

	}

	public boolean getPassable() {

		return passable;

	}

	public boolean getDestructable() {

		return destructable;

	}

	public boolean getDrawable() {

		return drawable;

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
	
	public void setDrawable(boolean drawable) {
		
		this.drawable = drawable;
	
	}
	
	public void setRow(int row) {
		
		this.row = row;
	}
	
	public void setColumn(int column) {
		
		this.col = column;
		
	}

}
