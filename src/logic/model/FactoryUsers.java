package logic.model;


public class FactoryUsers {

    public static AbstractUser get(String mail, String name, String username, String pass, String type) {

        switch (type) {

            case "COLLECTIONPOINTMAN":
                return new CollectionPointMan(name, pass, username, pass);
            case "USER":
                return new User(name, pass, username, pass);
            case "ADMIN":
                return new Admin(name, pass, username, pass);
            default:
                return new Guest(name, pass, username, pass);
        }
    }
}