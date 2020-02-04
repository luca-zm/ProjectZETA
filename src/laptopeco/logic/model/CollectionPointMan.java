package laptopeco.logic.model;

import static logic.enums.Roles.COLLECTIONPOINTMAN;
import logic.enums.Roles;

public class CollectionPointMan extends AbstractUser {

    public CollectionPointMan(int id, String mail, String name, String surname, String pass) {
		super(id, mail, name, surname, pass, Roles.COLLECTIONPOINTMAN);
	}

	@Override
	public Roles getType() {
		return COLLECTIONPOINTMAN;
	}
	
    
    
    
}