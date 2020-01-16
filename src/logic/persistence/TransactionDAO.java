package logic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.enums.DeliveryStatus;
import logic.model.AbstractUser;
import logic.model.ActivationCodeTran;
import logic.model.BonusTran;
import logic.persistence.DataSource;
import logic.model.ShipmentTran;

public class TransactionDAO {
	private static Connection currentCon = null;


	public static Boolean insertActivationCodeTran(ActivationCodeTran actCodeTran, AbstractUser user) {
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_ACTCODETRAN , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, actCodeTran.getDate());
            preparedStatement.setInt(2, actCodeTran.getActivationCode());
            preparedStatement.setInt(3, actCodeTran.getGreenCoinAdded());
            preparedStatement.setInt(4, user.getId());
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	ResultSet keys = preparedStatement.getGeneratedKeys();    
            	keys.next();  
            	actCodeTran.setId(keys.getInt(1));
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public static Boolean deleteActivationCodeTran(ActivationCodeTran actCodeTran) {
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_ACTCODETRAN);
            preparedStatement.setInt(1, actCodeTran.getId());
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean insertBonusTran(BonusTran bonusTran, AbstractUser user) {
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_BONUSTRAN , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, bonusTran.getDate());
            preparedStatement.setString(2, bonusTran.getDescription());
            preparedStatement.setInt(3, bonusTran.getGreenCoinAdded());
            preparedStatement.setInt(4, user.getId());
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	ResultSet keys = preparedStatement.getGeneratedKeys();    
            	keys.next();  
            	bonusTran.setId(keys.getInt(1));
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    public static Boolean deleteBonusTran(BonusTran bonusTran) {
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_BONUSTRAN);
            preparedStatement.setInt(1, bonusTran.getId());            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static Boolean insertShipment(ShipmentTran shipmentTran, AbstractUser user) {                
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_SHIPMENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, shipmentTran.getDate());
            preparedStatement.setString(2, shipmentTran.getTackingNumber());
            preparedStatement.setInt(3, shipmentTran.getProduct().getId());
            preparedStatement.setString(4, String.valueOf(shipmentTran.getDeliveryStatus()));
            preparedStatement.setInt(5, user.getId());
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	ResultSet keys = preparedStatement.getGeneratedKeys();    
            	keys.next();  
            	shipmentTran.setId(keys.getInt(1));
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static Boolean deleteShipment(ShipmentTran shipmentTran) {                
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_SHIPMENT);
            preparedStatement.setInt(1, shipmentTran.getId());
            
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

