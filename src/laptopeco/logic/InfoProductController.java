package laptopeco.logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.TextArea;
import laptopeco.logic.model.Singleton;

public class InfoProductController extends Application {

    @FXML
    private Button back;
    
    @FXML
    private TextArea description;

    @FXML
    private ImageView image;
        

    WinNext a = new WinNext();
    Singleton sg = Singleton.getInstance();


    @Override
    public void start(Stage primaryStage) throws Exception {	
    	//empty
    }

    @FXML
	public void initialize(){
    	description.setText(sg.getDescr());


    	Image imageObject = new Image(sg.getImage());
    	image.setImage(imageObject);

    }
    @FXML
    private void next(ActionEvent event) throws IOException {
        
        String eventClicked = event.getSource().toString();
        

        if (eventClicked.contentEquals("Button[id=back, styleClass=button]'Back'")) {
        	a.goBack(event);
        }
       
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }

    
    
}




