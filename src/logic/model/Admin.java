package logic.model;

import static logic.enums.Roles.ADMIN;
import logic.enums.Roles;
public class Admin extends AbstractUser {



    public Admin(int id, String mail, String name, String surname, String pass) {
		super(id, mail, name, surname, pass, Roles.ADMIN);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Roles getType() {
		return ADMIN;
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail=" + mail
				+ ", type=" + type + ", cart=" + cart + ", wishList=" + wishList + ", history=" + history + ", boards="
				+ boards + ", greenCoin=" + greenCoin + ", address=" + address + "]";
	}

	
    

	  
    
}


