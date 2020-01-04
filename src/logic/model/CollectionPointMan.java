package logic.model;

import static logic.enums.Roles.COLLECTIONPOINTMAN;
import logic.enums.Roles;

public class CollectionPointMan extends AbstractUser {

	public CollectionPointMan(String name, String username, String mail, String pass)  {
    	super(name, username, mail, pass, Roles.COLLECTIONPOINTMAN);
    }


    @Override
	public Roles getType() {
		return COLLECTIONPOINTMAN;
	}

	@Override
	public String toString() {
		return "CollectionPointMan [name=" + name + ", username=" + username + ", pass=" + pass + ", mail=" + mail
				+ ", getType()=" + getType() + "]";
	}
    
    
    
}