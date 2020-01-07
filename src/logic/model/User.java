package logic.model;
import logic.enums.Roles;

import static logic.enums.Roles.USER;

public class User extends AbstractUser {
	private ShopCart cart;
	private History history;
	private NoticeBoard boards;
	private int greenCoin;
	
	public User(String mail, String name, String username, String pass, int greenCoin, ShopCart cart, History history, NoticeBoard boards) {
		super(mail, name, username, pass, Roles.USER);
		this.cart = cart;
		this.boards = boards;
		this.history = history;
		this.greenCoin = greenCoin;	
	}
	
	
	public Roles getType() {return USER;}
	
	

	public ShopCart getCart() {
		return cart;
	}


	public void setCart(ShopCart cart) {
		this.cart = cart;
	}


	public History getHistory() {
		return history;
	}


	public void setHistory(History history) {
		this.history = history;
	}


	public NoticeBoard getBoards() {
		return boards;
	}


	public void setBoards(NoticeBoard boards) {
		this.boards = boards;
	}


	public int getGreenCoin() {
		return greenCoin;
	}


	public void setGreenCoin(int greenCoin) {
		this.greenCoin = greenCoin;
	}


	@Override
	public String toString() {
		return "User [cart=" + cart + ", history=" + history + ", boards=" + boards + ", greenCoin=" + greenCoin + "]";
	}


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
	}
	

}
