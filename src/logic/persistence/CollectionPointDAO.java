package logic.persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logic.model.CollectionPoint;

public class CollectionPointDAO {
	
    private CollectionPointDAO() {
        throw new IllegalStateException("Utility class");
    }

	public static Boolean insert(CollectionPoint collPoint)throws SQLException{                 
            try {        
                PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_COLLECTIONPOINT, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, collPoint.getName());
                preparedStatement.setDouble(2, collPoint.getLongitude());
                preparedStatement.setDouble(3, collPoint.getLatitude());
                preparedStatement.setString(4, collPoint.getAddress());
                preparedStatement.setInt(5, collPoint.getOpeningTime());
                preparedStatement.setInt(6, collPoint.getClosingTime());
         

                
                int resultSet = preparedStatement.executeUpdate();
                if (resultSet > 0) {
                	ResultSet keys = preparedStatement.getGeneratedKeys();    
                	keys.next();  
                	collPoint.setId(keys.getInt(1));
                	return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    
    public static Boolean delete(int id)throws SQLException{                 
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_COLLECTIONPOINT);
            preparedStatement.setInt(1, id);
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static ArrayList<CollectionPoint> select() throws SQLException {

    	ArrayList<CollectionPoint> list = new ArrayList<>();
        //preparing some objects for connection
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_COLLECTIONPOINT);          
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
            	int id = resultSet.getInt("id");
            	String name = resultSet.getString("name");
            	double lon = resultSet.getDouble("longitude");
            	double lat = resultSet.getDouble("latitude");
            	String addr = resultSet.getString("address");
            	int opTime = resultSet.getInt("openingTime");
            	int clTime = resultSet.getInt("closingTime");
        
            	list.add(new CollectionPoint(id, name, lon, lat, addr, opTime, clTime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public static Boolean update(CollectionPoint collPoint)throws SQLException{                 
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.UPDATE_COLLECTIONPOINT);
            preparedStatement.setString(1, collPoint.getName());
            preparedStatement.setDouble(2, collPoint.getLongitude());
            preparedStatement.setDouble(3, collPoint.getLatitude());
            preparedStatement.setString(4, collPoint.getAddress());
            preparedStatement.setInt(5, collPoint.getOpeningTime());
            preparedStatement.setInt(6, collPoint.getClosingTime());
            preparedStatement.setInt(7, collPoint.getId());

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
