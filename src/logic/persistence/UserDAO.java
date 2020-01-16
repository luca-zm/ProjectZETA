package logic.persistence;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.enums.Roles;
import logic.model.AbstractUser;
import logic.persistence.DataSource;
import logic.model.FactoryUsers;


public class UserDAO {
    private static Connection currentCon = null;
    private static ResultSet rs = null;
    private AbstractUser user = null;


   public static Boolean insert(AbstractUser user) {
	   try {        
		   
		   /////////mail, name, surname, pass, type, cart, history, boards, greenCoin, address) VALUES (?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
           preparedStatement.setString(1, user.getMail());
           preparedStatement.setString(2, user.getName());
           preparedStatement.setString(3, user.getSurname());
           preparedStatement.setString(4, user.getPass());
           preparedStatement.setString(5, String.valueOf(user.getType()));
           preparedStatement.setInt(6, user.getGreenCoin());
           preparedStatement.setInt(6, user.getAddress().getId());
           
           int resultSet = preparedStatement.executeUpdate();
           if (resultSet > 0) {
           	ResultSet keys = preparedStatement.getGeneratedKeys();    
           	keys.next();  
           	user.setId(keys.getInt(1));
           	return true;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
   }
   
   
   public static Boolean delete(AbstractUser user) {
	   try {        
		   
		   /////////mail, name, surname, pass, type, cart, history, boards, greenCoin, address) VALUES (?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_USER);
           preparedStatement.setInt(1, user.getId());          
           int resultSet = preparedStatement.executeUpdate();
           if (resultSet > 0) {
               return true;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
        
