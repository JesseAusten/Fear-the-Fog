package CoreGame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameGUI{

	private final int _button_size = 7;
	private final int _length = 884;
	private final int _height = 636;
	private final int _button_col = 125;
	private final int _button_row = 93;
	
	private JButton[][] buttons;
	public static JPanel buttonPanel;
	public static JPanel mainPanel;

	public static JPanel p2;

	public static JPanel p3;

	public static JPanel p4;
	
	public GameGUI() {

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		
		// Set up the button panel to hold all of the boards buttons.
		// All buttons are size _button_size and have a border in between 1 pixel wide.
		buttonPanel = new JPanel(new GridLayout(_button_row, _button_col, 1, 1));
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
		buttonPanel.setPreferredSize(new Dimension(_length, _height));
		
		buttons = new JButton[_button_row][_button_col];		// Initialize and add buttons to the buttonPanel.
		for (int row = 0; row < _button_row; row++)				// Buttons have an empty (invisible) border,
			for (int col = 0; col < _button_col; col++) {		// and their action command is set to "row col" based on their position.
				buttons[row][col] = new JButton();
				buttons[row][col].setBorder(BorderFactory.createEmptyBorder());
				buttons[row][col].setPreferredSize(new Dimension(_button_size, _button_size));
				buttons[row][col].setActionCommand(row + " " + col);
				buttonPanel.add(buttons[row][col]);
			}
		
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;	
		c.gridx = 0;						
		c.gridy = 0;	
		c.gridwidth = 5;
		c.weightx = .8;
		c.weighty = .8;
		mainPanel.add(buttonPanel, c);
	
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;	
		c.gridx = 5;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weightx = .2;
		p2 = new JPanel();
		p2.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		p2.setPreferredSize(new Dimension(171, 661));
		mainPanel.add(p2, c);
	
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;	
		c.gridx = 0;
		c.gridy = 5;	
		c.gridwidth = 5;
		c.weightx = .8;
		c.weighty = .1;
		p3 = new JPanel();
		p3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		p3.setPreferredSize(new Dimension(766, 82));
		mainPanel.add(p3, c);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;	
		c.gridx = 5;
		c.gridy = 5;
		c.weightx = 0.2;
		c.weighty = .1;
		p4 = new JPanel();
		p4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p4.setPreferredSize(new Dimension(171, 82));
		mainPanel.add(p4, c);
		
		JFrame frame = new JFrame("Fear the Fog");
        frame.getContentPane().add(mainPanel);
        //frame.setLocationRelativeTo(null);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		GameGUI gameGUI = new GameGUI();
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(mainPanel.getSize().toString());
			System.out.println(p2.getSize().toString());
			System.out.println(p3.getSize().toString());
			System.out.println(p4.getSize().toString());
		}
	}
}
