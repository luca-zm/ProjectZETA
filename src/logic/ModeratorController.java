package logic;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.model.CollectionPoint;
import logic.model.Singleton;
import logic.persistence.CollectionPointDAO;

import javax.swing.*;

import bean.CollectionPointBean;
import controller.ControllerManageCollPoint;

public class ModeratorController extends Application {

    @FXML
    public Button confirm, add;
    
    @FXML
    public TextField name, address, opening, closing, avaiable;
    
    @FXML
    public TextArea area;
    
    @FXML
    public TextField idcol;

    ArrayList<CollectionPoint> list;
    CollectionPointDAO cdao = new CollectionPointDAO();
    ControllerManageCollPoint CMC = new ControllerManageCollPoint();
    
    public ModeratorController() {
    	name = null;
    	address = null;
    	opening = null;
    	closing = null;
    	avaiable = null;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }
    
    public void initialize() throws SQLException {
    	area.setEditable(false);
    	String s="";
    	list= cdao.select();
    	for(CollectionPoint p: list) {
    		s = s + p.getId() + " - " + p.getName() + "\n\n";
    	}
    	area.setText(s);
    }

    @FXML
    private void next(ActionEvent event) throws Exception {
        winNext a = new winNext();
        String eventClicked = event.getSource().toString();
        if (eventClicked.contentEquals("Button[id=add, styleClass=button]'Add EcoPoint'")) {
        	if (name != null && address != null && opening != null && closing != null && avaiable != null) {
                CollectionPointBean cb = new CollectionPointBean(0, name.getText(), address.getText(),
                		Integer.parseInt(opening.getText()), Integer.parseInt(closing.getText()),
                		Boolean.parseBoolean(avaiable.getText()));
                CMC.insert(cb);
                JOptionPane.showMessageDialog(null, "EcoPoint correctly insert!");
                Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
                a.openWin("view/modPage.fxml");
                oldWin.close();
                return;
        	}
            JOptionPane.showMessageDialog(null, "Incorrect data, try again please");
        	return;
        }
        
        if (eventClicked.contentEquals("Button[id=confirm, styleClass=button]'Confirm'")) {
        	int id= Integer.parseInt(idcol.getText());
        	for (CollectionPoint p: list) {
        		if (p.getId() == id) {
                	CMC.delete(p);
                    JOptionPane.showMessageDialog(null, "EcoPoint correctly deleted");
                    Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    a.openWin("view/modPage.fxml");
                    oldWin.close();
                	return;
        		}
        	}
            JOptionPane.showMessageDialog(null, "EcoPoint you wanted to delete, does not exist.");
        	return;
        }
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}