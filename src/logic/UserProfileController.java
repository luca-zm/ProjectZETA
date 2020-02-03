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
	private Button logout;
	
	@FXML
	private ImageView avatarImage;
	
	@FXML
	private Button wish;
	@FXML
	private Button shop;
	@FXML
	private Button message;

    @FXML
    private Button map;
    @FXML
    private Button codelink;
    @FXML
    private Button prodlink;
    @FXML
    private Button userlink;
    
    @FXML
    private Text tname;
    
    @FXML
    private Text tsurname;
    @FXML
    private Text tmail;
    @FXML
    private Text ttel;
    @FXML
    private Text taddress;
    @FXML
    private Text tgreencoin;
    
    @FXML
    private TextArea story;

    
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
		ManagerClick m = new ManagerClick();
		StringBuilder bld = new StringBuilder();
		String style="button";
        String eventClicked = event.getSource().toString();
        
        
        m.goToPath(eventClicked, "logout", style, "Logout", "view/login_registerPage.fxml");
        
        m.goToPath(eventClicked, "shop", style, "Shopcart", "view/shopcartPage.fxml");
        
        m.goToPath(eventClicked, "wish", style, "Wishlist", "view/wishlistPage.fxml");
        
        m.goToPath(eventClicked, "codelink", style, "Activate your code!", "view/activationcodePage.fxml");

        
        if (m.check(eventClicked, "message", "button btn-info", "MSG")) {
        	List<Message> messages = MessageDAO.selectBroadcast();
        	messages.addAll(user.getBoards().getList());
        	for(Message msg : messages) {
        		bld.append(msg.getTitle() + ": " + msg.getBodymessage() + "\n");
        	}
			JOptionPane.showMessageDialog(null, bld.toString());
			return;
        }
        //hyperlink----------------
        m.goToPath(eventClicked, "maplink", style, "Map", "view/mapPage.fxml");

        m.goToPath(eventClicked, "codelink", style, "Activation Code", "view/activationcodePage.fxml");

        m.goToPath(eventClicked, "prodlink", style, "Products", "view/productsPage.fxml");

        //hyperlink----------------
        
       
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// empty
	}

}
