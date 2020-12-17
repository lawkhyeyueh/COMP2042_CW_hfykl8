package model.MenuModels;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class FrogPicker extends VBox {// this class is to create Vbox that contains image inside. 

	private ImageView circleImage;
	private ImageView frogImage;
	
	//strings to store the path to images that will be show on the subscene 
	private String circleNotChoosen = "view/resources/levelchooser/grey_circle.png";
	private String circleChoosen = "view/resources/levelchooser/circle_choosen.png";
	
	private FROG frog; //instance of the enum 
	
	private boolean isCircleChoosen; //boolean that tells if a circle is choosen or not
	
	public FrogPicker(FROG frog) {
		circleImage = new ImageView(circleNotChoosen);
		frogImage = new ImageView(frog.getUrl());
		this.frog = frog;
		isCircleChoosen = false; //button will not be choosen at the start
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.getChildren().add(circleImage); //add images of circle and frog
		this.getChildren().add(frogImage);
	}
	
	public FROG getFrog() {
		return frog;
	}
	
	public boolean getIsCircleChoosen() {
		return isCircleChoosen;
	}
	
	public void setIsCircleChoosen(boolean isCircleChoosen) {
		this.isCircleChoosen = isCircleChoosen;
		String ImageToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
		circleImage.setImage(new Image(ImageToSet));
	}
}




