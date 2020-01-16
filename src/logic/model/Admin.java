package logic.model;

import static logic.enums.Roles.ADMIN;
import logic.enums.Roles;
public class Admin extends AbstractUser {



    public Admin(int id, String mail, String name, String username, String pass) {
		super(id, mail, name, username, pass, Roles.ADMIN);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Roles getType() {
		return ADMIN;
	}


	@Override
	public String toString() {
		return "Admin [name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail=" + mail + ", type=" + type
				+ ", cart=" + cart + ", history=" + history + ", boards=" + boards + ", greenCoin=" + greenCoin + "]";
	}
    

	  
    
}


