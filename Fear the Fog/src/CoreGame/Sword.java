package CoreGame;

import java.awt.Image;
import animation.*;


import javax.swing.ImageIcon;

public class Sword extends Weapon{
	
	Sprite sprite;
	Animation scenes;
	

	public Sword(int col, int row) {
		
		super(col, row);	
		
		scenes = new Animation();
		scenes.addScene(new ImageIcon("image.jpg").getImage(), 100);
		
	
		
		
		
		
		
	}
	
	
	

}
