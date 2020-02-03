package logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.TextArea;
import logic.model.CollectionPoint;
import logic.persistence.CollectionPointDAO;
import javax.swing.*;
import bean.CollectionPointBean;
import controller.ControllerManageCollPoint;

public class ModeratorController extends Application {

	
	@FXML
    public Button logout;
	
	
    @FXML
    public Button confirm;
    @FXML
    public Button add;
    
    @FXML
    public TextField name;
    @FXML
    public TextField address;
    @FXML
    public TextField opening;
    @FXML
    public TextField closing;
    
    @FXML
    public TextArea area;
    
    @FXML
    public TextField idcol;

    List<CollectionPoint> list;
    CollectionPointDAO cdao = new CollectionPointDAO();
    ControllerManageCollPoint cmc = new ControllerManageCollPoint();
    StringBuilder bld = new StringBuilder();
    
    public ModeratorController() {
    	name = null;
    	address = null;
    	opening = null;
    	closing = null;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	//empty
    }
    
    public void initialize() throws SQLException {
    	area.setEditable(false);
    	list= cdao.select();
    	for(CollectionPoint p: list) {
    		bld.append(p.getId() + " - " + p.getName() + "\n\n");
    	}
    	area.setText(bld.toString());
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        WinNext a = new WinNext();
        String eventClicked = event.getSource().toString();
        
        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        
        
        if (eventClicked.contentEquals("Button[id=add, styleClass=button]'Add EcoPoint'")) {
        	if (name != null && address != null && opening != null && closing != null) {
                CollectionPointBean cb = new CollectionPointBean(0, name.getText(), address.getText(),
                		Integer.parseInt(opening.getText()), Integer.parseInt(closing.getText()));
                try {
					cmc.insert(cb);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
                	try {
						cmc.delete(p);
					} catch (SQLException e) {
						e.printStackTrace();
					}
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