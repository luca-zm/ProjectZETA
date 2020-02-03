package logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
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
    public Button wishlist;
    
    @FXML
    public Button shop;

    @FXML
    public Button log;

    @FXML
    public Button maplink;
    @FXML
    public Button codelink;
    @FXML
    public Button prodlink;
    @FXML
    public Button userlink;
    
    @FXML
    public Text wb;
    
    @FXML
    public TextArea maptext;
    
    Singleton sg = Singleton.getInstance(); 
    StringBuilder bld = new StringBuilder();

    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
    	//empty
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
        
        maptext.setEditable(false);
        
        List<CollectionPoint> list = CollectionPointDAO.select();
        
        int count = 1;
        for(CollectionPoint point: list) {
        	bld.append(Integer.toString(count) + " " +  point.getName() + ": " + point.getAddress() + " (hours of service: " + point.getOpeningTime() + " - " + point.getClosingTime() + ")\n\n");
        	count += 1;
        }
        
        maptext.setText(bld.toString());
        
		maplink.setDisable(true);
		//-----
		log.setVisible(false);
		
		//-----
		
		if(sg.getUser() == null) { //utente non loggato
			wb.setVisible(false);
			log.setVisible(true);
			logout.setVisible(false);
		}
		
		
	}

	
	//navbar top
	 @FXML
	 private void nextT(ActionEvent event) throws IOException {
	        WinNext a = new WinNext();
	        
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
	
	        
	        oldWin.close();
	 }
	
	
	
	
	
	//navbar left
    @FXML
    private void next(ActionEvent event) throws IOException {
        WinNext a = new WinNext();
        
        String eventClicked = event.getSource().toString();
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        
        
        
        
        if (eventClicked.contentEquals("Button[id=userlink, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	if(sg.getUser() != null) {
        		a.openWin("view/userprofilePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}	
        }
        
                
        
        if (eventClicked.contentEquals("Button[id=codelink, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	if(sg.getUser() != null) {
            	a.openWin("view/activationcodePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}        
        }
               
        
        
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login or Register'")) {
            //pagina login
        	a.openWin("view/login_registerPage.fxml");
        }    
        
        
        
        if (eventClicked.contentEquals("Button[id=prodlink, styleClass=button]'Products'")) {
        	//pagina prodotti
        	a.openWin("view/productsPage.fxml");
        }
        
        oldWin.close();
    }

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// empty
		
	}
}
