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
import logic.enums.Category;
import logic.enums.Roles;
import logic.model.AbstractUser;
import logic.model.CollectionPoint;
import logic.model.Product;
import logic.model.Singleton;
import logic.model.User;
import logic.persistence.ProductDAO;
import logic.persistence.UserDAO;

import javax.swing.*;

public class AdminController extends Application {

	
	@FXML
    public Button logout;
	
	
    @FXML
    public Button add, delete, ban;

    @FXML
    public TextArea listprod, listusers;
	private Category utility;

    //products
    @FXML
    public TextField prodid, prodname, proddisc, prodimg, prodgc, proddescr;
    @FXML
    public TextField prodid2;
    
    //users
    @FXML
    public TextField userid1;

    
    UserDAO user = new UserDAO();
    ProductDAO prod = new ProductDAO();
    ArrayList<AbstractUser> listUSERS;
    ArrayList<Product> listPRODUCTS;


    public AdminController() {    	
    }

    public void initialize() throws SQLException {
    	listprod.setEditable(false);	
    	listusers.setEditable(false);
    	
    	String prods="";
    	String users="";
    	
    	listUSERS= user.findUsers();
    	listPRODUCTS = prod.select();

    	for(Product p: listPRODUCTS) {
    		prods = prods + p.getId() + " - " + p.getName() + "\n\n";
    	}
    	for(AbstractUser ut: listUSERS) {
    		users = users + ut.getId() + " - " + ut.getName() + "\n\n";
    	}
    	
    	listprod.setText(prods);
    	listusers.setText(users);
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
        winNext a = new winNext();
        String eventClicked = event.getSource().toString();

        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=add, styleClass=button]'Add'")) {
        	//metodo opzioni prodotti
        	if(prodid != null && prodname != null && proddisc != null && prodimg != null && prodgc != null && proddescr != null) {
        	
        		Product product = new Product(Integer.parseInt(prodid.getText()),prodname.getText(),
        				Integer.parseInt(prodgc.getText()), Integer.parseInt(proddisc.getText()),
        				utility, prodimg.getText(), proddescr.getText(), true);
        		
        		prod.insert(product);
        		JOptionPane.showMessageDialog(null, "Product correctly insert!");
                Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
                a.openWin("view/adminPage.fxml");
                oldWin.close();
        		
        	}
        	
        }
        if (eventClicked.contentEquals("Button[id=delete, styleClass=button]'Delete'")) {
        		prod.delete(Integer.parseInt(prodid2.getText()));
        		
        		JOptionPane.showMessageDialog(null, "Product correctly deleted!");
                Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
                a.openWin("view/adminPage.fxml");
                oldWin.close();
        }
        
        
        //------------------------------------------------------------------------------------
        
        
        if (eventClicked.contentEquals("Button[id=ban, styleClass=button]'Remove'")) {
        	user.delete(user.findUserById(Integer.parseInt(userid1.getText())));
    		
    		JOptionPane.showMessageDialog(null, "BAAAAAAN HAMMEEER!!!");
            Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            a.openWin("view/adminPage.fxml");
            oldWin.close();
        }
        
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
