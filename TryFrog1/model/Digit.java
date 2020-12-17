package model;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/model/ActorResources/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
