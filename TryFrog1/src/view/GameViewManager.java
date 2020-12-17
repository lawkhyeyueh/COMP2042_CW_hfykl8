package view;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.MenuModels.FROG;

/**
 * This class is called GameViewManager, it is responsible for view render of the program.
 * It creates a World Object, and then work together in a timer. 
 * @author sun
 *
 */
public class GameViewManager {

	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	private Stage menuStage;
	private ImageView frog;
	
	public GameViewManager() {
		initializeStage();
		createKeyListeners();
	}
	
	private void createKeyListeners() {
		
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.LEFT) {
					
				} else if (event.getCode() == KeyCode.RIGHT) {
					
				}
				
			}
			
		});
		
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.LEFT) {
					
				} else if (event.getCode() == KeyCode.RIGHT) {
					
				}
				
			}
			
		});
	}
	
	/**
	 * The initializeStage() method is able used to set up the Scene and the stage for the constructor.
	 */
	private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);

	}
	
	/**
	 * This method is set to public and will be accessed by a class that makes a GameViewManager object. 
	 * This method is used in order to hide passed in screen and show the present one.
	 * @param menuStage is used to hide the Stage specified here
	 * @param choosenLevel is an instance of enum and is used as an argument to the method createGameAccording to level
	 */
	public void createNewGame(Stage menuStage, FROG choosenFrog) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		createFrog(choosenFrog);
		gameStage.hide();
	}
	
	/**
	 * Calls startGame method according to frog chosen by the user.
	 * @param choosenFrog specifies which frog has been chosen by the user
	 */
	private void createFrog(FROG choosenFrog) {
		frog = new ImageView(choosenFrog.getUrl());
		frog.setLayoutX(GAME_WIDTH/2);
		frog.setLayoutY(GAME_HEIGHT - 90);
		gamePane.getChildren().add(frog);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
