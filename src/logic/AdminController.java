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
import logic.model.Singleton;

import javax.swing.*;

public class AdminController extends Application {

    @FXML
    public Button conf_prod;
    
    @FXML
    public Button conf_usr;
    //@FXML
    //public TextField usr, psw;
    
    
    public AdminController() {
    	
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        String eventClicked = event.getSource().toString();
        if (eventClicked.contentEquals("Button[id=conf_prod, styleClass=button]'Confirm'")) {
        	//metodo opzioni prodotti
        }
        
        if (eventClicked.contentEquals("Button[id=conf_usr, styleClass=button]'Confirm'")) {
        	//metodo opzioni utente
        }
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}