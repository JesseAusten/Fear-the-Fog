
import java.awt.DisplayMode;

import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Runtime extends JFrame {

	public static void main(String[] args) {

		DisplayMode dm = new DisplayMode(1920, 1080, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
		Runtime b = new Runtime();
		b.run(dm);

	}

	private Screen screen;
	private Image bg;
	private Animation a;

	// load picture and add scene
	public void loadPics() {

		bg = new ImageIcon("E:\\Pictures\\batman.jpg").getImage();
		Image banner1 = new ImageIcon("E:\\Pictures\\metempsy2.jpg").getImage();
		Image banner2 = new ImageIcon("E:\\Pictures\\meteskoz.jpg").getImage();
		a = new Animation();

		a.addScene(banner1, 250);
		a.addScene(banner2, 250);
	}

	public void run(DisplayMode dm) {

		// setBackground(Color.BLUE);
		// setForeground(Color.WHITE);
		// setFont(new Font("Arial", Font.PLAIN, 54));

			screen = new Screen();
		try {
			screen.setFullSCreen(dm, new JFrame());
			loadPics();
			movieLoop();

		} finally {
			screen.restoreScreen();
		}

	}

	// main movie loop

	public void movieLoop() {

		long startingTime = System.currentTimeMillis();
		long cumTime = startingTime;

		while (cumTime - startingTime < 5000) {

			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			a.update(timePassed);
			Graphics g = screen.getFullScreenWindow().getGraphics();
			draw(g);
			g.dispose();

			try {

				Thread.sleep(20);
			} catch (Exception e) {
			}

		}
	}

	public void draw(Graphics g) {

		g.drawImage(bg, 0, 0, null);
		g.drawImage(a.getImage(), 0, 500, null);
	}

	// public void paint(Graphics g) {
	//
	// if (g instanceof Graphics2D) {
	//
	// Graphics2D g2 = (Graphics2D) g;
	// g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	// RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	//
	// }
	// g.drawString("This is amazing!", 0, 1000);
	// }
}
