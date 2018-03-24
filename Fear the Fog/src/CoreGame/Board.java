package CoreGame;

public class Board {
	
	// 0 is Empty (white)
	// 1 is Wall  (black)
	private int[][] board;
	private int length;
	private int height;
	
	public Board(int length, int height) {
		this.length = length;
		this.height = height;
		board = new int[height][length];
		
		for (int row = 0; row < height; row++)
			for (int col = 0; col < length; col++)
				board[row][col] = 0;
	}

	public int getLength() {
		return length;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setCell(int row, int col, int mode) {
		board[row][col] = mode;
	}
	
	public int getCell(int row, int col) {
		return board[row][col];
	}
}
