package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.MesType;
import model.AbstractUser;
import model.CollectionPoint;
import model.Message;
import persistence.DataSource;

public class MessageDAO {
	private static Connection currentCon = null;


    public static Boolean insert(Message message, AbstractUser user)throws SQLException {
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
    
    
    public static Boolean insertBroad(Message message )throws SQLException {
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_MESSAGE , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, message.getDate());
            preparedStatement.setString(2, message.getTitle());
            preparedStatement.setString(3, message.getBodymessage());
            preparedStatement.setString(4, String.valueOf(message.getType()));
            preparedStatement.setInt(5, 0);
            
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
    
    
    
    public static Boolean delete(Message message) throws SQLException{
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
    
    public static ArrayList<Message> select(AbstractUser user) throws SQLException {

    	ArrayList<Message> list = new ArrayList<Message>();
        //preparing some objects for connection
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_MESSAGE); 
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { ;
            	String date = resultSet.getString("date");
            	String title = resultSet.getString("title");
            	String bodymessage = resultSet.getString("bodymessage");
            	String type = resultSet.getString("type");
            	MesType mesType = MesType.valueOf(type);
            	list.add(new Message(user.getId(), date, title, bodymessage, mesType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}
