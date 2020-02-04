package laptopeco.logic.model;

import static logic.enums.Roles.ADMIN;
import logic.enums.Roles;
public class Admin extends AbstractUser {



    public Admin(int id, String mail, String name, String surname, String pass) {
		super(id, mail, name, surname, pass, Roles.ADMIN);
	}


	@Override
	public Roles getType() {
		return ADMIN;
	}
   
}


