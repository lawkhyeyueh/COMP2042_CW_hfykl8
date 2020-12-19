package model;

import javafx.scene.image.Image;

public class Log extends Actor{
	
	private double speed=0;

	/**
     * Method to  act for Log
     * @param now
     * Get X speed, and reset it
     * 
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}

	/**
     * Method set Log Image
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
	
	public Log(String imageLink ,int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
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
