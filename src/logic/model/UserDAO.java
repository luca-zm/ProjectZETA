package logic.model;


import logic.enums.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.activation.DataSource;

public class UserDAO {
    private static Connection currentCon = null;
    private static ResultSet rs = null;


    public static Guest login(Guest user) {

        //preparing some objects for connection
        Statement stmt = null;

        String username = user.getUsername();
        String password = user.getPass();

        String searchQuery =
                "select * from users where Username='"
                        + username
                        + "' AND Password='"
                        + password
                        + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: " + searchQuery);


        try {
            //connect to DB
            //currentCon = DataSource.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                user.setValid(false);
            } else {
                //if user exists set the isValid variable to true
                String firstName = rs.getString("Name");
                String lastName = rs.getString("Surname");

                System.out.println("Welcome " + firstName + " " + lastName);
                user.setValid(true);
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        //some exception handling
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    System.out.println("Exception in ResultSet close");
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    System.out.println("Exception in Statement close");
                }
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                    System.out.println("Exception in Connection close");

                }
                currentCon = null;
            }
        }

        return user;

    }
}