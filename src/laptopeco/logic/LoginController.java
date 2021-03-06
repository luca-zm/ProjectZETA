package laptopeco.logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import laptopeco.logic.enums.Roles;
import laptopeco.logic.model.Singleton;
import javax.swing.*;
import laptopeco.bean.AddressBean;
import laptopeco.bean.UserBean;
import laptopeco.controller.ControllerLogin;
import laptopeco.controller.ControllerRegistration;

public class LoginController extends Application {

    @FXML
    private Button log;
    
    @FXML
    private Button conf;
    
    @FXML
    private Button back;
    
    
    @FXML
    private TextField mail;
    @FXML
    private TextField passr;
    @FXML
    private TextField pass2r;
    @FXML
    private TextField mailr;
    @FXML
    private TextField surr;
    @FXML
    private TextField namer;
    
    @FXML
    private TextField addr;
    @FXML
    private TextField cityr;
    @FXML
    private TextField zipr;
    @FXML
    private TextField telr;
    @FXML
    private TextField stater;
    @FXML
    private TextField zoner;

    @FXML
    private PasswordField psw;
    
    Singleton sg = Singleton.getInstance(); 
    
    ControllerLogin cl = new ControllerLogin();
    ControllerRegistration cr = new ControllerRegistration();


    @Override
    public void start(Stage primaryStage) throws Exception {
    	psw.setText("");
    }

    @FXML
    private void nextT(ActionEvent event) throws IOException, SQLException {
        WinNext a = new WinNext();

        String eventClicked = event.getSource().toString();

        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login!'")) {
        	
        		if(mail.getText().contentEquals("") || psw.getText().contentEquals("")) {
    				JOptionPane.showMessageDialog(null, "fill in both fields please");
        			return;
        		}
        		
        		UserBean ub = new UserBean(0,  mail.getText() , null, null , psw.getText(), null);
        		

        		//METODO che verifica se l'utente si e' loggato o meno con RUOLO
        		if(cl.login(ub)) {
        			Roles type= cl.giveUserForRole(ub).getType();
        			if(type.equals(Roles.ADMIN)) {
        				Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        				a.openWin("view/adminPage.fxml");
        				oldWin.close();
        				return;
        			}
        			if(type.equals(Roles.COLLECTIONPOINTMAN)) {
        				Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        				a.openWin("view/modPage.fxml");
        				oldWin.close();
        				return;
        			}
        			
        			a.openWin("view/productsPage.fxml");
        		}
        		else {
    				JOptionPane.showMessageDialog(null, "Mail or Password incorrect !");
        			return;
        		}
         }
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
    
    
    
    
    
    
    
    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
        WinNext a = new WinNext();

        String eventClicked = event.getSource().toString();
     	
        
        if (eventClicked.contentEquals("Button[id=conf, styleClass=button]'Confirm'")) {
        	
    			
        		AddressBean newadd = new AddressBean(addr.getText(), cityr.getText(), zipr.getText(), telr.getText(),
    													stater.getText(), zoner.getText());
        		
        		UserBean ub = new UserBean(0, mailr.getText(), namer.getText(), surr.getText(), passr.getText(), newadd);

        		if(passr.getText().contentEquals(pass2r.getText())) {
        			if(cr.register(ub)) {
        				JOptionPane.showMessageDialog(null, "Registration succesfully!\nPlease login now");
        				a.openWin("view/login_registerPage.fxml");
        			}else {
        			JOptionPane.showMessageDialog(null, "User already registered, please change your email");
        			}	
        		}
        }
        
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
