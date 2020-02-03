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
import logic.persistence.WishListDAO;
import controller.ControllerShopCartCheckOut;
import controller.ControllerWishList;

public class WishlistController extends Application {

	
	
	@FXML
    public Button logout;
	
    @FXML
    public Button shop;

    @FXML
    public Button maplink;
    @FXML
    public Button codelink;
    @FXML
    public Button prodlink;
    @FXML
    public Button userlink;
    @FXML
    public Button wish;
    
    @FXML
    public Button buy;
    @FXML
    public Button del;
    
    @FXML
    public Text wb;
    
    @FXML
    public StackPane stack;
    
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
        winNext a = new winNext();
        
        String eventClicked = event.getSource().toString();
        
        if (eventClicked.contentEquals("Button[id=logout, styleClass=button]'Logout'")) {
			a.openWin("view/login_registerPage.fxml");
        }
        //Barra ----------------------
        if (eventClicked.contentEquals("Button[id=shop, styleClass=button]'Shopcart'")) {
        	//pagina carrello
        	a.openWin("view/shopcartPage.fxml");
        }
        //Barra ----------------------

        
        //Hyperlink ------------------
        if (eventClicked.contentEquals("Button[id=userlink, styleClass=button]'User Profile'")) {
        	//pagina del profilo utente
        	a.openWin("view/userprofilePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=maplink, styleClass=button]'Map'")) {
        	//pagina mappe
        	a.openWin("view/mapPage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=codelink, styleClass=button]'Activation Code'")) {
        	//pagina activation code
        	a.openWin("view/activationcodePage.fxml");
        }
        if (eventClicked.contentEquals("Button[id=prodlink, styleClass=button]'Products'")) {
        	a.openWin("view/productsPage.fxml");
        }
        //Hyper link ------------------

        
        Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        oldWin.close();
    }
}
