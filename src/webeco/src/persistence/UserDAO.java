package persistence;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.DeliveryStatus;
import enums.Roles;
import model.AbstractUser;
import model.FactoryUsers;
import model.Product;
import model.ShipmentTran;
import persistence.DataSource;


public class UserDAO {
   public static Boolean insert(AbstractUser user)throws SQLException {
	   try {        
		   
		   /////////mail, name, surname, pass, type, cart, history, boards, greenCoin, address) VALUES (?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
           preparedStatement.setString(1, user.getMail());
           preparedStatement.setString(2, user.getName());
           preparedStatement.setString(3, user.getSurname());
           preparedStatement.setString(4, user.getPass());
           preparedStatement.setString(5, String.valueOf(user.getType()));
           preparedStatement.setInt(6, user.getGreenCoin());
           preparedStatement.setInt(7, user.getAddress().getId());
           
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
   
   
   public static Boolean delete(AbstractUser user) throws SQLException{
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
    
    public static AbstractUser findRegisteredUser(String mail) throws SQLException{
 
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_REGISTEREDUSER);
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { 
            	int id = resultSet.getInt("id");
            	String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String type = resultSet.getString("type"); 
                String pass = resultSet.getString("pass"); 
                int greenCoin = resultSet.getInt("greenCoin");

                AbstractUser user = FactoryUsers.get(id, mail, name, surname, pass, type);
                user.setGreenCoin(greenCoin);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<AbstractUser> findUsers() throws SQLException{
    	ArrayList<AbstractUser> list = new ArrayList<AbstractUser>();
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
           
            
            while (resultSet.next()) { 
            	int id = resultSet.getInt("id");
            	String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String type = resultSet.getString("type"); 
                String pass = resultSet.getString("pass"); 
                String mail = resultSet.getString("mail"); 
                int greenCoin = resultSet.getInt("greenCoin");

                AbstractUser user = FactoryUsers.get(id, mail, name, surname, pass, type);
                user.setGreenCoin(greenCoin);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    

        


    
    public static AbstractUser findUserById(int id) throws SQLException{
    	 
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_USERBYID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { 
            	String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String type = resultSet.getString("type");       
                String mail = resultSet.getString("mail");
                String pass = resultSet.getString("pass");
                AbstractUser user = FactoryUsers.get(id, mail, name, surname, pass, type);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Boolean update(AbstractUser user) throws SQLException{
 	   try {        
 		   
 		   /////////mail, name, surname, pass, type, cart, history, boards, greenCoin, address) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.UPDATE_USER);
            preparedStatement.setString(1, user.getMail());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.setString(5, String.valueOf(user.getType()));
            preparedStatement.setInt(6, user.getGreenCoin());
            preparedStatement.setInt(7, user.getAddress().getId());
            preparedStatement.setInt(8, user.getId());
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
    
        