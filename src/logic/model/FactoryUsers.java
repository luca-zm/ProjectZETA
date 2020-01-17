package logic.model;


public class FactoryUsers {

    public static AbstractUser get(int id, String mail, String name, String username, String pass, String type) {

        switch (type) {

            case "COLLECTIONPOINTMAN":
                return new CollectionPointMan(id, name, pass, username, pass);
            case "USER":
                return new User(id, name, pass, username, pass);
            case "ADMIN":
                return new Admin(id, name, pass, username, pass);
            default:
                return new Guest(id, name, pass, username, pass);
        }
    }
}