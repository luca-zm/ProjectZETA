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

public class WarningController extends Application {

    @FXML
    public Button log, cancel;
    
    Singleton sg = Singleton.getInstance(); 
    
    Stage stage = null;

    
    public WarningController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        
        String eventClicked = event.getSource().toString();
        System.out.println(eventClicked);
        if (eventClicked.contentEquals("Button[id=log, styleClass=button btn-success]'Go to Login!'")) {
        	a.openWin("view/login_registerPage.fxml");
        	Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldWin.close();
            stage.close();
        }
        
        if (eventClicked.contentEquals("Button[id=cancel, styleClass=button btn-danger]'Continue as guest'")) {
        	Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldWin.close();
        }     
        
    }

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
    
    
}
