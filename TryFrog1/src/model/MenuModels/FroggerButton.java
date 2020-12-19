package model.MenuModels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FroggerButton extends Button {
	
	private final String FONT_PATH= "src/model/MenuResources/kenvector_future.ttf";
	private final String BUTTON_PRESSED_STYLE="-fx-background-color: transparent; -fx-background-image: url(/model/MenuResources/yellow_button_pressed.png)";
	private final String BUTTON_RELEASED_STYLE="-fx-background-color: transparent; -fx-background-image: url(/model/MenuResources/yellow_button.png)";

	
	public FroggerButton(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BUTTON_RELEASED_STYLE);
		intitializeButtonListners();
	}
	
	/**
	 * Method to set the Font of the Button
	 * @author sun
	 */
	public void setButtonFont() {
		
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23));
		}
		
	}
	
	
	/**
	 * Method to style the button when button is pressed
	 * @author sun
	 */
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}

	
	/**
	 * Method to style button when button is not pressed (normal condiotion)
	 * @author sun
	 */
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_RELEASED_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4);
		
	}
	
	/**
	 * Method to initialize the button 
	 * Either when mouse pressed, released, or when mouse entered the button
	 * Use for detection.
	 * @author sun
	 */
	private void intitializeButtonListners() {
		
		
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}	
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}	
			}
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow(4.0, Color.YELLOW));
			}
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
			}
		});
	}
	
	
	
	
	
	
	
	
}
	
	