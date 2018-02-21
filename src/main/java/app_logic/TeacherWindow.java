package app_logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TeacherWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/app/subjects_form.fxml"));
        primaryStage.setTitle("hello everyone");
        primaryStage.setScene(new Scene(root, 800,500));
        primaryStage.show();
    }
}
