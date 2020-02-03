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
import java.util.List;

import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import logic.model.AbstractUser;
import logic.model.Product;
import logic.model.Singleton;
import logic.persistence.ProductDAO;
import logic.persistence.WishListDAO;
import javax.swing.*;
import controller.ControllerLogin;
import controller.ControllerShopCartCheckOut;
import controller.ControllerWishList;

public class ProductsController extends Application {

	
	@FXML
	private Button logout;
	
    @FXML
    private Button userp;
    @FXML
    private Button wishlist;
    @FXML
    private Button shop;
    @FXML
    private Button log;

    @FXML
    private Button map;
    @FXML
    private Button codelink;
    @FXML
    private Button prodlink;
    @FXML
    private Button userlink;
    
    
    
    @FXML
    public Text wb;
    
    @FXML
    public StackPane base;
    

    //-----------------
    
    Singleton sg = Singleton.getInstance(); 
    ControllerLogin cl = new  ControllerLogin();
    ControllerShopCartCheckOut csc = new ControllerShopCartCheckOut();
    ControllerWishList cwl = new ControllerWishList();
    

    @Override
    public void start(Stage primaryStage) throws Exception {
    	//empty
    }
    
    
    private class CustomListCell extends ListCell<Product> {
    
        private ImageView image;
        private Text name;
        private Text greenCoin;
        private Button cart;
        private Button wish;
        private Button info;
        private HBox cartWish;
        private VBox content;
        private HBox maxi;
        
        private Product product;
        
        WinNext a = new WinNext();

        
        public CustomListCell() {
            super();
            name = new Text();
            image = new ImageView();
            image.setFitHeight(125);
            image.setFitWidth(125);
            greenCoin = new Text();
            cart = new Button("Add to cart");
            wish = new Button("Add to wishlist");
            info = new Button("i");  
            cartWish = new HBox(cart, wish);
            cartWish.setSpacing(3);
            content = new VBox(name, greenCoin, cartWish);
            info.setAlignment(Pos.CENTER_RIGHT);
            content.setAlignment(Pos.CENTER);
            content.setSpacing(5);
            maxi = new HBox(image, content, info);
            maxi.setSpacing(100);
            maxi.setFillHeight(true);
            maxi.setMaxWidth(Control.USE_PREF_SIZE);
            
            if(sg.getUser() == null) {
            	wish.setDisable(true);
            	cart.setDisable(true);
            	logout.setVisible(false);
            }
            
            cart.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {              
                    try {
						csc.addProduct(product.getId());
					} catch (SQLException e) {
						e.printStackTrace();
					}             
                }
            }); 
            
            wish.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {              
                    try {
                    	if (WishListDAO.checkProductByName(product.getId())) {
                			JOptionPane.showMessageDialog(null, "Product is already in your wishlist "+ sg.getUser().getName());

                    	}else {
                    		cwl.addProductinWishList(product.getId());
                    	}
					} catch (SQLException e) {
						e.printStackTrace();
					}
                }
            }); 
            
            info.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {              
                	try {
                		Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
						a.openWinInfo("view/info.fxml", product);
						oldWin.close();
					} catch (IOException e) {
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
		
		prodlink.setDisable(true);
		AbstractUser user = sg.getUser();
		
		//-----
		log.setVisible(false);

		//-----
		
		if(user == null) { //utente non loggato
			wb.setVisible(false);
			log.setVisible(true);
		}else {
			wb.setText(user.getName());
		}
		
        ObservableList<Product> data = FXCollections.observableArrayList();
        
        List<Product> list = ProductDAO.select();

        for(Product p: list) {		
        	data.add(p);
        }


        final ListView<Product> listView = new ListView<>(data);
        listView.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> listView) {
                return new CustomListCell();
            }
        });
        base.getChildren().add(listView);
	}

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
        
        
        if (eventClicked.contentEquals("Button[id=maplink, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
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
               
        
        oldWin.close();
    }
    
    
    
    
    
    @FXML
    private void nextT(ActionEvent event) throws IOException {
        WinNext a = new WinNext();
        
        String eventClicked = event.getSource().toString();
        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        
        
        if (eventClicked.contentEquals("Button[id=log, styleClass=button]'Login or Register'")) {
            //pagina login
        	a.openWin("view/login_registerPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	if(sg.getUser() != null) {
            	a.openWin("view/shopcartPage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}
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
}



