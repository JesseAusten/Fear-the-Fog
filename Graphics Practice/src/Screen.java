import java.awt.*;
import javax.swing.JFrame;

public class Screen {

	private GraphicsDevice vc; //access video card

	public Screen() {

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice(); //gets default video driver

	}

	public void setFullSCreen(DisplayMode dm, JFrame window) {

		window.setUndecorated(true); //no border
		window.setResizable(false); // can't be resized
		vc.setFullScreenWindow(window); //set full screen

		if (dm != null && vc.isDisplayChangeSupported()) { //if display mode exists and can change, set display mode

			try {
				
				vc.setDisplayMode(dm);

			} catch (Exception ex) {
				System.out.println("error");
			}
		}

	}

	public Window getFullScreenWindow() {

		return vc.getFullScreenWindow();
	}

	public void restoreScreen() { //restore from fullscreen

		Window w = vc.getFullScreenWindow();
		if (w != null) {

			w.dispose();
		}

		vc.setFullScreenWindow(null); // fullscreen off

	}

}
