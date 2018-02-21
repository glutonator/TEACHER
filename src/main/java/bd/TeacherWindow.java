package bd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class TeacherWindow extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
//        //creating a Group object
//        Group group = new Group();
//
//        //Creating a Scene by passing the group object, height and width
//        Scene scene = new Scene(group ,600, 300);
//
//        //setting color to the scene
//        scene.setFill(Color.BROWN);
//
//        //Setting the title to Stage.
//        primaryStage.setTitle("Sample Application");
//
//        //Adding the scene to Stage
//        primaryStage.setScene(scene);
//
//        //Displaying the contents of the stage
//        primaryStage.show();

        Parent root = FXMLLoader.load(getClass().getResource("/app/hello.fxml"));
        primaryStage.setTitle("hello everyone");
        primaryStage.setScene(new Scene(root, 800,500));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
