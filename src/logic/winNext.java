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

	
	public void next(ActionEvent event) throws IOException {
		openWin("");
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
	
	public void openWin(String neWin) throws IOException{
		Stage currentWin = new Stage();
        currentWin.setTitle("Homepage");
        Parent root = FXMLLoader.load(getClass().getResource(neWin+".xml"));
        Scene scene = new Scene(root);
        currentWin.setScene(scene);
        currentWin.show();
	}

}
