package logic.Model;

import static logic.Model.Roles.ADMIN;

public class Admin extends AbstractUser {

    public Admin(String name, String username, String mail, String pass)  {
    }
    
    public Admin() {

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


