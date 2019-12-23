package logic.Model;

public class Admin extends AbstractUser {
	
	public Admin(String name, String username, String pass, String mail) {
		super(name, username, pass, mail);
		this.role = 1;
		
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", username=" + username + ", pass=" + pass + ", role=" + role + ", mail=" + mail
				+ "]";
	}

	
	
	

}
