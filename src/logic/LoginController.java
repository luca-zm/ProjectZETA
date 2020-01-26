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
import javafx.scene.control.PasswordField;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.model.Singleton;

import javax.swing.*;

import bean.AddressBean;
import bean.UserBean;
import controller.ControllerLogin;
import controller.ControllerRegistration;

public class LoginController extends Application {

    @FXML
    public Button log, conf, back;
    
    @FXML
    public TextField usr, pass_r, pass2_r, mail_r, sur_r, name_r;
    
    @FXML
    public TextField add_r, city_r, zip_r, tel_r, state_r, country_r, zone_r;

    @FXML
    public PasswordField psw;
    
    Singleton sg = Singleton.getInstance(); 
    
    ControllerLogin cl = new ControllerLogin();
    ControllerRegistration cr = new ControllerRegistration();
    
    public LoginController() {
    	
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	psw.setText("fanculo");
    }

    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
        winNext a = new winNext();

        String eventClicked = event.getSource().toString();
        if (eventClicked.contentEquals("Button[id=back, styleClass=button]'Continue without signing in'")) {
        	a.openWin("view/productsPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login!'")) {
        	
        		UserBean ub = new UserBean(0, null, null, psw.getText(), usr.getText(), null);
        	
        		//metodo verifica credenziali, imposta flag, fa aprire schermata prodotti, admin, moderatore in base al flag 
        		if (usr.getText().contentEquals("admin") && psw.getText().contentEquals("admin")) {
        			a.openWin("view/adminPage.fxml");
        		}
        		if (usr.getText().contentEquals("moderator") && psw.getText().contentEquals("moderator")) {
        			a.openWin("view/modPage.fxml");
        		}
        		//METODO che verifica se l'utente si e' loggato o meno
        		if(cl.login(ub)) {
        			a.openWin("view/productsPage.fxml");
        		}
        	
        }
        if (eventClicked.contentEquals("Button[id=conf, styleClass=button]'Confirm'")) {
        	
    			
        		AddressBean newadd = new AddressBean(add_r.getText(), city_r.getText(), zip_r.getText(), tel_r.getText(),
    													state_r.getText(), country_r.getText(), zone_r.getText());
        		
        		UserBean ub = new UserBean(0, name_r.getText(), sur_r.getText(), pass_r.getText(), mail_r.getText(), newadd);

        		if(cr.register(ub)) {
        			JOptionPane.showMessageDialog(null, "Registration succesfully!\nPlease login now");
        			a.openWin("view/login_registerPage.fxml");
        		}else {
        			JOptionPane.showMessageDialog(null, "User already registered, please change your email");
        		}	

        }
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
