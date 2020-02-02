package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AbstractUser;
import model.ActivationCode;
import model.Address;
import persistence.DataSource;


public class AddressDAO { 
	private static Connection currentCon = null;


    public static Boolean insert(Address address) throws SQLException{                 
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_ADDRESS, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, address.getAddress());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getPostalCode());
            preparedStatement.setString(4, address.getTelephone());
            preparedStatement.setString(5, address.getState());
            preparedStatement.setString(6, address.getZone());

            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	ResultSet keys = preparedStatement.getGeneratedKeys();    
            	keys.next();  
            	address.setId(keys.getInt(1));
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static Boolean delete(Address address) throws SQLException{                 
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_ADDRESS);
            preparedStatement.setInt(1, address.getId()); 
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public static Address select(AbstractUser user) throws SQLException {

        //preparing some objects for connection
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_ADDRESS);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {         	
            	String address = resultSet.getString("address");
            	String city = resultSet.getString("city");
            	String postalCode = resultSet.getString("postalCode");
            	String telephone = resultSet.getString("telephone");
            	String state = resultSet.getString("state");
            	String zone = resultSet.getString("zone");
            	Address addr = new Address(user.getId(), address, city, postalCode, telephone, state, zone);
            	return addr;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Boolean update(Address address) throws SQLException{                 
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.UPDATE_ADDRESS);
            preparedStatement.setString(1, address.getAddress());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getPostalCode());
            preparedStatement.setString(4, address.getTelephone());
            preparedStatement.setString(5, address.getState());
            preparedStatement.setString(7, address.getZone());
            preparedStatement.setInt(8, address.getId());
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static Address findAddressById(int id) throws SQLException{
      	 
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_ADDRBYID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { 
            	String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String postalCode = resultSet.getString("postalCode"); 
                String telephone = resultSet.getString("telephone"); 
                String state = resultSet.getString("state");
                String zone = resultSet.getString("zone");

                Address addr = new Address(id, address, city, postalCode, telephone, state, zone);
                
                return addr;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
}

    
