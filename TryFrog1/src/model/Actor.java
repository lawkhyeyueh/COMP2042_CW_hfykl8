package model;

import javafx.scene.image.ImageView;
import view.World;

import java.util.ArrayList;

/**
 * This abstract class extends ImageView and allows for other classes to implement its act method. 
 * It manipulates ImageView by moving it around in the GUI and check for any collisions.
 * 
 * @author lawkhyeyueh
 * @version final 6.9
 * @since 2020-12-12
 *
 */

public abstract class Actor extends ImageView{
	
	protected int speed=1;
	private int speedMultiplier;
	
	/**
	 * Method used to move Actor/ImageView object on the x and y axis according to arguments.
	 * @param dx specifies amount of movement on the x axis
	 * @param dy specifies amount of movement on the y axis
	 * 
	 * @author lawkhyeyueh
	 * @version final 6.9
	 * @since 2020-12-12
	 *
	 */
	
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    /**
     * Method used to return the World object that the Actor resides in.
     * @return returns Parent of the Actor object as a World object 
     * 
     * @author lawkhyeyueh
     * @version final 6.9
     * @since 2020-12-12
     *
     */
    
    public World getWorld() {
        return (World) getParent();
    }
    
    /**
     * Gets the width relative to where it resides in the World/Parent
     * @return returns width of Actor relative to Parent 
     * 
     * @author lawkhyeyueh
     * @version final 6.9
     * @since 2020-12-12
     *
     */
    
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Gets height relative to where it resides in the World/Parent
     * @return returns height of Actor relative to Parent
     * 
     * @author lawkhyeyueh
     * @version final 6.9
     * @since 2020-12-12
     *
     */
    
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
    /**
     * This is a useful method. 
     * @param <A extends Actor> 
     * @param cls
     * @return array
     * 
     * @author lawkhyeyueh
     * @version final 6.9
     * @since 2020-12-12
     *
     */
    
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>(); //new array list of type A which is an actor
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public abstract void act(long now);
        
    /**
     * The methos is used to set the Speed of the Actor.
     * Basically to see how fast it will move in the parent.
     * @param speed 
     * 
     * @author lawkhyeyueh
     * @version final 6.9
     * @since 2020-12-12
     *
     */
    
    public void setSpeed() {
		/*
		 * speedMultiplier+=6; this.speed=speedMultiplier*this.speed ;
		 */
    	speed++;
    	this.speed= speed*this.speed;
    	//System.out.println(this.speed);
    }
    
    public int getSpeed() {
    	return speed;
    }

}
