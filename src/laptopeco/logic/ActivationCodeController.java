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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.Singleton;
import javax.swing.*;

import laptopeco.ExceptionEco.NotAnIntegerException;
import laptopeco.bean.ActivationCodeBean;
import laptopeco.bean.BeanValidate;
import laptopeco.controller.ControllerLogin;
import laptopeco.controller.ControllerShopCartCheckOut;

public class ActivationCodeController extends Application {

	
	@FXML
	private Button logout;
	
    @FXML
    private Button confirm;
    @FXML
    private Button shop;
    @FXML
    private Button wish;
    
    @FXML
    private Button map;
    @FXML
    private Button codelink;
    @FXML
    private Button prodlink;
    @FXML
    private Button userlink;
    
    @FXML
    private Text wb;
    
    @FXML
    private TextArea upgc;
    
    @FXML
    private TextArea mygc;
    
    @FXML
    private TextField addgc;
    
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
    	ManagerClick m = new ManagerClick();
    	String style="button";
        String eventClicked = event.getSource().toString();
        
        if (m.check(eventClicked, "confirm", style, "OK")) {
        


        	String actCodeString = addgc.getText();
        	try {
        		if(!BeanValidate.isInteger(actCodeString)) {
        			throw new NotAnIntegerException();
        		}
        		
        	}catch(NotAnIntegerException exc) {
        		addgc.setText("");
        		JOptionPane.showMessageDialog(null, exc.toString());
        		return;
        	}
        	
        	ActivationCodeBean acb = new ActivationCodeBean(Integer.parseInt(actCodeString), 0);
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
        
        
        m.goToPath(eventClicked, "logout", style, "Logout", "view/login_registerPage.fxml");
        
        
        
      //Toolbar
        m.goToPath(eventClicked, "shop", style, "Shopcart", "view/shopcartPage.fxml");
        
        m.goToPath(eventClicked, "wish", style, "Wishlist", "view/wishlistPage.fxml");
        
        //Hyperlink
        m.goToPath(eventClicked, "maplink", style, "Map", "view/mapPage.fxml");

        m.goToPath(eventClicked, "prodlink", style, "Products", "view/productsPage.fxml");

        m.goToPath(eventClicked, "userlink", style, "User Profile", "view/userprofilePage.fxml");
   
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
        
    }
}





