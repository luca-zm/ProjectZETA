package logic.model;
import logic.enums.Roles;

import static logic.enums.Roles.USER;

public class User extends AbstractUser {

	public User(int id, String mail, String name, String surname, String pass) {
		super(id, mail, name, surname, pass, Roles.USER);	
	}
	
	@Override
	public Roles getType() {
		return USER;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail=" + mail + ", type=" + type
				+ ", cart=" + cart + ", history=" + history + ", boards=" + boards + ", greenCoin=" + greenCoin + "]";
	}
	


/**
	// Gain greenCoin
	public void addGreenCoin(int coin) {
		this.greenCoin += coin;

	}


	//Buy a product
	public Boolean buyProduct(Product product) {
		// GreenCoin user are insufficient
		if(product.getPrice() > this.greenCoin) {
			return false;
		}
		
		// ADD some code to send the product bought by user
		this.greenCoin -= product.getPrice();
		return true;
	}
	
	
	
	// Buy All cart 
	public Boolean buyCart() {
		if(this.cart.getTotalPrice() > this.greenCoin) {
			return false;
		}
		for(Product product: this.cart.getProductList()) {
			this.greenCoin -= product.getPrice();
		}
		return true;
	}**/
	

}
