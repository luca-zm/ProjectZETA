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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.model.Product;
import logic.model.Singleton;

import javax.swing.*;

public class InfoProductController extends Application {

    @FXML
    public Button back;
    
    @FXML
    public TextArea description;

    @FXML
    public ImageView image;
        

    winNext a = new winNext();
    Singleton sg = Singleton.getInstance();

    public InfoProductController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	
    }

    @FXML
	public void initialize(){
    	description.setText(sg.getDescr());


    	Image imageObject = new Image(sg.getImage());
    	image.setImage(imageObject);

    }
    @FXML
    private void next(ActionEvent event) throws IOException {
        //winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        

        if (eventClicked.contentEquals("Button[id=back, styleClass=button]'Back'")) {
        	a.goBack(event);
        }
       
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }

    
    
}




