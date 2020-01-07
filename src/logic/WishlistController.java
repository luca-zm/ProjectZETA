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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;

public class WishlistController extends Application {

    @FXML
    public Button shop;

    @FXML
    public Button map_link, a_code_link, prod_link, user_p_link;
    
    @FXML
    public Button buy, del;
    
    
    public WishlistController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        System.out.println(eventClicked);
        
        //Barra ----------------------
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button hbox]''")) {
        	//pagina profilo utente da icona
        	a.openWin("view/userprofilePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        //Barra ----------------------

        
        //Hyperlink ------------------
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	a.openWin("view/userprofilePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=map_link, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	a.openWin("view/activationcodePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	a.openWin("view/productsPage.fxml");
        }
        //Hyper link ------------------

        //methods buy and remove from Wishlist ----------
        if (eventClicked.contentEquals("Button[id=buy, styleClass=button]'Buy'")) {
        	//metodo buy, aggiunge al carrello da wishlist
        }
        if (eventClicked.contentEquals("Button[id=del, styleClass=button]'Remove from wishlist'")) {
        	//metodo remove from wishlist, rimuove elemento da wishlist
        }
      //methods buy and remove from Wishlist ----------
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
