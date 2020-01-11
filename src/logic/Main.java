package logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.model.AbstractUser;
import logic.model.MessageDAO;
import logic.model.UserDAO;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/homePage.fxml"));
        primaryStage.setTitle("EcoClean");
        primaryStage.setScene(new Scene(root, 770, 550));
        primaryStage.show();

    }
    
    public static void main(String[] args) {
    	
        launch(args);
        
    }
}


/**AbstractUser user = UserDAO.login("stefano@gmail.com", "stefano123");
System.out.println(user.getHistory());
System.out.println(user.getType()); **/

// Serve per scrivere la data corrente
/**       java.util.Date dt = new java.util.Date();

java.text.SimpleDateFormat sdf = 
     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

String currentTime = sdf.format(dt);



MessageDAO.insert(currentTime, "title", "bodymessage", "type", 10); **/
