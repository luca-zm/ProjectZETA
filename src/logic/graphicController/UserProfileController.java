package logic;

import java.awt.Color;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class UserProfileController extends Application {

	
	@FXML
    private ImageView avatarImage;

	public UserProfileController() {
		
	}

	//setto l'avatar a forma di cerchio
    @FXML
    public void initialize() {
        // set a clip to apply rounded border to the original image.
    	//NON TOCCARE LE DIMENSIONI
    	Circle clip = new Circle(95, 82, 80);
        avatarImage.setClip(clip);
    }
	
	@FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        a.openWin("");
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	}

}
