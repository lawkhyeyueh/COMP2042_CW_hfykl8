package model.MenuModels;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class FroggerSubScene extends SubScene{
	
	private final static String FONT_PATH = "src/model/MenuResources/kenvector_future.ttf";
	private final static String BACKGROUND_IMAGE = "model/MenuResources/yellow_panel.png";

	private boolean isHidden;
	
	public FroggerSubScene() {
		super(new AnchorPane(), 500, 350);
		prefWidth(600);
		prefHeight(400);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 500, 350, false, true), 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		AnchorPane root2 = (AnchorPane) this.getRoot();
		
		root2.setBackground(new Background(image));
		
		isHidden = true;
		
		//initialize subscene to hidden from view
		setLayoutX(800);
		setLayoutY(210);
		
		// TODO Auto-generated constructor stub
	}
	
	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3)); // Define duration of our move
		transition.setNode(this); // Decides which element should be move
		
		if(isHidden) {
		transition.setToX(-520); // This method defines how a particular element will change its position on X-axis 
		isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}
		
		transition.play();
	}

	
	public AnchorPane getPane() {// this method will return pane for subscene
		return (AnchorPane) this.getRoot();
	}
	
	
	
}
