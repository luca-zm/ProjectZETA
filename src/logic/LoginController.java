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

import bean.UserBean;
import controller.ControllerLogin;

public class LoginController extends Application {

    @FXML
    public Button log, conf, back;
    
    @FXML
    public TextField usr, pass_r, pass2_r, mail_r, add_r, sur_r, name_r;
    
    @FXML
    public PasswordField psw;
    
    Singleton sg = Singleton.getInstance(); 
    
    ControllerLogin cl = new ControllerLogin();
    
    

    //private int flag;

    /**
    flag = 0 UTENTE NON LOGGATO
    flag = 1 UTENTE LOGGATO
     */
    public LoginController() {
    	
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
        winNext a = new winNext();

        String eventClicked = event.getSource().toString();
        if (eventClicked.contentEquals("Button[id=back, styleClass=button]'Continue without signing in'")) {
        	a.openWin("view/productsPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login!'")) {
        	
        	
        	UserBean ub = new UserBean(null, null, psw.getText(), usr.getText(), null);
        	
        	//metodo verifica credenziali, imposta flag, fa aprire schermata prodotti, admin, moderatore in base al flag 
        	if (usr.getText().contentEquals("admin") && psw.getText().contentEquals("admin")) {
        		a.openWin("view/adminPage.fxml");
        	}
        	if (usr.getText().contentEquals("moderator") && psw.getText().contentEquals("moderator")) {
        		a.openWin("view/modPage.fxml");
        	}
        	//METODO che verifica se l'utente si e' loggato o meno, mposta 1 se � loggato
        	if(cl.login(ub)) {
        		a.openWin("view/productsPage.fxml");
        	}
        	 	
        	//System.out.println(ub);
        	//System.out.println(cl.login(ub));

        	
        }
        if (eventClicked.contentEquals("Button[id=conf, styleClass=button]'Confirm'")) {
        	//metodo registra
        	System.out.println(sg.getUser());

        }
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
