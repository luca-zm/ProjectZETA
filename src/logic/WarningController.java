package logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import logic.model.Singleton;


public class WarningController extends Application {

    @FXML
    public Button log, cancel;
    
    Singleton sg = Singleton.getInstance(); 
    
    Stage stage = null;

    
    public WarningController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        
        String eventClicked = event.getSource().toString();
        System.out.println(eventClicked);
        if (eventClicked.contentEquals("Button[id=log, styleClass=button btn-success]'Go to Login!'")) {
        	a.openWin("view/login_registerPage.fxml");
        	Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldWin.close();
            stage.close();
        }
        
        if (eventClicked.contentEquals("Button[id=cancel, styleClass=button btn-danger]'Continue as guest'")) {
        	Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldWin.close();
        }     
        
    }

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
    
    
}
