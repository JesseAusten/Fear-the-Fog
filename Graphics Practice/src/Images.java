import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;

public class Images extends JFrame {

	public static void main(String[] args) {

		DisplayMode dm = new DisplayMode(3840, 2160, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
		Images i = new Images();
		i.run(dm);

	}
	
	private Screen s;
	private Image bg;
	private Image pic;
	
	private boolean loaded;

	public void run(DisplayMode dm) {
		
		setBackground(Color.BLUE);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 54));
		loaded = false;

		s = new Screen();
		try {
			s.setFullSCreen(dm, this);
			
			loadPics();

			try {
				Thread.sleep(5000);
			} catch (Exception exe) {
			}

		} finally {
			s.restoreScreen();
		}

	}
	
	public void loadPics() {
		
		bg = new ImageIcon("E:\\Pictures\\batman.jpg").getImage();
		pic = new ImageIcon("E:\\Pictures\\metempsy.jpg").getImage();
		loaded = true;
		repaint();
	}

	public void paint(Graphics g) {
		
		if (g instanceof Graphics2D) {

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		}
		if(loaded) {
			
			g.drawImage(bg, 0, 0, null);
			g.drawImage(pic,0, 500, null);
		}
	}
	
	
}