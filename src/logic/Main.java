package logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	//Luca
        Parent root = FXMLLoader.load(getClass().getResource("view/login_registerPage.fxml"));
        primaryStage.setTitle("Gadgets");
        primaryStage.setScene(new Scene(root, 770, 550));
        
    	//Davide
        //Parent root = FXMLLoader.load(getClass().getResource("view/userprofile.fxml"));
        //primaryStage.setTitle("User Profile");
        //primaryStage.setScene(new Scene(root, 770, 550));
        
        //Stefano
        //Parent root = FXMLLoader.load(getClass().getResource("view/shoppingcart.fxml"));
        //primaryStage.setTitle("Shopping Cart");
        //primaryStage.setScene(new Scene(root, 770, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
