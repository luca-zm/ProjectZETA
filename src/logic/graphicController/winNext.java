package logic.graphicController;


import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.model.Singleton;

public class winNext{

    Singleton sg = Singleton.getInstance(); 
    private Scene myscene;

    public winNext() {
    	myscene = sg.getScene();
    }
    
	public void openWin(String neWin) throws IOException{
		Stage currentWin = new Stage();
        currentWin.setTitle("EcoClean");
        Parent root = FXMLLoader.load(getClass().getResource(neWin));
        Scene scene = new Scene(root);
        currentWin.setScene(scene);
        currentWin.show();
    	sg.saveScene(scene);
	}
	
	public void goBack(ActionEvent event) throws IOException{
		Stage backWin = new Stage();
        backWin.setTitle("EcoClean");
        backWin.setScene(myscene);
        backWin.show();
        Stage change = (Stage)((Node)event.getSource()).getScene().getWindow();
        change.close();
	}

}
