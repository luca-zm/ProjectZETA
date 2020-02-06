package laptopeco.test.model;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import laptopeco.controller.ControllerWishList;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.FactoryUsers;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.Singleton;
import laptopeco.logic.persistence.ProductDAO;

public class TestControllerWishList {
	private ControllerWishList controller = new ControllerWishList();
	Singleton sg = Singleton.getInstance();
	AbstractUser user = FactoryUsers.get(0, "name", "surn", "pass", "mail", "USER");
    int prodId = 267;
	int p1 = 267;
	int p2 = 342;
	int p3 = 3535;

	
	
    @Test
    public void testAddProductWishListDef() throws SQLException{
    	sg.setUser(user);
    	
        //A new product is inserted
    	controller.addProductinWishList(prodId);
    	
    	Product p = ProductDAO.selectProduct(prodId);
    	Boolean verif = false;
    	for(Product wishP : user.getWishList().getList())
    	{
    		if(wishP == p) {
    			verif = true;
    		}
    	}
        assertEquals(verif, true);
    }
    
    @Test
    public void testAddProductWishListMultiple() throws SQLException{
    	sg.setUser(user);

    	//Add a list of products
    	int[] list = {p1, p2, p3};
    	for(int i : list) {
    		controller.addProductinWishList(i);
    	}

    	List<Product> listUser = user.getWishList().getList();
    	Boolean verif = true;
    	
    	
    	//Verify if products are in WishList of User
    	List<Product> listProduct = listProd(p1, p2, p3);
    	for(Product p: listUser) {
    		if(p != listProduct.get(0) && p!= listProduct.get(1) && p != listProduct.get(2)) {
    			verif = false;
    			break;
    		}
    	}    	
    		
        assertEquals(verif, true);
    }


    @Test
	public void testDeleteProductfromWishListDefault() throws SQLException {
		sg.setUser(user);
		
    	controller.deleteProductfromWishList(p1);
    	
    	Product prod1 = ProductDAO.selectProduct(p1);
    	Boolean verif = true;
    	for(Product p: user.getWishList().getList())
    	{
    		if(p == prod1) {
    			verif = false;
    		}
    	}
        assertEquals(verif, true);
    }
	
	private List<Product> listProd(int p1, int p2, int p3) throws SQLException{
		Product prod1 = ProductDAO.selectProduct(p1);
		Product prod2 = ProductDAO.selectProduct(p2);
		Product prod3 = ProductDAO.selectProduct(p3);
        List<Product> list = new ArrayList<>();
        list.add(prod1);
        list.add(prod2);
        list.add(prod3);
        return list;
	}

}