package logic;

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
import logic.enums.Roles;
import logic.model.Singleton;
import javax.swing.*;
import bean.AddressBean;
import bean.UserBean;
import controller.ControllerLogin;
import controller.ControllerRegistration;

public class LoginController extends Application {

    @FXML
    public Button log;
    
    @FXML
    public Button conf;
    
    @FXML
    public Button back;
    
    
    @FXML
    public TextField mail;
    @FXML
    public TextField passr;
    @FXML
    public TextField pass2r;
    @FXML
    public TextField mailr;
    @FXML
    public TextField surr;
    @FXML
    public TextField namer;
    
    @FXML
    public TextField addr;
    @FXML
    public TextField cityr;
    @FXML
    public TextField zipr;
    @FXML
    public TextField telr;
    @FXML
    public TextField stater;
    @FXML
    public TextField zoner;

    @FXML
    public PasswordField psw;
    
    Singleton sg = Singleton.getInstance(); 
    
    ControllerLogin cl = new ControllerLogin();
    ControllerRegistration cr = new ControllerRegistration();


    @Override
    public void start(Stage primaryStage) throws Exception {
    	psw.setText("");
    }

    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
        winNext a = new winNext();

        String eventClicked = event.getSource().toString();

        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login!'")) {
        	
        		if(mail.getText().contentEquals("") || psw.getText().contentEquals("")) {
        			return;
        		}
        		
        		UserBean ub = new UserBean(0,  mail.getText() , null, null , psw.getText(), null);
        		
        	
        	
        		
        		//METODO che verifica se l'utente si e' loggato o meno con RUOLO
        		if(cl.login(ub)) {
        			if(cl.giveUserForRole(ub).getType().equals(Roles.ADMIN)) {
        				a.openWin("view/adminPage.fxml");
        			}
        			else if(cl.giveUserForRole(ub).getType().equals(Roles.COLLECTIONPOINTMAN)) {
        				a.openWin("view/modPage.fxml");
        			}
        				
        			else { a.openWin("view/productsPage.fxml");}
        			
        		}
        		else {
        			return;
        		}
         }
        	
        
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
