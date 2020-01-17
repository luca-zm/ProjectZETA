package logic.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logic.model.ActivationCode;
import logic.persistence.DataSource;


public class ActivationCodeDAO { 	
    public static Boolean insert(ActivationCode actCode) throws SQLException {

    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_ACTCODE);
            preparedStatement.setInt(1, actCode.getActivationCode());
            preparedStatement.setInt(2, actCode.getGrenCoinVal());
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public static Boolean delete(ActivationCode actCode) throws SQLException {
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_ACTCODE);
            preparedStatement.setInt(1, actCode.getActivationCode());            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static ActivationCode select(int code) throws SQLException {
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_ACTCODE);
            preparedStatement.setInt(1, code);            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {         	
            	ActivationCode actCode = new ActivationCode(code, resultSet.getInt("greenCoinAdded"));
                return actCode;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
