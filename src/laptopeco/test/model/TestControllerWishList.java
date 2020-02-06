package laptopeco.test.model;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import laptopeco.controller.ControllerWishList;
import laptopeco.logic.enums.Category;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.FactoryUsers;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.Singleton;
import laptopeco.logic.model.WishList;

public class TestControllerWishList {
	private ControllerWishList controller = new ControllerWishList();
	Singleton sg = Singleton.getInstance();
	AbstractUser user = FactoryUsers.get(0, "name", "surn", "pass", "mail", "USER");
   
	//Products for testing. They depends by database data
	Product prod1 = new Product(267, "guanti", 80, 0, Category.UTILITY, ".\\img\\1.jpg", "guanti eco");
	Product prod2 = new Product(342, "zaino", 80, 0, Category.UTILITY, ".\\img\\2.jpg", "zaino eco");
	Product prod3 = new Product(3535, "borraccia", 80, 0, Category.UTILITY, ".\\img\\3.jpg", "borraccia eco");
	
    @Test
    public void testAddProductWishListDef() throws SQLException{
    	sg.setUser(user);
    	
    	int prodId = prod1.getId();
    	user.setWishList(new WishList(new ArrayList<Product>()));
    	
        //A new product is inserted
    	controller.addProductinWishList(prodId);

    	Boolean verif = false;
    	for(Product wishP : user.getWishList().getList())
    	{
    		if(wishP.getName().contentEquals(prod1.getName())) {
    			verif = true;
    		}
    	}
        assertEquals(verif, true);
    }
    
    @Test
    public void testAddProductWishListMultiple() throws SQLException{
    	sg.setUser(user);
    	user.setWishList(new WishList(new ArrayList<Product>()));

    	int p1 = prod1.getId();
    	int p2 = prod2.getId();

    	//Add a list of products
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(p1);
    	list.add(p2);
    	
    	System.out.println(list);
    	for(int i : list) {
    		controller.addProductinWishList(i);
    	}

    	List<Product> listUser = user.getWishList().getList();
    	Boolean verif = true;	
    	
    	for(Product p: listUser) {
    		if(p.getName().equals(prod1.getName()) || p.getName().equals(prod2.getName())) {
    		}
    		else {
    			verif = false;
    			break;
    		}
    	}
        assertEquals(verif, true);
    }


    @Test
	public void testDeleteProductfromWishListDefault() throws SQLException {
		sg.setUser(user);
    	user.setWishList(new WishList(new ArrayList<Product>()));

    	int p1 = prod1.getId();
		
    	controller.deleteProductfromWishList(p1);
    	
    	Boolean verif = true;
    	for(Product p: user.getWishList().getList())
    	{
    		if(p == prod1) {
    			verif = false;
    		}
    	}
        assertEquals(verif, true);
    }

}