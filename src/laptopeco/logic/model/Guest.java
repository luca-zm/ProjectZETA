package laptopeco.logic.model;

import static logic.enums.Roles.GUEST;

import logic.enums.Roles;

public class Guest extends AbstractUser{
	public Guest(int id, String mail, String name, String surname, String pass) {
		super(id, mail, name, surname, pass, Roles.GUEST);
	}

	@Override
    public Roles getType() {
        return GUEST;
    }

	public void setValid(boolean b) {
		//empty
	}
	
	


	
	
    
}
