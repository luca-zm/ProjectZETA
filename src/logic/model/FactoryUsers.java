package logic.model;


public class FactoryUsers {

    public static AbstractUser get(int id, String name, String username, String mail, String pass, String type) {

        switch (type) {

            case "COLLECTIONPOINTMAN":
                return new CollectionPointMan(id, name, username , mail, pass);
            case "USER":
                return new User(id, name, username , mail, pass);
            case "ADMIN":
                return new Admin(id, mail, name, username, pass);
            default:
                return new Guest(id, mail, name, username, pass);
        }
    }
}