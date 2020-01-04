package logic.graphicController;

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

public class ProductsController extends Application {

    @FXML
    public Button user_p;

    @FXML
    public Button user_p_link;
    
    @FXML
    public Button wishlist;
    
    public ProductsController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        if (eventClicked.contentEquals("Button[id=user_p, styleClass=button hbox]''")) {
        	a.openWin("view/userprofilePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=..., styleClass=button]'carrello'")) {
        	a.openWin("view/shoppingcartPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=wishlist, styleClass=button]'Wishlist'")) {
        	a.openWin("view/wishlistPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button]'Link1'")) {
        	a.openWin("view/userprofilePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=..., styleClass=button]'Link2'")) {
        	a.openWin("...");
        }
        if (eventClicked.contentEquals("Button[id=..., styleClass=button]'Link3'")) {
        	a.openWin("...");
        }
        if (eventClicked.contentEquals("Button[id=..., styleClass=button]'Link4'")) {
        	a.openWin("...");
        }
       
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}



