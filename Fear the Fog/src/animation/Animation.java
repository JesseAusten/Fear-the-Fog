package animation;

import java.awt.Image;
import java.util.ArrayList;

public class Animation {

	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;

	/**
	 * Constructor initiazes ArrayList Scenes and int totalTime
	 * Then calls the run method to start the animation
	 */
	public Animation() {

		scenes = new ArrayList();
		totalTime = 0;
		start();

	}

	/**
	 * Adds a scene to the animation
	 * @param i -an image to add to the scene
	 * @param t -frame time for the added scene
	 */
	public synchronized void addScene(Image i, long t) {

		totalTime += t;
		scenes.add(new OneScene(i, totalTime));

	}

	/**
	 * Starts the animation
	 */

	public synchronized void start() {

		movieTime = 0;
		sceneIndex = 0;

	}

	/**
	 * Updates the animation based on the time passed
	 * @param timePassed -the amount of time passed
	 */

	public synchronized void update(long timePassed) {

		if (scenes.size() > 1) {

			movieTime += timePassed;
			if (movieTime >= totalTime) {
				movieTime = 0;
				sceneIndex = 0;
			}
			while (movieTime > getScene(sceneIndex).endTime) {

				sceneIndex++;
			}
		}
	}

	/**
	 * Returns the image at the current scene index
	 * @return an image from the current animation
	 */

	public synchronized Image getImage() {

		if (scenes.size() == 0) {

			return null;
		} else {

			return getScene(sceneIndex).pic;
		}

	}

	/**
	 * Returns the  scene based on the index (image and frame-time)
	 * @param x the scene index
	 * @return the scene at index x
	 */

	private OneScene getScene(int x) {
		return (OneScene) scenes.get(x);
	}

	// **********************private inner class!**************************

	private class OneScene {

		Image pic;
		long endTime;

		public OneScene(Image pic, long endTime) {

			this.pic = pic;
			this.endTime = endTime;

		}

	}
}
