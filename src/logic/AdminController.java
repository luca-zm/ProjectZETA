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
import java.util.ArrayList;
import javafx.scene.control.TextArea;
import logic.enums.Category;
import logic.model.AbstractUser;
import logic.model.Product;
import logic.persistence.ProductDAO;
import logic.persistence.UserDAO;

import javax.swing.*;

public class AdminController extends Application {

	
	@FXML
    public Button logout;
	
	
    @FXML
    public Button add;
    @FXML
    public Button delete;
    @FXML
    public Button ban;

    @FXML
    public TextArea listprod;
    @FXML
    public TextArea listusers;
	private Category utility;

    //products
    @FXML
    public TextField prodid;
    @FXML
    public TextField prodname;
    @FXML
    public TextField proddisc;
    @FXML
    public TextField prodimg;
    @FXML
    public TextField prodgc;
    @FXML
    public TextField proddescr;
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
    	//empty
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
