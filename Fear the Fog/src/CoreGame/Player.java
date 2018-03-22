package CoreGame;

public class Player {

	private int column;
	private int row;
	private Tile[] tileSet;
	private boolean isAlive;
	private int[] columnShape;
	private int[] rowShape;

	public Player(int column, int row) {

		this.column = column;
		this.row = row;
		this.isAlive = true;

		tileSet = new Tile[columnShape.length];
		tileSet[0] = new Tile(true, true, true, column, row);

		for (int i = 0; i < (tileSet.length - 1); i++) {

			tileSet[i + 1] = new Tile(true, true, false, columnShape[i], rowShape[i]);

		}

	}

}
