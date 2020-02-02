package logic;

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
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import logic.model.AbstractUser;
import logic.model.Product;
import logic.model.Singleton;
import controller.ControllerShopCartCheckOut;
public class ShopcartController extends Application {

	
	@FXML
    public Button logout;
	
    @FXML
    public Button wish, log, shop;

    @FXML
    public Button map_link, a_code_link, prod_link, user_p_link;
    
    @FXML
    public Button consume_gcoin;
    
    @FXML
    public Text wb;
    
    @FXML
    public TextArea price_text, gcoin_text, total;
    
    @FXML
    public StackPane stack;
    
    Singleton sg =Singleton.getInstance();
	AbstractUser user = sg.getUser();
	ControllerShopCartCheckOut CSC = new ControllerShopCartCheckOut();
	
    public ShopcartController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    
    private class CustomListCell extends ListCell<Product> {
        
        private ImageView image;
        private Text name;
        private Text greenCoin;
        private Button remove;       
        private VBox content;
        private HBox maxi;        
        private Product product;
        winNext a = new winNext();


        
        public CustomListCell() {
            super();
            name = new Text();
            image = new ImageView();
            image.setFitHeight(90);
            image.setFitWidth(90);
            greenCoin = new Text();
            remove = new Button("remove");
            
            content = new VBox(name, greenCoin, remove);
            content.setAlignment(Pos.CENTER);
            content.setSpacing(5);
            maxi = new HBox(image, content);
            maxi.setSpacing(110);
            maxi.setFillHeight(true);
            maxi.setMaxWidth(Control.USE_PREF_SIZE);
            
                        
            remove.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {              
                    try {
						CSC.deleteProduct(product.getId());
						initialize();
//						Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			        	a.openWin("view/shopcartPage.fxml");
//			        	oldWin.close();
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
            	this.product = product;
                Image imageObject = new Image(product.getImage());
                image.setImage(imageObject);
              
                name.setText(product.getName());
                greenCoin.setText(String.format("%d $", product.getPrice()));
                setGraphic(maxi);
            } else {
                setGraphic(null);
            }
        }
    }
    
    
    public void initialize() {
    
    	String result = "";
    	
    	for(Product p: user.getCart().getProductList()) {
    		if (result.contains(p.getName())) {
    			continue;
    		}
    		result = result + p.getName() + ": " +p.getPrice() + "\n\n";
    	}
    	price_text.setText(result);
    	total.setText(Integer.toString(user.getCart().getTotalPrice()));
    	gcoin_text.setText(Integer.toString(user.getGreenCoin()));
    	shop.setDisable(true);
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


        final ListView<Product> listView = new ListView<Product>(data);
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
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();

        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();

        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        //Barra ----------------------
        if (eventClicked.contentEquals("Button[id=wish, styleClass=button]'Wishlist'")) {
        	//pagina carrello
        	if(sg.getUser() != null) {
            	a.openWin("view/wishlistPage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
        }
        //Barra ----------------------

        
        //Hyperlink ------------------
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	if(sg.getUser() != null) {
            	a.openWin("view/userprofilePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
        }
        if (eventClicked.contentEquals("Button[id=map_link, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login or Register'")) {
            //pagina login
        	a.openWin("view/login_registerPage.fxml");
        }  
        
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	if(sg.getUser() != null) {
            	a.openWin("view/activationcodePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
        }
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	a.openWin("view/productsPage.fxml");
        }
        //Hyper link ------------------

        //methods buy and remove from Wishlist ----------
        if (eventClicked.contentEquals("Button[id=consume_gcoin, styleClass=button]'Buy products!'")) {
        	CSC.buyShopCart();
        	//initialize();
			Stage k = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	a.openWin("view/shopcartPage.fxml");
        	k.close();
        	return;
        }
      //methods buy and remove from Wishlist ----------
        
        oldWin.close();
    }
}