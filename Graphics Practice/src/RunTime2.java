import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class RunTime2 extends JFrame {

	public static void main(String[] args) {

		DisplayMode dm = new DisplayMode(1920, 1080, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
		Runtime b = new Runtime();
		b.run(dm);

	}

	private Sprites sprite;
	private ScreenManager screen;
	private Image bg;
	private Animation a;
	private static final DisplayMode modes1[] = {
			
			new DisplayMode(3840, 2160, 32,0),
			new DisplayMode(3840, 2160, 24,0),
			new DisplayMode(3840, 2160, 16,0),
			new DisplayMode(1920, 1080, 32,0),
			new DisplayMode(1920, 1080, 24,0),
			new DisplayMode(1920, 1080, 16,0)
					
	};

	// load picture and add scene
	public void loadPics() {

		bg = new ImageIcon("E:\\Pictures\\batman.jpg").getImage();
		Image banner1 = new ImageIcon("E:\\Pictures\\metempsy2.jpg").getImage();
		Image banner2 = new ImageIcon("E:\\Pictures\\meteskoz.jpg").getImage();
		a = new Animation();

		a.addScene(banner1, 250);
		a.addScene(banner2, 250);

		sprite = new Sprites(a);
		sprite.setVelocityX(2f);
		sprite.setVelocityY(2f);

	}

	public void run() {

		// setBackground(Color.BLUE);
		// setForeground(Color.WHITE);
		// setFont(new Font("Arial", Font.PLAIN, 54));

		screen = new ScreenManager();
		try {
			DisplayMode dm = screen.findFirstCompatibleMode(modes1);
			screen.setFullScreen(dm);
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
			update(timePassed);
			Graphics2D g = (Graphics2D)screen.getFullScreenWindow().getGraphics();
			draw(g);
			g.dispose();
			screen.update();

			try {

				Thread.sleep(20);
			} catch (Exception e) {
			}

		}
	}

	public void draw(Graphics g) {

		g.drawImage(bg, 0, 0, null);
		g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
		
	}

	// update sprite

	public void update(long timePassed) {

		if (sprite.getX() < 0) {

			sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
		}else if(sprite.getX()+ sprite.getWidth() >= screen.getWidth()) {
			
			sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
	
		}
		
		if (sprite.getY() < 0) {

			sprite.setVelocityY(Math.abs(sprite.getVelocityY()));
			
		}else if(sprite.getY()+ sprite.getHeight() >= screen.getHeight()) {
			
			sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
	
		}
		
		sprite.update(timePassed);
		
		
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
