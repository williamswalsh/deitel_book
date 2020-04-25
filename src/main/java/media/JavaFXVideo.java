package media;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class JavaFXVideo extends Application {
    public JavaFXVideo() {
        //Optional constructor
        System.out.println("Constructor");
    }

    @Override
    public void init() {
        //By default this does nothing, but it
        //can carry out code to set up your app.
        //It runs once before the start method,
        //and after the constructor.
        System.out.println("init method");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("start method");

        // Creating the Java button
        final Button button = new Button();
        button.setText("Hello World");
        button.setOnAction((ActionEvent event) -> {
            // Printing Hello World! to the console
            System.out.println("Hello World!");
        });

        // Initializing the StackPane class
        final StackPane root = new StackPane();
        // Adding all the nodes to the StackPane
        root.getChildren().add(button);

        // Creating a scene object
        final Scene scene = new Scene(root, 300, 250);
        // Adding the title to the window (primaryStage)
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        // Show the window(primaryStage)
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.out.println("stop method");
        //By default this does nothing
        //It runs if the user clicks the go-away button
        //closing the window or if Platform.exit() is called.
        //Use Platform.exit() instead of System.exit(0).
        //This is where you should offer to save any unsaved
        //stuff that the user may have generated.
    }

    /**
     * Main function that opens the "Hello World!" window
     *
     * @param arguments the command line arguments
     */
    public static void main(final String[] arguments) {
        launch(arguments);
    }
}