package logic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import logic.model.AbstractUser;
import logic.model.Product;
import logic.model.Singleton;
import logic.persistence.ProductDAO;
import logic.persistence.WishListDAO;

import javax.swing.*;

import controller.ControllerShopCartCheckOut;
import controller.ControllerWishList;

public class WishlistController extends Application {

    @FXML
    public Button shop;

    @FXML
    public Button map_link, a_code_link, prod_link, user_p_link, wish;
    
    @FXML
    public Button buy, del;
    
    @FXML
    public Text wb;
    
    @FXML
    public StackPane stack;
    
    Singleton sg = Singleton.getInstance(); 
    ControllerWishList CWL = new ControllerWishList();
    ControllerShopCartCheckOut CSC = new ControllerShopCartCheckOut();
    
    public WishlistController() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }
    
    
    
    private class CustomListCell extends ListCell<Product> {
        
        private ImageView image;
        private Text name;
        private Text greenCoin;
        private Button cart;
        private Button remove;
        
        private VBox content;
        private VBox content2;

        private HBox maxi;
        
        private Product product;
        
        winNext a = new winNext();

        
        public CustomListCell() {
            super();
            name = new Text();
            
            image = new ImageView();
            image.setFitHeight(60);
            image.setFitWidth(60);
            
            greenCoin = new Text();
            
            cart = new Button("Add to cart");
            
            remove = new Button("Remove");
            
            content = new VBox(name, greenCoin);
            content.setAlignment(Pos.CENTER);
            content.setSpacing(5);
            
            content2 = new VBox(cart, remove);
            content2.setAlignment(Pos.CENTER);
            content2.setSpacing(5);
            
            maxi = new HBox(image, content, content2);
            maxi.setSpacing(100);
            maxi.setFillHeight(true);
            maxi.setMaxWidth(Control.USE_PREF_SIZE);
            
            if(sg.getUser() == null) {
            	cart.setDisable(true);
            }
            
            cart.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {              
                    try {
						CSC.addProduct(product.getId());
						CWL.deleteProductfromWishList(product.getId());
						initialize();
						//Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
			        	//a.openWin("view/wishlistPage.fxml");
			        	//oldWin.close();
					} catch (SQLException e ) {
						e.printStackTrace();
					}             
                }
            }); 
            
            remove.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {              
                    try {
						CWL.deleteProductfromWishList(product.getId());
						initialize();

//						Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			        	a.openWin("view/wishlistPage.fxml");
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
   
    
    @FXML
	public void initialize() throws SQLException {
		wish.setDisable(true);
		AbstractUser user = sg.getUser();

//---------------------------------------------
	
        ObservableList<Product> data = FXCollections.observableArrayList();
        
        ArrayList<Product> list = WishListDAO.select(user);

        for(Product p: list) {	
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
    private void next(ActionEvent event) throws IOException {
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        System.out.println(eventClicked);
        
        //Barra ----------------------
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        //Barra ----------------------

        
        //Hyperlink ------------------
        if (eventClicked.contentEquals("Button[id=user_p_link, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	a.openWin("view/userprofilePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=map_link, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=a_code_link, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	a.openWin("view/activationcodePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=prod_link, styleClass=button]'Products'")) {
        	a.openWin("view/productsPage.fxml");
        }
        //Hyper link ------------------

        //methods buy and remove from Wishlist ----------
        if (eventClicked.contentEquals("Button[id=buy, styleClass=button]'Buy'")) {
        	//metodo buy, aggiunge al carrello da wishlist
        }
        if (eventClicked.contentEquals("Button[id=del, styleClass=button]'Remove from wishlist'")) {
        	//metodo remove from wishlist, rimuove elemento da wishlist
        }
      //methods buy and remove from Wishlist ----------
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
