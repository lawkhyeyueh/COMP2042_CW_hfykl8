package model;

import javafx.scene.image.Image;

public class Crocodile extends Actor {
	
	
	private double speed=0;
	@Override
	
	/**
     * This method is to set movement speed 
     * @param now
     * Get X speed, and reset it.
     * 
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	/**
     * Method set Crododile Image
     * @param imageLink
     * @param size
     * @param xpos
     * @param ypos
     * @param s
     * @return points
	 *
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
	public Crocodile(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		this.speed = s;	
	}
	
	/**
     * Method boolean return Speed
     * @return Speed must be less than 0
	 *
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
	public boolean getLeft() {
		return speed < 0;
	}
		
	}


