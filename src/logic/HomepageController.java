package logic;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class HomepageController extends Application implements Initializable{

    @FXML
    public MediaView myvideo;
    
    @FXML
    public MediaPlayer myplayer;
    
    @FXML
    public Button log, shop;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		myplayer= new MediaPlayer(new Media(this.getClass().getResource("view/images/video.mp4").toExternalForm()));
    	myplayer.setAutoPlay(true);
    	myvideo.setMediaPlayer(myplayer);
    	myplayer.setMute(true);
        myplayer.setCycleCount(MediaPlayer.INDEFINITE);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
	
	@FXML
    private void nextLog(ActionEvent event) throws IOException {
        winNext a = new winNext();
        String eventClicked = event.getSource().toString();
        if (eventClicked == "Button[id=log, styleClass=button]'Login or Register'") {
        	
        }
        a.openWin("view/login_registerPage.fxml");
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
	@FXML
    private void nextShop(ActionEvent event) throws IOException {
        winNext a = new winNext();
        a.openWin("view/productsPage.fxml");
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}