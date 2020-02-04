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
import laptopeco.logic.persistence.WishListDAO;
import laptopeco.controller.ControllerShopCartCheckOut;
import laptopeco.controller.ControllerWishList;

public class WishlistController extends Application {

	
	
	@FXML
	private Button logout;
	
    @FXML
    private Button shop;

    @FXML
    private Button maplink;
    @FXML
    private Button codelink;
    @FXML
    private Button prodlink;
    @FXML
    private Button userlink;
    @FXML
    private Button wish;
    
    @FXML
    private Button buy;
    @FXML
    private Button del;
    
    @FXML
    private Text wb;
    
    @FXML
    private StackPane stack;
    
    Singleton sg = Singleton.getInstance(); 
    ControllerWishList cwl = new ControllerWishList();
    ControllerShopCartCheckOut csc = new ControllerShopCartCheckOut();
    


    @Override
    public void start(Stage primaryStage) throws Exception {
    	//empty
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
						csc.addProduct(product.getId());
						cwl.deleteProductfromWishList(product.getId());
						initialize();

					} catch (SQLException e ) {
						e.printStackTrace();
					}             
                }
            }); 
            
            remove.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {              
                    try {
						cwl.deleteProductfromWishList(product.getId());
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
        
        List<Product> list = WishListDAO.select(user);

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
        stack.getChildren().add(listView);
	}

    @FXML
    private void next(ActionEvent event) throws IOException {
        ManagerClick m = new ManagerClick();
        String style ="button";
        String eventClicked = event.getSource().toString();
        
        m.goToPath(eventClicked, "logout", style, "Logout", "view/login_registerPage.fxml");
        
        //Barra ----------------------
        m.goToPath(eventClicked, "shop", style, "Shopcart", "view/shopcartPage.fxml");
        //Barra ----------------------

        
        //Hyperlink ------------------
        m.goToPath(eventClicked, "userlink", style, "User Profile", "view/userprofilePage.fxml");

        m.goToPath(eventClicked, "maplink", style, "Map", "view/mapPage.fxml");

        m.goToPath(eventClicked, "codelink", style, "Activation Code", "view/activationcodePage.fxml");

        m.goToPath(eventClicked, "prodlink", style, "Products", "view/productsPage.fxml");
        //Hyper link ------------------

        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
