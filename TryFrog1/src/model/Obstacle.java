package model;

import javafx.scene.image.Image;

public class Obstacle extends Actor{
	//int speedMultiplier;
	private int speed=0;

	/**
     * Method to  set movement speed  for obstacle
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
		this.speed =getSpeed()*this.speed;
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

	/**
     * Method set Obstacle Image
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
	
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {	
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		this.speed=s;
		//increaseSpeed=this.speed;
		
	}

}
