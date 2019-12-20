package Model;

public class User extends AbstractUser {
	
	public User(String name, String username, String pass, String mail) {
		super(name, username, pass, mail);
		this.role = 3;
		
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", pass=" + pass + ", role=" + role + ", mail=" + mail
				+ ", cart=" + cart + ", getRole()=" + getRole() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}