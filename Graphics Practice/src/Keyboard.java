import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Keyboard extends Core implements KeyListener {

	public static void main(String[] args) {

		new Keyboard().run();

	}

	private String mess = "";

	// init also init from superclass

	public void init() {

		super.init();
		Window w = s.getFullScreenWindow();
		w.setFocusTraversalKeysEnabled(false);
		w.addKeyListener(this);
		mess = "press escape to exit";

	}

	// key pressed

	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ESCAPE) {

			stop();
		} else {

			mess = "Pressed: " + KeyEvent.getKeyText(keyCode);
			e.consume();
		}

	}

	// key released

	public void keyReleased(KeyEvent e) {

		int keyCode = e.getKeyCode();
		mess = "Released: " + KeyEvent.getKeyText(keyCode);
		e.consume();
	}

	// last method from iterface

	public void keyTyped(KeyEvent e) {

		e.consume();
	}
	
	//draw
	
	public synchronized void draw(Graphics2D g) {
		
		Window w = s.getFullScreenWindow();
		
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 1000, 1000);
	}

}




