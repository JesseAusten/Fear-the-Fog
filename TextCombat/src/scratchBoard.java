



import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class scratchBoard {

  public static void main(String[] args) {
    // 1) Pop a window and a canvas that we can draw on.
    // note: the size of the window tries to match the canvas on start.
    //       if the user resizes the window the canvas is scaled while respecting aspect ratio.
    int canvasWidth = 400;
    int canvasHeight = 225;
    boolean killAppOnClose = true; // true: closing the window will stop our application
    boolean smoothScaling = false; // if you resize the window up at runtime. Set to false if you want pixelation on zoom
    Object canvas = David.createCanvas(canvasWidth, canvasHeight, "My Window's Title", killAppOnClose, smoothScaling);

    // 2) Pre-load resources like images and fonts.
    BufferedImage image = David.loadImage("mao.png");
    Font font = David.loadFont("OxygenMono-Regular.ttf", 25);
    FontMetrics metrics = David.getFontMetrics(font);

    // 3) The Graphics object is used to draw on our canvas. Commonly named 'g'.
    Graphics g = David.getGraphics(canvas);
    g.setFont(font);

    // 4) Listen to keyboard and mouse events
    List<Object> events = new ArrayList<>(100);
    David.registerKeyboardEventQueue(events);
    David.registerCanvasMouseEventQueue(canvas, events);

    // 5) game loop (we render a new frame in each loop iteration)
    long t0 = System.currentTimeMillis();
    boolean running = true;
    while (running) {
      // 6) time flow (animation and game logic should always be dependant on time, not frame rate)
      long t1 = System.currentTimeMillis();
      double delta_time = (t1 - t0) / 1000.0; // time passed in seconds since the previous frame
      if (delta_time < (1.0 / 60)) continue; // cap frame rate to roughly 60 fps
      t0 = t1;

      // 7) read input events (e.g. mouse clicked, key released)
      synchronized (events) {
        for (Object _e : events) {
          if (_e instanceof MouseEvent) {
            MouseEvent e = (MouseEvent) _e;
            if (e.getID() == MouseEvent.MOUSE_CLICKED) {
              // simply print the mouse click detail
              System.out.println("Mouse click: " + e.getX() + ", " + e.getY());
            }
          }
          if (_e instanceof KeyEvent) {
            KeyEvent e = (KeyEvent) _e;
            if (e.getID() == KeyEvent.KEY_RELEASED) {
              // simply print the key release detail
              System.out.println("Key released: " + e.getKeyCode());
              switch (e.getKeyCode()) {
              case KeyEvent.VK_ESCAPE:
                running = false;
                break;
              }
            }
          }
        }
        events.clear();
      }

      // 8) tick (this is where the game logic goes)
      // REMEMBER: time based, not frame rate based. Use delta_time.

      // 9) draw scene to the canvas

      // draw an image
      // the screen coordinate you choose is for the top-left of the image
      // the x coordinate goes from left to right
      // the y coordinate goes from top to bottom
      // so (0, 0) is top-left of the screen
      g.drawImage(image, 0, 0, null);
      // and this is bottom-right of the screen (yup, graphics involve geometry math)
      g.drawImage(image, canvasWidth - image.getWidth(), canvasHeight - image.getHeight(), null);

      // draw text
      // the screen coordinate is the same, by it defines where the baseline of the text is, not its top-left.
      g.setColor(Color.BLACK);
      // bottom-left of screen
      g.drawString(String.format("FPS: %.1f", (1 / delta_time)), 0, canvasHeight);
      // top-left of screen
      g.drawString("Hello", 0, metrics.getAscent());
      // note: getAscent() is the height from the baseline.
      //       See https://docs.oracle.com/javase/tutorial/2d/text/fontconcepts.html for more information on FontMetrics.
      //       Ascent is not very precise and in the end, the font itself decides what it is (e.g. a bad font file can report erroneous metrics).
      // note: Another issue, is that there will not be any outline, so text drawn on top of images is always hard to read. Quite annoying.

      // draw procedural graphics
      g.setColor(Color.RED);
      g.drawLine(0, 0, canvasWidth, canvasHeight); // diagonal top-left to bottom-right
      g.drawLine(0, canvasHeight, canvasWidth, 0); // diagonal bottom-left to top-right

      // flush our drawing to the screen
      David.flushCanvas(canvas);
    }

    // if the loop ended, close the canvas
    David.closeCanvas(canvas);
  }

}