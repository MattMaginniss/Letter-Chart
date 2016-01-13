package edu.westga.letterchart;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Handles the launching of the syllabytes application
 *
 * @author Nathan Beam
 * @version 0.4b
 */
public class Main extends Application {
	private static final String GUI_FXML = "views/Gui.fxml";
	private static final String WINDOW_TITLE = "God has forsaken us";

	/**
	 * Constructs a new Application object for FaceSelect program
	 *
	 * @precondition none
	 * @postcondition the object is ready to execute
	 */
	public Main() {
		super();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = this.loadGui();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle(WINDOW_TITLE);
			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	/**
	 * Creates the GUI pane
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the loaded GUI pane
	 * @throws IOException
	 *             if GUI cannot be found
	 */
	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(GUI_FXML));
		return (Pane) loader.load();
	}

	/**
	 * Launches the application.
	 *
	 * @precondition none
	 * @postcondition the program is launched
	 *
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}