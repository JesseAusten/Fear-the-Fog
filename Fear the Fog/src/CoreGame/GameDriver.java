package CoreGame;

public class GameDriver {

	private int pixelLength;
	private int pixelHeight;
	private int button_col;
	private int button_row;
	
	private GameGUI gameGUI;
	private Board board;
	
	public GameDriver(int pixelLength, int pixelHeight, int button_col, int button_row) {
		this.pixelLength = pixelLength;
		this.pixelHeight = pixelHeight;
		this.button_col = button_col;
		this.button_row = button_row;
		board = new Board(button_col, button_row);
		gameGUI = new GameGUI(board, pixelLength, pixelHeight);
	}
	
	
	public static void main(String[] args) {
		GameDriver gameDriver = new GameDriver(884, 636, 125, 93);
	}
}
