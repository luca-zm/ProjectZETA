package logic.persistence;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.enums.Roles;
import logic.model.AbstractUser;
import logic.model.DataSource;
import logic.model.FactoryUsers;


public class UserDAO {
    private static Connection currentCon = null;
    private static ResultSet rs = null;
    private AbstractUser user = null;



    public static AbstractUser findRegisteredUser(String mail, String pass) {

        //preparing some objects for connection
        Statement stmt = null;

        String searchQuery =
                "select * from user where mail='"
                        + mail
                        + "' AND pass='"
                        + pass
                        + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: " + searchQuery);

        AbstractUser user = null;

        try {
            //connect to DB
            currentCon = DataSource.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);

            // if user does not exist set the isValid variable to false
            if (!rs.next()) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
            } else {
                //if user exists set the isValid variable to true
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String type = rs.getString("type");
                
                user = FactoryUsers.get(name, surname, mail, pass, type);
                System.out.println("Welcome " + name + " " + surname);
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
    
    public static AbstractUser findUserByMail(String mail) {

        //preparing some objects for connection
        Statement stmt = null;

        String searchQuery =
                "select * from user where mail='"
                        + mail;

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: " + searchQuery);

        AbstractUser user = null;

        try {
            //connect to DB
            currentCon = DataSource.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);

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
    
    /**public static AbstractUser modifyUserById(int id) {

        //preparing some objects for connection
        Statement stmt = null;

        String searchQuery =
                "delete from user where id=" + id;
                       

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB
            currentCon = DataSource.getConnection();
            stmt = currentCon.createStatement();
            stmt.execute(searchQuery);

        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        //some exception handling
        finally {
            if (rs != null) 
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
        
		return null;
    }**/

    
    public static AbstractUser deleteUserById(int id) {

        //preparing some objects for connection
        Statement stmt = null;

        String searchQuery =
                "delete from user where id=" + id;
                       

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB
            currentCon = DataSource.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(searchQuery);

        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        //some exception handling
        finally {
            if (rs != null) 
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
        
		return null;
    }
}
        
