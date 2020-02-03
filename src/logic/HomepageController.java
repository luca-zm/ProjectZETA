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
    private MediaView myvideo;
    
    @FXML
    private MediaPlayer myplayer;
    
    @FXML
    private Button log;
    @FXML
    private Button hop;

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		myplayer= new MediaPlayer(new Media(this.getClass().getResource("view//images//video.mp4").toExternalForm()));

    	myplayer.setAutoPlay(true);
    	myvideo.setMediaPlayer(myplayer);
    	myplayer.setMute(true);
        myplayer.setCycleCount(MediaPlayer.INDEFINITE);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		//empty
		
	}
	
	@FXML
    private void next(ActionEvent event) throws IOException {
        WinNext a = new WinNext();

        String eventClicked = event.getSource().toString();

        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login or Register'")) {
        	a.openWin("view/login_registerPage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Visit shop!'")) {
        	a.openWin("view/productsPage.fxml");
        }
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}