package CoreGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGUI extends JFrame {

	private final int BUTTON_SIZE = 7;
	private final int LENGTH = 1024;
	private final int HEIGHT = 718;
	private final int BUTTON_COL = (LENGTH - 24) / (BUTTON_SIZE + 1);
	private final int BUTTON_ROW = (HEIGHT - 46) / (BUTTON_SIZE + 1);
	
	private JButton[][] buttons;
	
	public GameGUI() {
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 1));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
		setSize(LENGTH, HEIGHT);
		
		buttons = new JButton[BUTTON_ROW][BUTTON_COL];
		for (int row = 0; row < BUTTON_ROW; row++)
			for (int col = 0; col < BUTTON_COL; col++) {
				buttons[row][col] = new JButton();
				buttons[row][col].setBorder(BorderFactory.createEmptyBorder());
				buttons[row][col].setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
				buttons[row][col].setActionCommand(row + " " + col);
				panel.add(buttons[row][col]);
			}
		add(panel);
		setTitle("Fear the Fog");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		GameGUI gameGUI = new GameGUI();
	}
}
