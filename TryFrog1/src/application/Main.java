package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * This is the main class that runs everything.
 * Without this class, everything else is rendered useless as it cannot compile.
 * 
 * @author lawkhyeyueh
 * @version final 6.9
 * @since 2020-12-12
 *
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ViewManager manager= new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
