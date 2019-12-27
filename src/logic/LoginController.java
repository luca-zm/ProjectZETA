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

public class LoginController extends Application {

    @FXML
    public Button log;
    @FXML
    public Button conf;
    @FXML
    public Button back;

    Singleton sg = Singleton.getInstance();


    public LoginController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        if (eventClicked.contentEquals("Button[id=back, styleClass=button]'Continue without signing in'")) {
        	a.openWin("view/productsPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login!'")) {
        	a.openWin("view/productsPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=conf, styleClass=button]'Confirm'")) {
        	a.openWin("view/productsPage.fxml");
        }
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
