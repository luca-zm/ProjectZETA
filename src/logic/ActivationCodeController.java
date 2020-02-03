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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import logic.model.AbstractUser;
import logic.model.Singleton;
import javax.swing.*;
import bean.ActivationCodeBean;
import controller.ControllerLogin;
import controller.ControllerShopCartCheckOut;

public class ActivationCodeController extends Application {

	
	@FXML
    public Button logout;
	
    @FXML
    public Button confirm;
    @FXML
    public Button shop;
    @FXML
    public Button wish;
    
    @FXML
    public Button map;
    @FXML
    public Button codelink;
    @FXML
    public Button prodlink;
    @FXML
    public Button userlink;
    
    @FXML
    public Text wb;
    
    @FXML
    public TextArea upgc;
    
    @FXML
    public TextArea mygc;
    
    @FXML
    public TextField addgc;
    
    Singleton sg =Singleton.getInstance();
    ControllerShopCartCheckOut ac = new ControllerShopCartCheckOut();
    
    ControllerLogin cl = new  ControllerLogin();

	AbstractUser user = sg.getUser();



    @Override
    public void start(Stage primaryStage) throws Exception {
    	//empty
    }

    public void initialize() {
		codelink.setDisable(true);
		mygc.setText(Integer.toString(user.getGreenCoin()));
		
		if(sg.getUser() == null) { //utente non loggato
			wb.setVisible(false);
			logout.setVisible(false);
		}
	}
    
    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
    	WinNext a = new WinNext();

        String eventClicked = event.getSource().toString();
        
        if (eventClicked.contentEquals("Button[id=confirm, styleClass=button]'OK'")) {

        	ActivationCodeBean acb = new ActivationCodeBean(Integer.parseInt(addgc.getText()), 0);
        	int val = ac.enabledActivationCode(acb);
        	if ( val == 0) { //code inesistente
        		JOptionPane.showMessageDialog(null, "Code does not exist, try with another code please");
        		
        	}else {
        		upgc.setText(Integer.toString(val));
        		addgc.setText(""); //per aggiornare il riquadro dei greencoin in real time
        		mygc.setText(Integer.toString(user.getGreenCoin()));
        	}
        	return;
        }
        
        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        
        //Toolbar
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=wish, styleClass=button]'Wishlist'")) {
        	//pagina wishlist
        	a.openWin("view/wishlistPage.fxml");
        }
        
        //Hyperlink
        if (eventClicked.contentEquals("Button[id=maplink, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=prodlink, styleClass=button]'Products'")) {
        	//pagina prodotti
        	a.openWin("view/productsPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=userlink, styleClass=button]'User Profile'")) {
        	//pagina prodotti
        	a.openWin("view/userprofilePage.fxml");
        }               
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}