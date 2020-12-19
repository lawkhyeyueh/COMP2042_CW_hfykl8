package model.MenuModels;

import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;;

public class FroggerSubScene extends SubScene{
	
	private final static String FONT_PATH="src/model/MenuResources/kenvector_futrue.ttf"; 
	private final static String BACKGROUND_IMAGE="model/MenuResources/yellow_panel.png";
	
	private boolean isHidden;

	public FroggerSubScene() {
		super(new AnchorPane(), 500, 350);
		prefWidth(600);
		prefHeight(400);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,500,350,false,true), 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		AnchorPane root2 =(AnchorPane) this.getRoot(); //getting root for this classs
		
		root2.setBackground(new Background(image));
		
		isHidden=true;
		
		//to initially have the subscene hidden from view
		setLayoutX(800);
		setLayoutY(210);
	}
	
	/**
	 * Method to move sub scene around
	 * @author sun
	 */
	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this); //method decides which element is to be moved 
		
		if(isHidden) {
		transition.setToX(-520);
		isHidden=false;
		}else {
			transition.setToX(0);
			isHidden=true;
		}
		
		transition.play();
	}
	
	
	/**
	 * Method to return the pane for the subscene
	 * @author sun
	 */
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
	

	
}
