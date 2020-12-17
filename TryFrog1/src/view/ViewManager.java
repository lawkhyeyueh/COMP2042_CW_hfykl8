package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Main;
import model.MenuModels.FROG;
import model.MenuModels.FrogPicker;
import model.MenuModels.FroggerButton;
import model.MenuModels.FroggerSubScene;
import model.MenuModels.InfoLabel;

public class ViewManager {

	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private final static int MENU_BUTTONS_START_X = 40; // Set position for button
	private final static int MENU_BUTTONS_START_Y = 220; // Set position for button
	
	private FroggerSubScene creditsSubScene; // Create Credit SubScene
	private FroggerSubScene helpSubScene;
	private FroggerSubScene scoreSubScene;
	private FroggerSubScene frogChooserScene;
	
	private FroggerSubScene sceneToHide;
	
	List<FroggerButton> menuButtons;
	
	List<FrogPicker> frogsList;
	
	private FROG choosenFrog;
	
	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene); 
		mainStage.setResizable(false);
		createSubScenes();
		createButton();
		createBackground();
		createLogo();
	}
	
	private void showSubScene(FroggerSubScene subScene) {
		if(sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		sceneToHide = subScene;
	}
	
	private void createSubScenes() {
		creditsSubScene = new FroggerSubScene();
		mainPane.getChildren().add(creditsSubScene);
		
		helpSubScene = new FroggerSubScene();
		mainPane.getChildren().add(helpSubScene);
		
		scoreSubScene = new FroggerSubScene();
		mainPane.getChildren().add(scoreSubScene);
		
		createFrogChooserSubScene();
	}
	
	private void createFrogChooserSubScene() {
		frogChooserScene = new FroggerSubScene();
		mainPane.getChildren().add(frogChooserScene);
		
		InfoLabel chooseFrogLabel = new InfoLabel("CHOOSE YOUR FROG");
		chooseFrogLabel.setLayoutX(70);
		chooseFrogLabel.setLayoutY(25);
		frogChooserScene.getPane().getChildren().add(chooseFrogLabel);
		frogChooserScene.getPane().getChildren().add(createFrogToChoose());
		frogChooserScene.getPane().getChildren().add(createButtonToStart());
		
	}
	
	private HBox createFrogToChoose() {
		HBox box = new HBox();
		box.setSpacing(4);
		frogsList = new ArrayList<>();
		for (FROG frog : FROG.values()){
			FrogPicker frogToPick = new FrogPicker(frog);
			frogsList.add(frogToPick);
			box.getChildren().add(frogToPick);
			frogToPick.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent arg0) {
					for(FrogPicker frog : frogsList) {
						frog.setIsCircleChoosen(false); //If we clicked one of the shi	p, the rest will be set as FALSE
					}
					frogToPick.setIsCircleChoosen(true); 
					choosenFrog = frogToPick.getFrog();
				}
				
			});
		}
		box.setLayoutX(300 - (118*2));
		box.setLayoutY(100);
		return box;
	}
	
	private FroggerButton createButtonToStart() {
		FroggerButton startButton = new FroggerButton("START");
		startButton.setLayoutX(270);
		startButton.setLayoutY(265);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Main start = new Main();
				start.startgame();
				if( choosenFrog != null) {
					GameViewManager gameManager = new GameViewManager();
					gameManager.createNewGame(mainStage, choosenFrog);
				}
				
			}
			
		});
		
		return startButton; 
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	private void addMenuButton(FroggerButton button) {
		button.setLayoutX(MENU_BUTTONS_START_X);	
		button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size()*100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
		}	
	
	public void createButton() {
		createStartButton();
		createScoresButton();
		createHelpButton();
		createCreaditsButton();
		createExitButton();
	}
	
	private void createStartButton() {
		FroggerButton startButton = new FroggerButton ("PLAY");
		addMenuButton(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(frogChooserScene);
			}
			
		});
	}
	
	private void createScoresButton() {
		FroggerButton scoresButton = new FroggerButton ("SCORES");
		addMenuButton(scoresButton);
		
		scoresButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoreSubScene);
			}
			
		});
	}
	
	private void createHelpButton() {
		FroggerButton helpButton = new FroggerButton ("HELP");
		addMenuButton(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				showSubScene(helpSubScene);
			}
			
		});
	}
	
	private void createCreaditsButton() {
		FroggerButton creditsButton = new FroggerButton ("CREDITS");
		addMenuButton(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				showSubScene(creditsSubScene);
			}
			
		});
	}
	
	private void createExitButton() {
		FroggerButton exitButton = new FroggerButton("EXIT");
		addMenuButton(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mainStage.close();
				
			}
			
		});
	}
	
	
	private void createBackground() { 
		Image backgroundImage = new Image("view/resources/moving_background.gif", 400, 300, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background)); // Set Background Image to Main Pane.
	}
	
	private void createLogo() {
		ImageView logo = new ImageView("view/resources/FROGGER LOGO.png");
		logo.setFitHeight(350);
		logo.setFitWidth(450);
		logo.setPreserveRatio(true);
		logo.setLayoutX(290);
		logo.setLayoutY(50);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());
			}
			
		});
		
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				logo.setEffect(null);
				
			}
		});
		
		mainPane.getChildren().add(logo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
