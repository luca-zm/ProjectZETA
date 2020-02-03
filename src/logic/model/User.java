package logic.model;
import logic.enums.Roles;

import static logic.enums.Roles.USER;

public class User extends AbstractUser {

	public User(int id, String mail, String name, String surname, String pass) {
		super(id, mail, name, surname, pass, Roles.USER);	
	}
	
	@Override
	public Roles getType() {
		return USER;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail=" + mail + ", type=" + type
				+ ", cart=" + cart + ", history=" + history + ", boards=" + boards + ", greenCoin=" + greenCoin + "]";
	}
	
}
