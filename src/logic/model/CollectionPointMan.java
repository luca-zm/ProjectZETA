package logic.model;

import static logic.enums.Roles.COLLECTIONPOINTMAN;
import logic.enums.Roles;

public class CollectionPointMan extends AbstractUser {

    public CollectionPointMan(int id, String mail, String name, String surname, String pass) {
		super(id, mail, name, surname, pass, Roles.COLLECTIONPOINTMAN);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Roles getType() {
		return COLLECTIONPOINTMAN;
	}


	@Override
	public String toString() {
		return "CollectionPointMan [name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail=" + mail
				+ ", type=" + type + ", cart=" + cart + ", history=" + history + ", boards=" + boards + ", greenCoin="
				+ greenCoin + "]";
	}

	
    
    
    
}