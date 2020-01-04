package logic;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.enums.TranType;
import logic.model.Transaction;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("logic/view/homePage.fxml"));
        primaryStage.setTitle("Homepage");
        primaryStage.setScene(new Scene(root, 770, 550));
        
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        
    }
}
