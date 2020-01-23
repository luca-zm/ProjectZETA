package logic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.model.Singleton;

import javax.swing.*;

public class MapController extends Application {

    @FXML
    public Button wishlist, shop, log;

    @FXML
    public Button map_link, a_code_link, prod_link, user_p_link;
    
    @FXML
    public Text wb;
    
    Singleton sg = Singleton.getInstance(); 

    
    public MapController() { }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }
    
	@FXML
	public void initialize() {
		map_link.setDisable(true);
		//-----
		log.setVisible(false);
		
		//-----
		
		if(sg.getUser() == null) { //utente non loggato
			wb.setVisible(false);
			log.setVisible(true);
		}
	}

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        
       
        
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=wishlist, styleClass=button]'Wishlist'")) {
        	//pagina wishlist
        	if(sg.getUser() != null) {
        		a.openWin("view/wishlistPage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
        }
        
        
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	if(sg.getUser() != null) {
        		a.openWin("view/userprofilePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}	
        }
        
                
        
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	if(sg.getUser() != null) {
            	a.openWin("view/activationcodePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}        }
               
        
        
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login or Register'")) {
            //pagina login
        	a.openWin("view/login_registerPage.fxml");
        }    
        
        
        
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	//pagina prodotti
        	a.openWin("view/productsPage.fxml");
        }
        oldWin.close();
    }
}
