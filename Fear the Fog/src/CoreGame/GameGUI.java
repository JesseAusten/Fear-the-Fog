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
	private JButton wall;
	private JButton player;
	private JButton monster;
	
	private Board board;
	private String currentButton = "";
	private boolean isMouseDown;
	private boolean isSmall = true;
	private boolean isLarge = false;
	
	private boolean isWall = false;
	private boolean isPlayer = false;
	private boolean isMonster = false;
	
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
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
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
		wall = new JButton("Wall");
		wall.setActionCommand("wall");
		wall.addActionListener(this);
		player = new JButton("Player");
		player.setActionCommand("player");
		player.addActionListener(this);
		monster = new JButton("Monster");
		monster.setActionCommand("monster");
		monster.addActionListener(this);
		//p2.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		p2.setPreferredSize(new Dimension(171, 661));
		p2.add(reset);
		p2.add(small);
		p2.add(large);
		p2.add(wall);
		p2.add(player);
		p2.add(monster);
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
		
	// Sets the cell to be a given mode.
	private void setCell(String cell) {
		String[] commands = cell.split(" ");		// Get the command for the button "row col"
		int row = Integer.parseInt(commands[0]);
		int col = Integer.parseInt(commands[1]);
		
		if (isSmall)
			setSingleCell(row, col);
		else if (isLarge)
			for (int i = -1; i <= 1; i++)
				for (int j = -1; j <=1; j++)
					if ((row+i) >= 0 && (row+i) <= (button_row-1) 
							&& (col+j) >= 0 && (col+j) <= (button_col-1))
						setSingleCell(row+i, col+j);
	}
	
	private void setSingleCell(int row, int col) {
		if (currentButton.equals("wall")) {
			if (isSmall && getCell(row, col).equals("wall"))// Clear wall.
				clearCell(row,col);
			else {								// Set Wall.
				setColor(row, col, Color.BLACK);
				board.setCell(row, col, getType("wall"));
			}
		}
		else if (currentButton.equals("player")) {			// Set player.
			if (isSmall && getCell(row, col).equals("player"))
				clearCell(row,col);
			else {
				setColor(row, col, Color.GREEN);
				board.setCell(row, col, getType("player"));
			}
		}
		else if (currentButton.equals("monster")) {			// Set monster.
			if (isSmall && getCell(row, col).equals("monster"))
				clearCell(row,col);
			else {
				setColor(row, col, Color.MAGENTA);
				board.setCell(row, col, getType("monster"));
			}
		}
	}
	
	private void clearCell(int row, int col) {
		setColor(row, col, Color.WHITE);
		board.setCell(row, col, getType("clear"));
	}

	private String getCell(int row, int col) {
		int mode = board.getCell(row, col);
		if (mode == 0)
			return "clear";
		else if (mode == 1)
			return "wall";
		else if (mode == 2)
			return "player";
		else if (mode == 3)
			return "monster";
		else
			return "";
	}
	
	private int getType(String type) {
		if (type.equals("clear"))
			return 0;
		else if (type.equals("wall"))
			return 1;
		else if (type.equals("player"))
			return 2;
		else if (type.equals("monster"))
			return 3;
		else
			return -1;
	}
	
	// Sets all of the buttons to white.
	public void resetBoardGUI() {
		for (int row = 0; row < button_row; row++)
			for (int col = 0; col < button_col; col++)
				clearCell(row, col);
	}
		
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		isMouseDown = true;
		JButton button = (JButton) e.getComponent();
		setCell(button.getActionCommand());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isMouseDown = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (isMouseDown) {
			JButton button = (JButton) e.getComponent();
			setCell(button.getActionCommand());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	// Actions for the buttons on the right panel.
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
		else
			currentButton = command;
	}
}
