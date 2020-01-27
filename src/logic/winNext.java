package logic;


import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.model.Product;
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
	
	public void openWarning(Stage k) throws IOException{
		Stage currentWin = new Stage();
        currentWin.setTitle("EcoClean");
        currentWin.initModality(Modality.APPLICATION_MODAL);
        //Parent root = FXMLLoader.load(getClass().getResource("view/warningmessage.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/warningmessage.fxml"));
        Parent root = (Parent)loader.load();
        WarningController controll = loader.getController();
        controll.setStage(k);
        System.out.println(controll.getStage());
        Scene scene = new Scene(root);
        currentWin.setScene(scene);
        currentWin.showAndWait();
	}
	
//	public void openWinInfo(String neWin, Product p) throws IOException{
//		Stage currentWin = new Stage();
//        currentWin.setTitle("EcoClean");        
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(neWin));
//        Parent root = (Parent)loader.load();
//        InfoProductController controller = loader.getController();
//        controller.setP(p);
//        Scene scene = new Scene(root);
//        currentWin.setScene(scene);
//        currentWin.show();
//    	sg.saveScene(scene);
//	}

	public void openWinInfo(String neWin, Product p) throws IOException{
		sg.saveDescription(p.getDescription());
    	sg.saveImage(p.getImage());
		Stage currentWin = new Stage();
        currentWin.setTitle("EcoClean");
        Parent root = FXMLLoader.load(getClass().getResource(neWin));
        Scene scene = new Scene(root);
        sg.saveScene(scene);
    	
        currentWin.setScene(scene);
        currentWin.show();  	
	}
}
