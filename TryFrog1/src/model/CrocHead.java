package model;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;

public class CrocHead extends Actor{
	//Random random = new Random();
	
	ArrayList<Integer> xPosition =new ArrayList<>();
	
	
	private double speed;
	
	/**
     * This method is to set the visibility
     * Set visibility to false if X, Y under certain conditions.
	 *
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
	@Override
	public void act(long now) {
		this.setVisible(false);
		move(0,speed);
		this.setVisible(true);
		if(getY()>65*2) {
			setY(65);
			setX(getRandomElement());
			this.setVisible(false);
			
		 }
		
	}

	/**
     * Method to set position of Crocodile Head
     * @param imageLink
     * @param size
     * @param xpos
     * @param ypos
     * @param s
     * Set Image Size, Speed, and add elements to list.
	 *
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
	public CrocHead(String imageLink ,int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		this.speed = s;	
		addElementsToList();
	}

	/**
     * Method to set get random element
     * @return xPosition
	 *
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
	private int getRandomElement() 
    { 
        Random rand = new Random(); 
        return xPosition.get(rand.nextInt(xPosition.size())); 
    } 
	
	/**
     * Method to add Elements to List
     * @param Xpos
     * Setting X position
	 *
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
	private void addElementsToList() {
		 int xpos=12;
		for(int i=0; i<5;i++) {
			xPosition.add(xpos);
			xpos+=128;
		}
	}
	

}
