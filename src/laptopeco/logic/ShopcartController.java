package laptopeco.logic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.Singleton;
import laptopeco.controller.ControllerShopCartCheckOut;
public class ShopcartController extends Application {

	
	@FXML
	private Button logout;
	
    @FXML
    private Button wishlist;
    @FXML
    private Button log;
    @FXML
    private Button shopcart;

    @FXML
    private Button maplinker;
    @FXML
    private Button codelinker;
    @FXML
    private Button prodlinker;
    @FXML
    private Button userlinker;
    
    @FXML
    private Button consumegcoin;
    
    @FXML
    private Text wb;
    
    @FXML
    private TextArea pricetext;
    @FXML
    private TextArea gcointext;
    @FXML
    private TextArea total;
    
    @FXML
    private StackPane stack;
    
    Singleton sg =Singleton.getInstance();
	AbstractUser user = sg.getUser();
	ControllerShopCartCheckOut csc = new ControllerShopCartCheckOut();
	StringBuilder bld = new StringBuilder();



    @Override
    public void start(Stage primaryStage) throws Exception {
    	//empty
    }

    
    private class CustomListCell extends ListCell<Product> {
        
        private ImageView imager;
        private Text namer;
        private Text greenCoinr;
        private Button delete;       
        private VBox contentt;
        private HBox maxii;        
        private Product productt;


        
        public CustomListCell() {
            super();
            namer = new Text();
            imager = new ImageView();
            imager.setFitHeight(90);
            imager.setFitWidth(90);
            greenCoinr = new Text();
            delete = new Button("remove");
            
            contentt = new VBox(namer, greenCoinr, delete);
            contentt.setAlignment(Pos.CENTER);
            contentt.setSpacing(5);
            maxii = new HBox(imager, contentt);
            maxii.setSpacing(110);
            maxii.setFillHeight(true);
            maxii.setMaxWidth(Control.USE_PREF_SIZE);
            
                        
            delete.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {              
                    try {
						csc.deleteProduct(productt.getId());
						initialize();

					} catch (SQLException e) {
						e.printStackTrace();
					}             
                }
            }); 
            
            
            
        }
        
       

        @Override
        protected void updateItem(Product product, boolean empty) {
            super.updateItem(product, empty);
            if (product != null && !empty) { // <== test for null item and empty parameter
            	this.productt = product;
                Image imageObject = new Image(product.getImage());
                imager.setImage(imageObject);
              
                namer.setText(product.getName());
                greenCoinr.setText(String.format("%d $", product.getPrice()));
                setGraphic(maxii);
            } else {
                setGraphic(null);
            }
        }
    }
    
    
    public void initialize() {
    	   	
    	for(Product p: user.getCart().getProductList()) {
    		if (bld.toString().contains(p.getName())) {
    			continue;
    		}
    		bld.append(p.getName() + ": " +p.getPrice() + "\n\n");
    	}
    	pricetext.setText(bld.toString());
    	
    	total.setText(Integer.toString(user.getCart().getTotalPrice()));
    	gcointext.setText(Integer.toString(user.getGreenCoin()));
    	shopcart.setDisable(true);
		//-----
		log.setVisible(false);
		//-----
		
		if(sg.getUser() == null) { //utente non loggato
			wb.setVisible(false);
			log.setVisible(true);
			logout.setVisible(false);
		}
		//----------------------------------------------
		ObservableList<Product> data = FXCollections.observableArrayList();
        
   

        for(Product p: sg.getUser().getCart().getProductList()) {		
        	data.add(p);
        }


        final ListView<Product> listView = new ListView<>(data);
        listView.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> listView) {
                return new CustomListCell();
            }
        });
        stack.getChildren().add(listView);
         
	}
    @FXML
    private void next(ActionEvent event) throws IOException, SQLException {
        WinNext a = new WinNext();
        ManagerClick m = new ManagerClick();
        String eventClicked = event.getSource().toString();
        String style="button";
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();

        
        //Hyperlink ------------------
        
        m.checkWarn(event, "userlinker", style, "User Profile", "view/userprofilePage.fxml", sg.getUser());

        m.goToPath(eventClicked, "maplinker", style, "Map", "view/mapPage.fxml");

        m.goToPath(eventClicked, "prodlinker", style, "Products", "view/productsPage.fxml");

        //Hyper link ------------------

        //methods buy and remove from Wishlist ----------
        if(m.check(eventClicked, "consumegcoin", style, "Buy products!")){
        		if (csc.buyShopCart()) {
        			JOptionPane.showMessageDialog(null, "Successfull purchase!");
        			Stage k = (Stage) ((Node) event.getSource()).getScene().getWindow();
                	a.openWin("view/shopcartPage.fxml");
                	k.close();
                	
        		}else {
        			JOptionPane.showMessageDialog(null, "Purchasing error");
        		}			
        	return;
        }
      //methods buy and remove from Wishlist ----------
        
        oldWin.close();
    }
    
    
    
    @FXML
    private void nextT(ActionEvent event) throws IOException, SQLException {
        ManagerClick m = new ManagerClick();
        String eventClicked = event.getSource().toString();
        String style="button";

        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();

        
        m.goToPath(eventClicked, "logout", style, "Logout", "view/login_registerPage.fxml");

        
        //Barra ----------------------
        m.checkWarn(event, "wishlist", style, "Wishlist", "view/wishlistPage.fxml", sg.getUser());
        
        m.goToPath(eventClicked, "log", style, "Login or Register", "view/login_registerPage.fxml");
       
        m.checkWarn(event, "codelinker", style, "Activation Code", "view/activationcodePage.fxml", sg.getUser());
        
        
        oldWin.close();
    }
}