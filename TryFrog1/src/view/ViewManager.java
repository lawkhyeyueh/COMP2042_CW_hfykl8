package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MenuModels.FroggerButton;
import model.MenuModels.FroggerSubScene;
import model.MenuModels.InfoLabel;
import model.MenuModels.LEVEL;
import model.MenuModels.LevelPicker;
import javafx.scene.effect.DropShadow;

public class ViewManager {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private World mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	public final static String FONT_PATH= "src/model/MenuResources/kenvector_future.ttf";
	private final static int MENU_BUTTON_START_X=40;
	private final static int MENU_BUTTON_START_Y=220;
	
	private FroggerSubScene subSceneScore;
	private FroggerSubScene subSceneHelp;
	private FroggerSubScene subSceneLevelChooser; 
	
	private FroggerSubScene sceneToHide; //field is used to store the scene that needs to be hidden
	
	List<FroggerButton> menuButtons; //a list to contain all the menu buttons at the start
	
	List<LevelPicker> levelList; //list that will store the levels inside it 
	private LEVEL choosenLevel; 
	
	public ViewManager() {
		menuButtons= new ArrayList<>();
		mainPane= new World();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage=new Stage();
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
		createButton();
		createBackground();
		createSubScene();
		mainPane.getStylesheets().add("view/frogStylesheet/mainmenu_stylesheet.css");
		Image image = new Image("view/ViewResources/froggerUp.png");
		mainStage.getIcons().add(image);
		mainStage.setTitle("Frogger2020");
	}
	
