package logic.Model;

public class User extends AbstractUser {
	private ShopCart cart;
	private History history;
	//private MessageBoards boards;
	private int greenCoin;
	
	
	public User(String name, String username, String pass, String mail, ShopCart cart, int greenCoin, History history, MessageBoards boards) {
		super(name, username, pass, mail);
		this.cart = cart;
		//this.boards = boards;
		this.history = history;
		this.greenCoin = greenCoin;
		this.role = 3;	
	}
	
	


	public History getHistory() {
		return history;
	}




	public void setHistory(History history) {
		this.history = history;
	}




	public ShopCart getCart() {
		return cart;
	}




	public int getGreenCoin() {
		return greenCoin;
	}




	@Override
	public String toString() {
		return "User [cart=" + cart + ", history=" + history + ", greenCoin=" + greenCoin + ", name=" + name
				+ ", username=" + username + ", pass=" + pass + ", role=" + role + ", mail=" + mail + "]";
	}
	
	
	// Gain greenCoin
	public void addGreenCoin(int coin) {
		this.greenCoin += coin;
	}


	//Spend GreenCoin
	public Boolean spendGreenCoin(int coin) {
		// GreenCoin user are insufficient
		if(coin > this.greenCoin) {
			return false;
		}
		
		this.greenCoin -= coin;
		return true;
	}
	

}