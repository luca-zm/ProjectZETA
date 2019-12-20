package logic;


import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class winNext {

	
	public void openWin(String neWin) throws IOException{
		Stage currentWin = new Stage();
        currentWin.setTitle("EcoClean");
        Parent root = FXMLLoader.load(getClass().getResource(neWin));
        Scene scene = new Scene(root);
        currentWin.setScene(scene);
        currentWin.show();
	}

}
