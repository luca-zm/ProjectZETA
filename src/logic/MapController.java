package logic;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.model.CollectionPoint;
import logic.model.Singleton;
import logic.persistence.CollectionPointDAO;

import javax.imageio.ImageIO;
import javax.swing.*;
import controller.ControllerManageCollPoint;

public class MapController extends Application implements ActionListener{
	
	
	ControllerManageCollPoint c = new ControllerManageCollPoint();

	
	@FXML
    public Button logout;
	
    @FXML
    public Button wishlist, shop, log;

    @FXML
    public Button map_link, a_code_link, prod_link, user_p_link;
    
    @FXML
    public Text wb;
    
    @FXML
    public TextArea map_text;
    
    Singleton sg = Singleton.getInstance(); 

    @FXML
    public Label mapHolder;
    
    
    public MapController() { 
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
    }
    
	@FXML
	public void initialize() throws IOException, SQLException {
		URL mapUrl = c.startUrl();
        BufferedImage mapImage = ImageIO.read(mapUrl);
        
        
        final JFrame frame = new JFrame("Esempio Static Google Maps");
        
        final JLabel mapHolder = new JLabel(new ImageIcon(mapImage));
        
        JPanel framePanel = new JPanel();
        framePanel.add(mapHolder);
        frame.setContentPane(framePanel);
        
        frame.pack();
        frame.setVisible(true);
        
        System.out.println(map_text);
        map_text.setEditable(false);
        
        ArrayList<CollectionPoint> list = CollectionPointDAO.select();
        
        String string = "";
        int count = 1;
        for(CollectionPoint point: list) {
        	string = string + Integer.toString(count) + " " +  point.getName() + ": " + point.getAddress() + " (hours of service: " + point.getOpeningTime() + " - " + point.getClosingTime() + ")\n\n";
        	count += 1;
        }
        
        map_text.setText(string);
        
		map_link.setDisable(true);
		//-----
		log.setVisible(false);
		
		//-----
		
		if(sg.getUser() == null) { //utente non loggato
			wb.setVisible(false);
			log.setVisible(true);
			logout.setVisible(false);
		}
		
		
	}

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=wishlist, styleClass=button]'Wishlist'")) {
        	//pagina wishlist
        	if(sg.getUser() != null) {
        		a.openWin("view/wishlistPage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
        }
        
        
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	if(sg.getUser() != null) {
        		a.openWin("view/userprofilePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}	
        }
        
                
        
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	if(sg.getUser() != null) {
            	a.openWin("view/activationcodePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}        }
               
        
        
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login or Register'")) {
            //pagina login
        	a.openWin("view/login_registerPage.fxml");
        }    
        
        
        
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	//pagina prodotti
        	a.openWin("view/productsPage.fxml");
        }
        
        oldWin.close();
    }

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
