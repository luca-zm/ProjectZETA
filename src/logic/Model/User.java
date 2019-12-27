package logic.Model;

public class User extends AbstractUser {
	private ShopCart cart;
	private History history;
	private NoticeBoard boards;
	private int greenCoin;
	
	
	public User(String name, String username, String pass, String mail, ShopCart cart, int greenCoin, History history, NoticeBoard boards) {
		super(name, username, pass, mail);
		this.cart = cart;
		this.boards = boards;
		this.history = history;
		this.greenCoin = greenCoin;
		this.role = 3;	
	}

	@Override
	public String toString() {
		return "User [cart=" + cart + ", history=" + history + ", greenCoin=" + greenCoin + ", name=" + name
				+ ", username=" + username + ", pass=" + pass + ", role=" + role + ", mail=" + mail + "]";
	}
	
	
	// Gain greenCoin
	public void addGreenCoin(int coin) {
		this.greenCoin += coin;
	    this.history.AddLearnTran("00/00/0000", coin);
	}


	//Buy a product
	public Boolean buyProduct(Product product) {
		// GreenCoin user are insufficient
		if(product.getPrice() > this.greenCoin) {
			return false;
		}
		
		// ADD some code to send the product bought by user
		this.greenCoin -= product.getPrice();
		this.history.AddSpendTran("00/00/0000", product);
		return true;
	}
	
	
	
	// Buy All cart 
	public Boolean buyCart() {
		if(this.cart.getTotalPrice() > this.greenCoin) {
			return false;
		}
		for(Product product: this.cart.getProductList()) {
			this.greenCoin -= product.getPrice();
			this.history.AddSpendTran("00/00/0000", product);
		}
		this.cart.clear();
		return true;
	}
	

}