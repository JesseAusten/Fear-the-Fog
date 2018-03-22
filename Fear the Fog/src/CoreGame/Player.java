package CoreGame;

public class Player {

	private int row;
	private int col;
	private Tile[] tileSet;
	private boolean isAlive;
	private int[] rowShape;
	private int[] columnShape;

	public Player(int row, int col) {

		this.row = row;
		this.col = col;
		this.isAlive = true;

		tileSet = new Tile[columnShape.length];
		tileSet[0] = new Tile(true, true, true, row, col);

		for (int i = 0; i < (tileSet.length - 1); i++) {

			tileSet[i + 1] = new Tile(true, true, false, columnShape[i], rowShape[i]);

		}

	}

}
