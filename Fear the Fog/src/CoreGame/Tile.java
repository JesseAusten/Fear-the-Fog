package CoreGame;

public class Tile {

	private boolean passable;
	private boolean destructable;
	private boolean drawable;
	private boolean coreTile;
	private int offSetRow;
	private int offSetCol;
	private int row;
	private int col;

	public Tile(boolean passable, boolean destructable, boolean drawable, boolean coreTile, int offSetRow, int offSetCol) {

		this.passable = passable;
		this.destructable = destructable;
		this.drawable = drawable;
		this.offSetRow = offSetRow;
		this.offSetCol = offSetCol;
		this.coreTile = coreTile;

	}

	public boolean getPassable() {

		return passable;

	}

	public boolean getCoretile() {

		return this.coreTile;
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

		this.row = row + this.offSetRow;
	}

	public void setColumn(int column) {

		this.col = column + this.offSetCol;

	}

	public void setCoreTile(boolean coreTile) {

		this.coreTile = coreTile;

	}

}
