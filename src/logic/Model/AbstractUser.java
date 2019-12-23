package logic.Model;

public abstract class AbstractUser {
	

	protected String name;
	protected String username;
	protected String pass;
	protected int role;
	protected String mail;

	
	
	
	public AbstractUser(String name, String username, String pass, String mail) {
		this.name = name;
		this.username = username;
		this.pass = pass;
		this.mail = mail;
		this.role = 0;
	}
	
	public int getRole() {
		return this.role;
	}
	
	
	
	
	

}
