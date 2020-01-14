package logic;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.enums.DeliveryStatus;
import logic.model.AbstractUser;
import logic.persistence.ActivationCodeDAO;
import logic.persistence.AddressDAO;
import logic.persistence.CollectionPointDAO;
import logic.persistence.MessageDAO;
import logic.persistence.ProductDAO;
import logic.persistence.ShipmentDAO;
import logic.persistence.UserDAO;
import logic.persistence.WishListDAO;





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
    
//ProductDAO.insert(12345, "Borraccia in legno", 200, 0, "utility", "/Users/davide/Desktop/Progetto3/src/logic/view/images" , "Yoko Design 1550 Bottiglia Termica, Acciaio Inox, Legno, 26 x 7 x 7 cm", 1);
//CollectionPointDAO.insert( "Quadraro" , 41.8552719, 12.5503039, 1, 9, 21, 1);
//ShipmentDAO.insert("12/01/2020", "a1b2c3d4e5f6", 12345, DeliveryStatus.SENT, 1);
//WishListDAO.insert(1, 12345);
//ActivationCodeDAO.insert(123456789, 100);
//MessageDAO.insert(currentTime, "title", "bodymessage", "type", 10); 
//AddressDAO.insert("Via del Quadraro 72", "Roma", "00179", "+393334455666", "Italy" , "Italy" , "Quadraro");
//UserDAO.deleteUserById(1);
/**AbstractUser user = UserDAO.login("stefano@gmail.com", "stefano123");
System.out.println(user.getHistory());
System.out.println(user.getType());**/ 

}
    
}

// Serve per scrivere la data corrente
/**       java.util.Date dt = new java.util.Date();

java.text.SimpleDateFormat sdf = 
     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

String currentTime = sdf.format(dt);


 **/
