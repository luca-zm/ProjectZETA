package logic.Model;

import static logic.Model.Roles.COLLECTIONPOINTMAN;;

public class CollectionPointMan extends AbstractUser {

    public CollectionPointMan(String name, String username, String mail, String pass) {
    	super();
    }
    
    public CollectionPointMan() {
    	super();
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