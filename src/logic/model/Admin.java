package logic.model;

import static logic.enums.Roles.ADMIN;
import logic.enums.Roles;
public class Admin extends AbstractUser {

    public Admin(String mail, String name, String username, String pass)  {
    	super(mail, name, username, pass, Roles.ADMIN);
    }

    @Override
	public Roles getType() {
		return ADMIN;
	}
    

	@Override
	public String toString() {
		return "Admin [name=" + name + ", username=" + username + ", pass=" + pass + ", mail=" + mail + ", getType()="
				+ getType() + "]";
	}   
    
}


