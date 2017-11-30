import java.awt.Image;

public class Sprites {

	private Animation a;
	private float x;
	private float y;
	private float vx;
	private float vy;

	// constructor

	public Sprites(Animation a) {

		this.a = a;

	}

	// change position

	public void update(long timePassed) {

		x += vx * timePassed;
		y += vy * timePassed;
		a.update(timePassed);

	}

	// get x position

	public float getX() {

		return x;
	}

	public float getY() {

		return y;
	}

	// set sprite x position

	public void setX(float x) {

		this.x = x;
	}

	public void setY(float y) {

		this.y = y;
	}

	// get sprite width

	public int getWidth() {

		return a.getImage().getWidth(null);
	}

	// get sprite height
	public int getHeight() {

		return a.getImage().getHeight(null);
	}

	// get x velocity

	public float getVelocityX() {

		return vx;
	}

	// get y velocity

	public float getVelocityY() {

		return vy;
	}

	// set x velocity
	
	public void setVelocityX(float vx) {
		
		this.vx = vx;
	}
	// set y velocity
	
	public void setVelocityY(float vy) {
		
		this.vy = vy;
	}
	
	//get sprites image
	
	public Image getImage() {
		
		return a.getImage();
	}

}









