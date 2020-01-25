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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.model.AbstractUser;
import logic.model.ActivationCode;
import logic.model.Singleton;
import logic.persistence.ActivationCodeDAO;

import javax.swing.*;

import bean.ActivationCodeBean;
import bean.UserBean;
import controller.ControllerLogin;
import controller.ControllerShopCartCheckOut;

public class ActivationCodeController extends Application {

    @FXML
    public Button confirm, shop, wish;
    
    @FXML
    public Button map, a_code_link, prod_link, user_p_link;
    
    public winNext a;
    
    @FXML
    public Text wb;
    
    @FXML
    public TextArea up_gc, mygc;
    
    @FXML
    public TextField add_gc;
    
    Singleton sg =Singleton.getInstance();
    ControllerShopCartCheckOut ac = new ControllerShopCartCheckOut();
    
    ControllerLogin cl = new  ControllerLogin();

	AbstractUser user = sg.getUser();

    
    public ActivationCodeController() {
    	
    	a = new winNext();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public void initialize() {
		a_code_link.setDisable(true);
		mygc.setText(Integer.toString(user.getGreenCoin()));
		
		if(sg.getUser() == null) { //utente non loggato
			wb.setVisible(false);
		}
	}
    
    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
        //winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        
        if (eventClicked.contentEquals("Button[id=confirm, styleClass=button]'OK'")) {

        	ActivationCodeBean acb = new ActivationCodeBean(Integer.parseInt(add_gc.getText()), 0);
        	int val = ac.enabledActivationCode(acb);
        	if ( val == 0) { //code inesistente
        		JOptionPane.showMessageDialog(null, "Code does not exist, try with another code please");
        		
        	}else {
        		up_gc.setText(Integer.toString(val));
        		add_gc.setText("");
        		AbstractUser userNew = sg.getUser(); //per aggiornare il riquadro dei greencoin in real time
        		mygc.setText(Integer.toString(userNew.getGreenCoin()));
        	}
        	return;
        }
        
        
        //-----------toolbar---------------
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=wish, styleClass=button]'Wishlist'")) {
        	//pagina wishlist
        	a.openWin("view/wishlistPage.fxml");
        }
        
        
        
      //hyperlink----------------
        if (eventClicked.contentEquals("Button[id=map_link, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	//pagina prodotti
        	a.openWin("view/productsPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button]'User Profile'")) {
        	//pagina prodotti
        	a.openWin("view/userprofilePage.fxml");
        }
        //hyperlink----------------
        
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}