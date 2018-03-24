package CoreGame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameGUI implements ActionListener, MouseListener {

	private final int _button_size = 7;
	private int button_col;
	private int button_row;
	private int pixelLength;
	private int pixelHeight;
	
	private JButton[][] buttons;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	
	private JButton reset;
	private JButton small;
	private JButton large;
	
	private Board board;
	private boolean isMouseDown;
	private boolean isSmall = true;
	private boolean isLarge = false;
	
	public GameGUI(Board board, int pixelLength, int pixelHeight) {
		
		this.board = board; 
		this.pixelLength = pixelLength;
		this.pixelHeight = pixelHeight;
		button_col = board.getLength();
		button_row = board.getHeight();
		isMouseDown = false;
		
		buttonPanel = getButtonPanel();
		setupMainPanel();
		
		JFrame frame = new JFrame("Fear the Fog");
        frame.add(mainPanel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
	
	// Set up the button panel to hold all of the boards buttons.
	// All buttons are size _button_size and have a border in between 1 pixel wide.
	private JPanel getButtonPanel() {
		JPanel panel = new JPanel(new GridLayout(button_row, button_col, 0, 0));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		panel.setPreferredSize(new Dimension(pixelLength, pixelHeight));

		buttons = new JButton[button_row][button_col];		// Initialize and add buttons to the buttonPanel.
		for (int row = 0; row < button_row; row++)				// Buttons have an empty (invisible) border,
			for (int col = 0; col < button_col; col++) {		// and their action command is set to "row col" based on their position.
				buttons[row][col] = new JButton();
				buttons[row][col].setBorder(BorderFactory.createEmptyBorder());
				buttons[row][col].setPreferredSize(new Dimension(_button_size, _button_size));
				buttons[row][col].setBackground(Color.WHITE);
				buttons[row][col].setActionCommand(row + " " + col);
				buttons[row][col].addMouseListener(this);
				panel.add(buttons[row][col]);
			}
		return panel;
	}
	
	// Return main panel for JFrame.
	private void setupMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.add(buttonPanel);
		
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
		p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
		// Setup buttons for right panel
		reset = new JButton("Reset");
		reset.setActionCommand("reset");
		reset.addActionListener(this);
		small = new JButton("Small Brush");
		small.setActionCommand("small");
		small.addActionListener(this);
		large = new JButton("Large Brush");
		large.setActionCommand("large");
		large.addActionListener(this);
		//p2.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		p2.setPreferredSize(new Dimension(171, 661));
		p2.add(reset);
		p2.add(small);
		p2.add(large);
		mainPanel.add(p2, c);
	
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;	
		c.gridx = 0;
		c.gridy = 5;	
		c.gridwidth = 5;
		c.weightx = .8;
		c.weighty = .1;
		p3 = new JPanel();
		//p3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		p3.setPreferredSize(new Dimension(766, 82));
		mainPanel.add(p3, c);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;	
		c.gridx = 5;
		c.gridy = 5;
		c.weightx = 0.2;
		c.weighty = .1;
		p4 = new JPanel();
		//p4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		p4.setPreferredSize(new Dimension(171, 82));
		mainPanel.add(p4, c);
	}
	
	// Sets the color of the given cell.
	public void setColor(int row, int col, Color color) {
		buttons[row][col].setBackground(color);
	}
	
	// Sets the cell to swap from black<->white.
	private void setCell(String cell) {
		String[] commands = cell.split(" ");		// Get the command for the button "row col"
		int row = Integer.parseInt(commands[0]);
		int col = Integer.parseInt(commands[1]);
		if (board.getCell(row, col) == 1)			
			setCell(cell, 0);		
		else
			setCell(cell, 1);
	}
		
	// Sets the cell to be a given mode.
	private void setCell(String cell, int mode) {
		String[] commands = cell.split(" ");		// Get the command for the button "row col"
		int row = Integer.parseInt(commands[0]);
		int col = Integer.parseInt(commands[1]);
		
		if (isSmall) {
			if (mode == 0)								// Set the color on the gui,
				setColor(row, col, Color.WHITE);			
			else if (mode == 1)
				setColor(row, col, Color.BLACK);	
			board.setCell(row, col, mode);				// and set the cell in the game's board.
		}
		else if (isLarge) {
			for (int i = -1; i <= 1; i++)
				for (int j = -1; j <=1; j++)
					if ((row+i) >= 0 && (row+i) <= (button_row-1) 
							&& (col+j) >= 0 && (col+j) <= (button_col-1)) {
						if (mode == 0)								// Set the color on the gui,
							setColor(row+i, col+j, Color.WHITE);			
						else if (mode == 1)
							setColor(row+i, col+j, Color.BLACK);	
						board.setCell(row+i, col+j, mode);			// and set the cell in the game's board.
					}
						
		}
	}

	// Sets all of the buttons to white.
	public void resetBoardGUI() {
		for (int row = 0; row < button_row; row++)
			for (int col = 0; col < button_col; col++)
				buttons[row][col].setBackground(Color.WHITE);
	}
		
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton button = (JButton) e.getComponent();	// Get the button in the grid that was clicked.
		setCell(button.getActionCommand());				// Switch the cell from white<->black.
	}

	@Override
	public void mousePressed(MouseEvent e) {
		isMouseDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isMouseDown = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (isMouseDown) {
			JButton button = (JButton) e.getComponent();
			setCell(button.getActionCommand(), 1);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (isMouseDown) {
			JButton button = (JButton) e.getComponent();
			setCell(button.getActionCommand(), 1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String command = button.getActionCommand();
		
		if (command == "reset")
			resetBoardGUI();
		else if (command == "small") {
			isSmall = true;
			isLarge = false;
		}
		else if (command == "large") {
			isSmall = false;
			isLarge = true;
		}
	}
}
