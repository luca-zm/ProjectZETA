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
import logic.enums.Category;
import logic.model.AbstractUser;
import logic.model.Product;
import logic.persistence.ProductDAO;
import logic.persistence.UserDAO;

import javax.swing.*;

public class AdminController extends Application {

	
	@FXML
	private Button logout;
	
	
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button ban;

    @FXML
    private TextArea listprod;
    @FXML
    private TextArea listusers;
	private Category utility;

    //products
    @FXML
    private TextField prodid;
    @FXML
    private TextField prodname;
    @FXML
    private TextField proddisc;
    @FXML
    private TextField prodimg;
    @FXML
    private TextField prodgc;
    @FXML
    private TextField proddescr;
    @FXML
    private TextField prodid2;
    
    //users
    @FXML
    private TextField userid1;

    
    StringBuilder bld1 = new StringBuilder();
    StringBuilder bld2 = new StringBuilder();


    public void initialize() throws SQLException {
    	listprod.setEditable(false);	
    	listusers.setEditable(false);

    	
    	List<AbstractUser> aUser= UserDAO.findUsers();
    	List<Product> listPRODUCTS = ProductDAO.select();

    	for(Product p: listPRODUCTS) {
    		bld1.append(p.getId() + " - " + p.getName() + "\n\n");
    	}
    	for(AbstractUser ut: aUser) {
    		bld2.append(ut.getId() +" - "+ ut.getName() +"\n\n");
    	}
    	listprod.setText(bld1.toString());
    	listusers.setText(bld2.toString());

    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	//empty
    }

    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
        WinNext a = new WinNext();
        String eventClicked = event.getSource().toString();
        String sonaradmin="view/adminPage.fxml";

        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=add, styleClass=button]'Add'")) {
        	//metodo opzioni prodotti
        	if(prodid != null && prodname != null && proddisc != null && prodimg != null && prodgc != null && proddescr != null) {
        	
        		Product product = new Product(Integer.parseInt(prodid.getText()),prodname.getText(),
        				Integer.parseInt(prodgc.getText()), Integer.parseInt(proddisc.getText()),
        				utility, prodimg.getText(), proddescr.getText());
        		
        		ProductDAO.insert(product);
        		JOptionPane.showMessageDialog(null, "Product correctly insert!");
                Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
                a.openWin(sonaradmin);
                oldWin.close();
        		
        	}else {
        		JOptionPane.showMessageDialog(null, "Invalid"); 
        	}
        	
        }
        if (eventClicked.contentEquals("Button[id=delete, styleClass=button]'Delete'")) {
        		ProductDAO.delete(Integer.parseInt(prodid2.getText()));
        		
        		JOptionPane.showMessageDialog(null, "Product correctly deleted!");
                Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
                a.openWin(sonaradmin);
                oldWin.close();
        }
        
        
        //------------------------------------------------------------------------------------
        
        
        if (eventClicked.contentEquals("Button[id=ban, styleClass=button]'Remove'")) {
        	UserDAO.delete(UserDAO.findUserById(Integer.parseInt(userid1.getText())));
    		
    		JOptionPane.showMessageDialog(null, "BAAAAAAN HAMMEEER!!!");
            Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            a.openWin(sonaradmin);
            oldWin.close();
        }
        
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
