package logic.Model;

public class CollectionPointMan extends AbstractUser {
	
	public CollectionPointMan(String name, String username, String pass, String mail) {
		super(name, username, pass, mail);
		this.role = 2;
		
	}

	@Override
	public String toString() {
		return "CollectionPointMan [name=" + name + ", username=" + username + ", pass=" + pass + ", role=" + role
				+ ", mail=" + mail + "]";
	}

	
	

}