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
import java.util.List;

import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.Singleton;
import laptopeco.logic.persistence.ProductDAO;
import laptopeco.logic.persistence.WishListDAO;
import javax.swing.*;

import laptopeco.ExceptionEco.DuplicateWishElement;
import laptopeco.controller.ControllerLogin;
import laptopeco.controller.ControllerShopCartCheckOut;
import laptopeco.controller.ControllerWishList;

public class ProductsController extends Application {

	
	@FXML
    public Button logout;
	
    @FXML
    public Button userp;
    @FXML
    public Button wishlist;
    @FXML
    public Button shopProd;
    @FXML
    public Button logProd;

    @FXML
    public Button mapProd;
    @FXML
    public Button codelinkProd;
    @FXML
    public Button prodlinkProd;
    @FXML
    public Button userlinkProd;
    
    
    
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
    
        private ImageView imageProd;
        private Text nameProd;
        private Text greenCoinProd;
        private Button cart;
        private Button wish;
        private Button info;
        private HBox cartWish;
        private VBox content;
        private HBox maxiProd;
        
        private Product product;
        
        WinNext a = new WinNext();

        
        public CustomListCell() {
            super();
            nameProd = new Text();
            imageProd = new ImageView();
            imageProd.setFitHeight(125);
            imageProd.setFitWidth(125);
            greenCoinProd = new Text();
            cart = new Button("Add to cart");
            wish = new Button("Add to wishlist");
            info = new Button("i");  
            cartWish = new HBox(cart, wish);
            cartWish.setSpacing(3);
            content = new VBox(nameProd, greenCoinProd, cartWish);
            info.setAlignment(Pos.CENTER_RIGHT);
            content.setAlignment(Pos.CENTER);
            content.setSpacing(5);
            maxiProd = new HBox(imageProd, content, info);
            maxiProd.setSpacing(100);
            maxiProd.setFillHeight(true);
            maxiProd.setMaxWidth(Control.USE_PREF_SIZE);
            
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
                    		throw new DuplicateWishElement();
                    	}else {
                    		cwl.addProductinWishList(product.getId());
                    	}
					} catch (DuplicateWishElement | SQLException e) {
            			JOptionPane.showMessageDialog(null, e.toString() + " " +sg.getUser().getName());

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
                imageProd.setImage(imageObject);
              
                nameProd.setText(product.getName());
                greenCoinProd.setText(String.format("%d $", product.getPrice()));
                setGraphic(maxiProd);
            } else {
                setGraphic(null);
            }
        }
    }
    

    
    
	@FXML
	public void initialize() throws SQLException {
		
		prodlinkProd.setDisable(true);
		AbstractUser user = sg.getUser();
		
		//-----
		logProd.setVisible(false);

		//-----
		
		if(user == null) { //utente non loggato
			wb.setVisible(false);
			logProd.setVisible(true);
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
        


        if (eventClicked.contentEquals("Button[id=userlinkProd, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	if(sg.getUser() != null) {
        		a.openWin("view/userprofilePage.fxml");
        	}else {
        		a.openWarning(oldWin);
        		return;
        	}	
        }
        
        
        if (eventClicked.contentEquals("Button[id=mapProd, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=codelinkProd, styleClass=button]'Activation Code'")) {
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
        
        
        
        if (eventClicked.contentEquals("Button[id=logProd, styleClass=button]'Login or Register'")) {
            //pagina login
        	a.openWin("view/login_registerPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        
        
        if (eventClicked.contentEquals("Button[id=shopProd, styleClass=button]'Shopcart'")) {
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