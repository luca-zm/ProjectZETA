package logic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.enums.MesType;
import logic.model.AbstractUser;
import logic.persistence.DataSource;
import logic.model.Message;

public class MessageDAO {
	private static Connection currentCon = null;


    public static Boolean insertMessage(Message message, AbstractUser user) {
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_MESSAGE , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, message.getDate());
            preparedStatement.setString(2, message.getTitle());
            preparedStatement.setString(3, message.getBodymessage());
            preparedStatement.setString(4, String.valueOf(message.getType()));
            preparedStatement.setInt(5, user.getId());
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	ResultSet keys = preparedStatement.getGeneratedKeys();    
            	keys.next();  
            	message.setId(keys.getInt(1));
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public static Boolean deleteMessage(Message message) {
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_MESSAGE);
            preparedStatement.setInt(1, message.getId());
            
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
