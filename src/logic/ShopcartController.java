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
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.model.Singleton;

import javax.swing.*;

public class ShopcartController extends Application {

    @FXML
    public Button wish, log, shop;

    @FXML
    public Button map_link, a_code_link, prod_link, user_p_link;
    
    @FXML
    public Button consume_gcoin;
    
    @FXML
    public Text wb;
    
    Singleton sg =Singleton.getInstance();
    
    public ShopcartController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public void initialize() {
		shop.setDisable(true);
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

        
        //Barra ----------------------
        if (eventClicked.contentEquals("Button[id=wish, styleClass=button]'Wishlist'")) {
        	//pagina carrello
        	if(sg.getUser() != null) {
            	a.openWin("view/wishlistPage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
        }
        //Barra ----------------------

        
        //Hyperlink ------------------
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	if(sg.getUser() != null) {
            	a.openWin("view/userprofilePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
        }
        if (eventClicked.contentEquals("Button[id=map_link, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login or Register'")) {
            //pagina login
        	a.openWin("view/login_registerPage.fxml");
        }  
        
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	if(sg.getUser() != null) {
            	a.openWin("view/activationcodePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
        }
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	a.openWin("view/productsPage.fxml");
        }
        //Hyper link ------------------

        //methods buy and remove from Wishlist ----------
        if (eventClicked.contentEquals("Button[id=consume_gcoin, styleClass=button]'Consume your greencoin'")) {
        	//metodo buy, aggiunge al carrello da wishlist
        }
      //methods buy and remove from Wishlist ----------
        
        oldWin.close();
    }
}