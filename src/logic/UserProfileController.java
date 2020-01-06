package logic;

import java.awt.Color;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class UserProfileController extends Application {

	
	@FXML
    private ImageView avatarImage;
	
	@FXML
    public Button wish, shop;

    @FXML
    public Button map, a_code_link, prod_link, user_p_link;

	public UserProfileController() {
		
	}

	//setto l'avatar a forma di cerchio
    @FXML
    public void initialize() {
        // set a clip to apply rounded border to the original image.
    	//NON TOCCARE LE DIMENSIONI
    	Circle clip = new Circle(95, 82, 80);
        avatarImage.setClip(clip);
    }
	
	@FXML
    private void next(ActionEvent event) throws IOException {
		winNext a = new winNext();
        String eventClicked = event.getSource().toString();
        System.out.println(eventClicked);
        
        
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shoppingcartPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=wish, styleClass=button]'Wishlist'")) {
        	//pagina wishlist
        	a.openWin("view/wishlistPage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activate your code!'")) {
        	//pagina activation code
        	a.openWin("view/activationcodePage.fxml");
        }
        
        //hyperlink----------------
        if (eventClicked.contentEquals("Button[id=map_link, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	a.openWin("activationcodePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	//pagina prodotti
        	a.openWin("productsPage.fxml");
        }
        //hyperlink----------------
        
       
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	}

}