	//if there is a subscene that needs to be hidden move it 
	/**
	 * Methods to show Sub scene
	 * @param subScene
	 * @author sun
	 */
	private void showSubScene(FroggerSubScene subScene) {
		if(sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		//we show the new subscene and store it in the scenetohide variable
		subScene.moveSubScene();
		sceneToHide=subScene;
	}
	
	/**
	 * Methods to create Sub scene
	 * create subscene that form up by Level Chooser, Help and Score SubScene Method.
	 * @author sun
	 */
	private void createSubScene() {
		
		
		createLevelChooserSubScene();
		createHelpSubScene();
		createScoreSubScene();
		
	}
	
	/**
	 * Methods to create Score sub scene
	 * @author sun
	 */
	private void createScoreSubScene() {
		subSceneScore = new FroggerSubScene();
		mainPane.add(subSceneScore);
		
		InfoLabel heading =new InfoLabel("SCORE TABLE", true);
		heading.setLayoutX(160);
		heading.setLayoutY(27);
		subSceneScore.getPane().getChildren().add(heading);
	
	}
	/**
	 * Methods to create help sub scene
	 * @author sun
	 */
	private void createHelpSubScene() {
		subSceneHelp = new FroggerSubScene();
		mainPane.add(subSceneHelp);
		
		InfoLabel heading =new InfoLabel("HELP", true);
		heading.setLayoutX(225);
		heading.setLayoutY(27);
		subSceneHelp.getPane().getChildren().add(heading);
		
	
		/*
		 * ScrollPane scrollPane = new ScrollPane();
		 * subSceneHelp.getPane().getChildren().add(scrollPane);
		 */
	}

	//method used to create levelchoosersubscene 
	/**
	 * Methods to create Level chooser sub scene
	 * @author sun
	 */
	private void createLevelChooserSubScene() {
		subSceneLevelChooser= new FroggerSubScene();
		mainPane.add(subSceneLevelChooser);
		
		InfoLabel chooseLevelLabel = new InfoLabel("CHOOSE LEVEL");
		chooseLevelLabel.setLayoutX(70);
		chooseLevelLabel.setLayoutY(25);
		
		
		
		subSceneLevelChooser.getPane().getChildren().add(chooseLevelLabel);
		
		subSceneLevelChooser.getPane().getChildren().add(createLevelsToChoose()); //adds the hbox to the subscene 
		
		subSceneLevelChooser.getPane().getChildren().add(createStartButton()); // adds start button to the subscene 
		
		
	}
	
	//method below makes the images for the levels
	/**
	 * Methods for HBox to check if Level is Choosen
	 * @return box
	 * @author sun
	 */
	private HBox createLevelsToChoose() {
		HBox box = new HBox();
		box.setSpacing(20);
		levelList = new ArrayList<LevelPicker>();
		//below is how we get instances from an enum using the values method
		for(LEVEL level: LEVEL.values()) {
			LevelPicker levelToPick= new LevelPicker(level);			
			levelList.add(levelToPick);
			box.getChildren().add(levelToPick);
			levelToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for(LevelPicker level: levelList) {
						level.setIsCircleChoosen(false); //if we click on one of the levels the rest would be set to false
					}
					levelToPick.setIsCircleChoosen(true);//the chosen level will be set to chosen 
					choosenLevel=levelToPick.getLevel();
				}
			});
		}
		box.setLayoutX(310 -(118*2));
		box.setLayoutY(100);
		return box;
	}
	
	/**
	 * Methods to create start button
	 * @return start button.
	 * @author sun
	 */
	private FroggerButton createStartButton() {
		FroggerButton startButton =new FroggerButton("START");
		startButton.setLayoutX(270);
		startButton.setLayoutY(285);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				if(choosenLevel != null) {
					
					GameViewManager gameManager= new GameViewManager();
					gameManager.createNewGame(mainStage, choosenLevel);
				}
			}
		});
		
		return startButton;
	}
	
	/**
	 * Methods to get Main Stage
	 * @return Main Stage
	 * @author sun
	 */
	public Stage getMainStage() {
		return mainStage;
	}
	
	/**
	 * Methods to add Menu Button
	 * @param FroogerButton button
	 * @author sun
	 */
	private void addMenuButton(FroggerButton button) {
		button.setLayoutX(MENU_BUTTON_START_X);
		button.setLayoutY(MENU_BUTTON_START_Y+ menuButtons.size() *100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	/**
	 * Methods to create different features of Button
	 * Createe play, socre, help, exit button and Logo with Icon.
	 * @author sun
	 */
	private void createButton() {
		createPlayButton();
		createScoreButton();
		createHelpButton();
		createExitButton();
		createLogo();
		createIcon();
	}
	
	/**
	 * Methods to create play button
	 * @author sun
	 */
	private void createPlayButton() {
		FroggerButton playButton = new FroggerButton("PLAY");
		addMenuButton(playButton);
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(subSceneLevelChooser);
				
			}
		});
		
	}
	
	/**
	 * Methods to create score button
	 * @author sun
	 */
	private void createScoreButton() {
		FroggerButton scoreButton = new FroggerButton("SCORE");
		addMenuButton(scoreButton);
		
		scoreButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(subSceneScore);
				
			}
		});
	}
	
	/**
	 * Methods to create help button
	 * @author sun
	 */
	private void createHelpButton() {
		FroggerButton helpButton = new FroggerButton("HELP");
		addMenuButton(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				showSubScene(subSceneHelp);
				
			}
		});
	}
	
	/**
	 * Methods to create exit button
	 * @author sun
	 */
	private void createExitButton() {
		FroggerButton exitButton = new FroggerButton("EXIT");
		addMenuButton(exitButton);
		
		//implementing exit logic
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mainStage.close();
				
			}
		});
	}

	/**
	 * Methods to create background for menu panel
	 * @author sun
	 */
	private void createBackground() {
		Image backgroundImage= new Image("view/ViewResources/8e8c72a1459ad7332b14306bea1af865.gif",1100,900,true,false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
		mainPane.setBackground(new Background(background));
		
	}
	
	/**
	 * Methods to create logo for menu
	 * @author sun
	 */
	private void createLogo() {
		ImageView logo= new ImageView("view/ViewResources/frogger-logo-2.png");
		logo.setFitHeight(350);
		logo.setFitWidth(450);
		logo.setPreserveRatio(true);
		logo.setLayoutX(290);
		logo.setLayoutY(50);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow(4.0, Color.YELLOW));
										
			}
		});
		
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
				
			}
		});
		
		mainPane.getChildren().add(logo);
	}
	
	/**
	 * Methods to create icon for menu
	 * @author sun
	 */
	private void createIcon() {
		ImageView icon = new ImageView("view/ViewResources/frog.png");
		
		icon.setFitHeight(200);
		icon.setFitWidth(200);
		icon.setPreserveRatio(true);
		icon.setLayoutX(40);
		icon.setLayoutY(20);
		
		icon.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				icon.setEffect(new DropShadow(4.0, Color.YELLOW));
										
			}
		});
		
		icon.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				icon.setEffect(null);
				
			}
		});
		mainPane.getChildren().add(icon);
	}
	
	
	
	
	
	
	
	
	
}
