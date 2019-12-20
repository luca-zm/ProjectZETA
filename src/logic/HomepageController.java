package logic;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class HomepageController implements Initializable{

    @FXML
    public MediaView myvideo;
    
    @FXML
    public MediaPlayer myplayer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		myplayer= new MediaPlayer(new Media(this.getClass().getResource("view/images/video.mp4").toExternalForm()));
		
    	myplayer.setAutoPlay(true);
    	myvideo.setMediaPlayer(myplayer);
		
	}
}

