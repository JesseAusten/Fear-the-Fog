package animation;

import java.awt.Image;

public class Sprite {

	private Animation a;
	private int col;
	private int row;
	
	

	// constructor

	public Sprite(Animation a) {

		this.a = a;

	}

	// change position

	public void update(long timePassed) {


	}


	// get sprite width

	public int getWidth() {

		return a.getImage().getWidth(null);
	}

	// get sprite height
	public int getHeight() {

		return a.getImage().getHeight(null);
	}


	// get sprites image

	public Image getImage() {

		return a.getImage();
	}

}
