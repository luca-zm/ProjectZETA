package logic.model;


public class FactoryUsers {
	
	

    public FactoryUsers() {
        throw new IllegalStateException("Utility class");
    }

	public static AbstractUser get( int id,String mail,String name ,String surname, String pass, String type) {

        switch (type) {

            case "COLLECTIONPOINTMAN":
                return new CollectionPointMan(id, mail, name , surname, pass);
            case "USER":
                return new User(id, mail, name , surname, pass);
            case "ADMIN":
                return new Admin(id, mail, name , surname, pass);
            default:
                return new Guest(id, mail, name , surname, pass);
        }
    }
}