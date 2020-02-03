package logic;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
	

	
	
	

    @Override
    public void start(Stage primaryStage) throws Exception{ 
    	   	

    	
        Parent root = FXMLLoader.load(getClass().getResource("view/homePage.fxml"));
        primaryStage.setTitle("EcoClean");
        primaryStage.setScene(new Scene(root, 770, 550));
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
    
    public static void main(String[] args) throws SQLException {
    	
        launch(args);
    }
   
}