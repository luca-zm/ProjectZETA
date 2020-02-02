package logic.model;

import logic.enums.Roles;

public abstract class AbstractUser {
	protected  int id;
	protected String name;
	protected String surname;
	protected String pass;
	protected String mail;
	protected Roles type;
	protected ShopCart cart;
	protected WishList wishList;
	protected History history;
	protected NoticeBoard boards;
	protected int greenCoin;
    protected Address address;

	public AbstractUser(int id, String mail, String name, String surname, String pass,  Roles type) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.pass = pass;
		this.mail = mail;
		this.type = type;
		this.cart = new ShopCart();
		this.wishList = null;
		this.history = null;
		this.boards = null;
		this.greenCoin = 0;
		this.address = null;
	} 
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Roles getType() {
		return type;
	}
	
	public void setType(Roles type) {
        this.type = type;
    }
	
	
	 public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return surname;
	}


	public void setUsername(String username) {
		this.surname = username;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public ShopCart getCart() {
		return cart;
	}



	public void setCart(ShopCart cart) {
		this.cart = cart;
	}
	
	



	public WishList getWishList() {
		return wishList;
	}



	public void setWishList(WishList wishList) {
		this.wishList = wishList;
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



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "AbstractUser [id=" + id + ", name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail="
				+ mail + ", type=" + type + ", cart=" + cart + ", wishList=" + wishList + ", history=" + history
				+ ", boards=" + boards + ", greenCoin=" + greenCoin + ", address=" + address;
	}

//
//	public class ObservableMatch {
//	    private String matchScore;
//	    private List<Observer> observers = new ArrayList<>();
//	    public void addObserver(Observer channel) {
//	        //notifico il risultato iniziale non appena un observer si sottoscrive
//	        observer.update(this.matchScore);
//	        this.observers.add(channel);
//	    }
//	    public void removeObserver(Observer channel) {
//	        this.observers.remove(channel);
//	    }
//	    public ObservableMatch() {
//	        this.matchScore = "0-0";
//	    }
//	    public void setMatchScore(String newScore) {
//	        this.matchScore = newScore;
//	        for (Observer observer : this.observers) {
//	            observer.update(this.matchScore);
//	        }
//	    }
//	 ...
//	}
//


	



	
	

	/**public void update(Guest toUpdate) {
	        this.name = toUpdate.getName();
	        this.surname = toUpdate.getUsername();
	        this.pass = toUpdate.getPass();
	        this.mail = toUpdate.getMail();
	    }**/
	
	
	
}
