package model;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	private int counter=0;
	
	private static final String END_URL="file:src/model/ActorResources/End.png";
	private static final String SET_END_URL="file:src/model/ActorResources/FrogEnd.png";
	
	/**
     * Method for Set position when END
     * @param x
     * @param y
     * Set image 
     * @author sun
     */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(END_URL, 60, 60, true, true));
	}
	
	/**
     * Method to set END
     * @author sun
     */
	public void setEnd() {
		setImage(new Image(SET_END_URL, 70, 70, true, true));
		activated = true;
		counter++;
	}
	
	/**
     * Method to set END
     * @author sun
     */
	public void unsetEnd() {
		setImage(new Image(END_URL, 60, 60, true, true));
		activated=false;
	}
	
	/**
     * Method boolean is Activated
     * return activated
     * @author sun
     */
	public boolean isActivated() {
		return activated;
	}

	@Override
	public void act(long now) {
		/*
		 * if(counter==5) { this.activated=false; }
		 */
	}
	

}
