package laptopeco.logic;

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
import laptopeco.logic.model.CollectionPoint;
import laptopeco.logic.model.Singleton;
import laptopeco.logic.persistence.CollectionPointDAO;
import javax.imageio.ImageIO;
import javax.swing.*;
import laptopeco.controller.ControllerManageCollPoint;

public class MapController extends Application implements ActionListener{
	
	
	ControllerManageCollPoint c = new ControllerManageCollPoint();

	
	@FXML
	private Button logout;
	
    @FXML
    private Button wishlist;
    
    @FXML
    private Button shop;

    @FXML
    private Button log;

    @FXML
    private Button maplink;
    @FXML
    private Button codelink;
    @FXML
    private Button prodlink;
    @FXML
    private Button userlink;
    
    @FXML
    private Text wb;
    
    @FXML
    private TextArea maptext;
    
    Singleton sg = Singleton.getInstance(); 
    StringBuilder bld = new StringBuilder();

    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
    	//empty
    }
    
	@FXML
	public void initialize() throws IOException, SQLException {
		log.setVisible(false);
		
		//-----
		
		if(sg.getUser() == null) { //utente non loggato
			wb.setVisible(false);
			log.setVisible(true);
			logout.setVisible(false);
		}
		
        List<CollectionPoint> list = CollectionPointDAO.select();
		if(list.size() > 4) {
			JOptionPane.showMessageDialog(null, "You can't visualize the map !");
			return;
		}
		
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
        
        int count = 1;
        for(CollectionPoint point: list) {
        	bld.append(Integer.toString(count) + " " +  point.getName() + ": " + point.getAddress() + " (hours of service: " + point.getOpeningTime() + " - " + point.getClosingTime() + ")\n\n");
        	count += 1;
        }
        
        maptext.setText(bld.toString());
        
		maplink.setDisable(true);
		//-----

		
		
	}

	
	//navbar top
	 @FXML
	 private void nextT(ActionEvent event) throws IOException {
	        ManagerClick m = new ManagerClick();
	        String style="button";
	        String eventClicked = event.getSource().toString();
	        
	        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
	
	        m.goToPath(eventClicked, "logout", style, "Logout", "view/login_registerPage.fxml");

	        m.goToPath(eventClicked, "shop", style, "Shopcart", "view/shopcartPage.fxml");
      
	        m.checkWarn(event, "wishlist", style, "Wishlist", "view/wishlistPage.fxml", sg.getUser());

	        oldWin.close();
	 }
	
	
	
	
	
	//navbar left
    @FXML
    private void next(ActionEvent event) throws IOException {
        ManagerClick m = new ManagerClick();

        String eventClicked = event.getSource().toString();
        String style="button";

        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        
        m.checkWarn(event, "userlink", style, "User Profile", "view/userprofilePage.fxml", sg.getUser());
              
        m.checkWarn(event, "codelink", style, "Activation Code", "view/activationcodePage.fxml", sg.getUser());
   
        m.goToPath(eventClicked, "log", style, "Login or Register", "view/login_registerPage.fxml");

        m.goToPath(eventClicked, "prodlink", style, "Products", "view/productsPage.fxml");
        
        oldWin.close();
    }

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// empty
		
	}
}
