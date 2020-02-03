package logic;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import controller.ControllerLogin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.model.AbstractUser;
import logic.model.Message;
import logic.model.Singleton;
import logic.persistence.MessageDAO;

public class UserProfileController extends Application {

	
	
	@FXML
    public Button logout;
	
	@FXML
    private ImageView avatarImage;
	
	@FXML
    public Button wish;
	@FXML
    public Button shop;
	@FXML
    public Button message;

    @FXML
    public Button map;
    @FXML
    public Button codelink;
    @FXML
    public Button prodlink;
    @FXML
    public Button userlink;
    
    @FXML
    public Text tname;
    
    @FXML
    public Text tsurname;
    @FXML
    public Text tmail;
    @FXML
    public Text ttel;
    @FXML
    public Text taddress;
    @FXML
    public Text tgreencoin;
    
    @FXML
    public TextArea story;

    
    public NumberAxis xAxis = new NumberAxis(1960, 2020, 10); 
    public NumberAxis yAxis = new NumberAxis(0, 350, 50); 
    @FXML
    public LineChart chart = new LineChart(xAxis, yAxis);
    
    
    ControllerLogin cl = new  ControllerLogin();
	

	Singleton sg = Singleton.getInstance();
	AbstractUser user = sg.getUser();


	//setto l'avatar a forma di cerchio
	@FXML
    public void initialize() {
		
    	userlink.setDisable(true); 
    	story.setText(sg.getUser().getHistory().getTranList().toString());
    	//------gestione profilo utente-------

    	tname.setText(user.getName());
    	tsurname.setText(user.getSurname());
    	tmail.setText(user.getMail());
    	ttel.setText(user.getAddress().getTelephone());
    	tgreencoin.setText(Integer.toString(user.getGreenCoin()));
    	taddress.setText(user.getAddress().getAddr()+" "+user.getAddress().getPostalCode()+" "+
    	user.getAddress().getCity()+" "+user.getAddress().getState());
    	
    	
    	XYChart.Series series = new XYChart.Series(); 
    	series.setName("Greencoin graph"); 
    	

    	series.getData().add(new XYChart.Data(250, 15)); 
    	series.getData().add(new XYChart.Data(340, 30)); 
    	series.getData().add(new XYChart.Data(720, 60));     	

    	chart.getData().add(series);

    	//-------------
    	
    	
    }
	
	@FXML
    private void next(ActionEvent event) throws IOException, SQLException {
		WinNext a = new WinNext();
		StringBuilder bld = new StringBuilder();

        String eventClicked = event.getSource().toString();
        
        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=wish, styleClass=button]'Wishlist'")) {
        	//pagina wishlist
        	a.openWin("view/wishlistPage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=codelink, styleClass=button]'Activate your code!'")) {
        	//pagina activation code
        	a.openWin("view/activationcodePage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=message, styleClass=button btn-info]'MSG'")) {
        	List<Message> messages = MessageDAO.selectBroadcast();
        	messages.addAll(user.getBoards().getList());
        	for(Message m : messages) {
        		bld.append(m.getTitle() + ": " + m.getBodymessage() + "\n");
        	}
			JOptionPane.showMessageDialog(null, bld.toString());
			return;
        }
        //hyperlink----------------
        if (eventClicked.contentEquals("Button[id=maplink, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=codelink, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	a.openWin("view/activationcodePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=prodlink, styleClass=button]'Products'")) {
        	//pagina prodotti
        	a.openWin("view/productsPage.fxml");
        }
        //hyperlink----------------
        
       
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// empty
	}

}
