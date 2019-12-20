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

public class ProductsController extends Application {

    @FXML
    public Button login;


    public ProductsController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    /**
    @FXML
    public void openHome() throws IOException{
    	Stage gadhetsWin = new Stage();
    	homeWin.setTitle("Homepage");
     	//aprir l'homepage in base ai permessi
    	Parent root = FXMLLoader.load(getClass().getResource("gadgets.fxml"));
    	Scene scene = new Scene(root);
    	homeWin.setScene(scene);
    	homeWin.show();
    	sg.saveScene(scene);
   }*/

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        a.openWin();
        //chiudo la schermata del login
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}



