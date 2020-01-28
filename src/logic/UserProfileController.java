package logic;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JOptionPane;

import bean.UserBean;
import controller.ControllerLogin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.model.AbstractUser;
import logic.model.History;
import logic.model.Message;
import logic.model.NoticeBoard;
import logic.model.Product;
import logic.model.Singleton;
import logic.model.User;
import logic.persistence.MessageDAO;

public class UserProfileController extends Application {

	
	@FXML
    private ImageView avatarImage;
	
	@FXML
    public Button wish, shop, message;

    @FXML
    public Button map, a_code_link, prod_link, user_p_link;
    
    @FXML
    public Text tname, tsurname, tmail, ttel, taddress, tgreencoin;
    
    @FXML
    public TextArea story;

    
    public NumberAxis xAxis = new NumberAxis(1960, 2020, 10); 
    public NumberAxis yAxis = new NumberAxis(0, 350, 50); 
    @FXML
    public LineChart chart = new LineChart(xAxis, yAxis);
    
    
    ControllerLogin cl = new  ControllerLogin();
	

	Singleton sg = Singleton.getInstance();
	AbstractUser user = sg.getUser();
	//MessageDAO md = new MessageDAO();
	
    
	public UserProfileController() {
		
	}

	//setto l'avatar a forma di cerchio
	@FXML
    public void initialize() {
		
    	user_p_link.setDisable(true); 
    	story.setText(sg.getUser().getHistory().getTranList().toString());
    	//------gestione profilo utente-------

    	tname.setText(user.getName());
    	tsurname.setText(user.getSurname());
    	tmail.setText(user.getMail());
    	ttel.setText(user.getAddress().getTelephone());
    	System.out.println(Integer.toString(user.getGreenCoin()));
    	tgreencoin.setText(Integer.toString(user.getGreenCoin()));
    	taddress.setText(user.getAddress().getAddress()+" "+user.getAddress().getPostalCode()+" "+
    	user.getAddress().getCity()+" "+user.getAddress().getCountry());
    	
    	
    	XYChart.Series series = new XYChart.Series(); 
    	series.setName("Greencoin graph"); 
    	
    	//for(user: user.getHistory().getTranList()series) {

    	series.getData().add(new XYChart.Data(250, 15)); 
    	series.getData().add(new XYChart.Data(340, 30)); 
    	series.getData().add(new XYChart.Data(720, 60));     	
    	//}
    	chart.getData().add(series);

    	//-------------
    	
    	
    }
	
	@FXML
    private void next(ActionEvent event) throws IOException {
		winNext a = new winNext();
        String eventClicked = event.getSource().toString();
        System.out.println(eventClicked);
        
        
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=wish, styleClass=button]'Wishlist'")) {
        	//pagina wishlist
        	a.openWin("view/wishlistPage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activate your code!'")) {
        	//pagina activation code
        	a.openWin("view/activationcodePage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=message, styleClass=button btn-info]'MSG'")) {
        	String messaggi = "";
        	for(Message m : user.getBoards().getList()) {
        		messaggi = messaggi + m.getTitle() + ": " + m.getBodymessage() + "\n";
        	}
			JOptionPane.showMessageDialog(null, messaggi);
			return;
        }
        //hyperlink----------------
        if (eventClicked.contentEquals("Button[id=map_link, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	a.openWin("view/activationcodePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	//pagina prodotti
        	a.openWin("view/productsPage.fxml");
        }
        //hyperlink----------------
        
       
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	}

}
