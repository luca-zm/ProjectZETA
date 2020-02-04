package laptopeco.logic;

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
import laptopeco.logic.model.CollectionPoint;
import laptopeco.logic.persistence.CollectionPointDAO;
import javax.swing.*;
import laptopeco.bean.CollectionPointBean;
import laptopeco.controller.ControllerManageCollPoint;

public class ModeratorController extends Application {

	
	@FXML
	private Button logout;
	
	
    @FXML
    private Button confirm;
    @FXML
    private Button add;
    
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField opening;
    @FXML
    private TextField closing;
    
    @FXML
    private TextArea area;
    
    @FXML
    private TextField idcol;

    List<CollectionPoint> list;
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
    	list= CollectionPointDAO.select();
    	for(CollectionPoint p: list) {
    		bld.append(p.getId() + " - " + p.getName() + "\n\n");
    	}
    	area.setText(bld.toString());
    }

    @FXML
    private void nextT(ActionEvent event) throws IOException {
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
					if(cmc.insert(cb)) {
		                JOptionPane.showMessageDialog(null, "EcoPoint correctly insert!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Insert error");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

                Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
                a.openWin("view/modPage.fxml");
                oldWin.close();
                return;
        	}
            JOptionPane.showMessageDialog(null, "Incorrect data, try again please");
        	return;
        }
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
    
    
    
 
    
    @FXML
    private void next(ActionEvent event) throws IOException {
        WinNext a = new WinNext();
        String eventClicked = event.getSource().toString();
        
        
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