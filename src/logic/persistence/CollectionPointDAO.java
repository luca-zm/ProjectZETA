package logic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.model.AbstractUser;
import logic.model.Address;
import logic.model.CollectionPoint;
import logic.persistence.DataSource;

public class CollectionPointDAO {
	private static Connection currentCon = null;


    public static Boolean insertCollectionPoint(CollectionPoint collPoint){                 
            try {        
                PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_COLLECTIONPOINT, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, collPoint.getName());
                preparedStatement.setDouble(2, collPoint.getLongitude());
                preparedStatement.setDouble(3, collPoint.getLatitude());
                preparedStatement.setInt(4, collPoint.getAddress());
                preparedStatement.setInt(5, collPoint.getOpeningTime());
                preparedStatement.setInt(6, collPoint.getClosingTime());
                preparedStatement.setBoolean(7, collPoint.getIsAvailable());

                
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
    
    public static Boolean deleteCollectionPoint(CollectionPoint collPoint){                 
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_COLLECTIONPOINT);
            preparedStatement.setInt(1, collPoint.getId());
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
