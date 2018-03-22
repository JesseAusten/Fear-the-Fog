package CoreGame;

public class Player {

	private int row;
	private int col;
	private int velocity;
	private Tile[] tileSet;
	private Weapon currentWep;
	private boolean isAlive;
	

	public Player(int row, int col) {
		
		PatternIO loadPattern = new PatternIO();
		int[][] pattern = loadPattern.loadPattern("Player");

		this.row = row;
		this.col = col;
		this.isAlive = true;
		this.velocity = 2;

		tileSet = new Tile[pattern[0].length];
		tileSet[0] = new Tile(true, true, true, row, col);

		for (int i = 0; i < (tileSet.length - 1); i++) {

			tileSet[i + 1] = new Tile(true, true, false, pattern[0][i], pattern[1][i]);
			
		}

	}

	public int getRow() {

		return this.row;
	}

	public int getCol() {

		return this.col;
	}

	public int getVelocity() {

		return this.velocity;
	}

	public void setRow(int row) {

		this.row = row;
	}

	public void setCol(int col) {

		this.col = col;
	}

	public void setVelocity(int velocity) {

		this.velocity = velocity;
	}

}
