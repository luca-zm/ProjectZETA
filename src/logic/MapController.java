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
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.model.Singleton;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MapController extends Application implements ActionListener{

    @FXML
    public Button wishlist, shop, log;

    @FXML
    public Button map_link, a_code_link, prod_link, user_p_link;
    
    @FXML
    public Text wb;
    
    Singleton sg = Singleton.getInstance(); 

    @FXML
    public Label mapHolder;
    
    @FXML
    public Pane panel_map;
    
    
    
    public MapController() { 
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
    }
    
	@FXML
	public void initialize() throws IOException {
		URL mapUrl = new URL("https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284&key=AIzaSyDWaK_dXLPOBO43oLeAkMTrgkh-6qSlnuc");
        BufferedImage mapImage = ImageIO.read(mapUrl);
        
        
        final JFrame frame = new JFrame("Esempio Static Google Maps");
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new BorderLayout());
        final JTextField searchText = new JTextField("Roma");
        JButton searchButton = new JButton("Cerca");
        final JLabel mapHolder = new JLabel(new ImageIcon(mapImage));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String mapUrlFormat = "https://maps.googleapis.com/maps/api/staticmap?center=%s&zoom=8&size=300x300&maptype=roadmap";
                try {
                    URL mapUrl = new URL(String.format(mapUrlFormat, URLEncoder.encode(searchText.getText())));
                    BufferedImage mapImage = ImageIO.read(mapUrl);
                    mapHolder.setIcon(new ImageIcon(mapImage));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }

			
        });
        controlsPanel.add(searchText, BorderLayout.CENTER);
        controlsPanel.add(searchButton, BorderLayout.LINE_END);
        
        JPanel framePanel = new JPanel();
        framePanel.setLayout(new BorderLayout());
        framePanel.add(controlsPanel, BorderLayout.NORTH);
        framePanel.add(mapHolder, BorderLayout.CENTER);
        frame.setContentPane(framePanel);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        
        
        
        
        
		map_link.setDisable(true);
		//-----
		log.setVisible(false);
		
		//-----
		
		if(sg.getUser() == null) { //utente non loggato
			wb.setVisible(false);
			log.setVisible(true);
		}
	}

    @FXML
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        
       
        
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
