package laptopeco.logic;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.Singleton;

public class WinNext{

    Singleton sg = Singleton.getInstance(); 
    private Scene myscene;
    String title;

    public WinNext() {
    	myscene = sg.getScene();
    	title="EcoClean";
    }
    
	public void openWin(String neWin) throws IOException{
		Stage currentWin = new Stage();
        currentWin.setTitle(title);
        Parent root = FXMLLoader.load(getClass().getResource(neWin));
        Scene scene = new Scene(root);
        currentWin.setScene(scene);
        currentWin.show();
    	sg.saveScene(scene);
	}
	
	public void goBack(ActionEvent event) throws IOException{
		Stage backWin = new Stage();
        backWin.setTitle(title);
        backWin.setScene(myscene);
        backWin.show();
        Stage change = (Stage)((Node)event.getSource()).getScene().getWindow();
        change.close();
	}
	
	public void openWarning(Stage k) throws IOException{
		Stage currentWin = new Stage();
        currentWin.setTitle(title);
        currentWin.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/warningmessage.fxml"));
        Parent root = (Parent)loader.load();
        WarningController controll = loader.getController();
        controll.setStage(k);
        Scene scene = new Scene(root);
        currentWin.setScene(scene);
        currentWin.showAndWait();
	}
	

	public void openWinInfo(String neWin, Product p) throws IOException{
		sg.saveDescription(p.getDescription());
    	sg.saveImage(p.getImage());
		Stage currentWin = new Stage();
        currentWin.setTitle(title);
        Parent root = FXMLLoader.load(getClass().getResource(neWin));
        Scene scene = new Scene(root);
        sg.saveScene(scene);
    	
        currentWin.setScene(scene);
        currentWin.show();  	
	}
}
