package controller;

import com.afjcjsbx.eshop.entity.catalogue.Product;
import com.afjcjsbx.eshop.entity.login.AbstractUser;
import com.afjcjsbx.eshop.entity.login.Guest;

public class ControllerShopCartCheckOut {
	
	public boolean addProduct(HttpServletRequest request, Product p){

		AbstractUser user = getSessionAttribute("currentSessionUser", request);

		if(user == null){
			user = new Guest();
		}


		for (int i = 0; i < user.getShoppingCart().getShoppingCartItems().size(); i++) {

			if (p.getId() == user.getShoppingCart().getShoppingCartItems().get(i).getId()) {
				return false;
			}
		}

		user.getShoppingCart().getShoppingCartItems().add(p);
		setSessionAttribute("currentSessionUser", user, request);

		return true;
	}

}
