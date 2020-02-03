package logic.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.enums.DeliveryStatus;
import logic.model.AbstractUser;
import logic.model.ActivationCodeTran;
import logic.model.BonusTran;
import logic.model.Product;
import logic.model.ShipmentTran;

public class TransactionDAO {
	


	private TransactionDAO()  {
	    throw new IllegalStateException("Utility class");
	  }


	public static Boolean insertActivationCodeTran(ActivationCodeTran actCodeTran, AbstractUser user) throws SQLException{
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
    
    
    public static Boolean deleteActivationCodeTran(ActivationCodeTran actCodeTran) throws SQLException{
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
    
    
    public static List<ActivationCodeTran> selectActivationCodeTra(AbstractUser user) throws SQLException {

    	ArrayList<ActivationCodeTran> list = new ArrayList<>();
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_ACTCODETRAN);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
            	int id = resultSet.getInt("id");
            	String date = resultSet.getString("date");
            	int activationCode = resultSet.getInt("activationCode");
            	int greenCoinAdded = resultSet.getInt("greenCoinAdded");
            	
            	list.add(new ActivationCodeTran(id, date, activationCode, greenCoinAdded));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Boolean insertBonusTran(BonusTran bonusTran, AbstractUser user) throws SQLException{
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
    
    
    
    public static Boolean deleteBonusTran(BonusTran bonusTran) throws SQLException{
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
    
    public static List<BonusTran> selectBonusTran(AbstractUser user) throws SQLException {

    	ArrayList<BonusTran> list = new ArrayList<>();
        //preparing some objects for connection
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_BONUSTRAN);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
            	int id = resultSet.getInt("id");
            	String date = resultSet.getString("date");
            	String description = resultSet.getString("description");
            	int greenCoinAdded = resultSet.getInt("greenCoinAdded");
            	
            	list.add(new BonusTran(id, date, description, greenCoinAdded));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static Boolean insertShipment(ShipmentTran shipmentTran, AbstractUser user)throws SQLException {                
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
    
    public static Boolean deleteShipment(ShipmentTran shipmentTran) throws SQLException{                
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
    
    public static List<ShipmentTran> selectShipment(AbstractUser user) throws SQLException {

    	ArrayList<ShipmentTran> list = new ArrayList<>();
        //preparing some objects for connection
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_SHIPMENT);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
            	int id = resultSet.getInt("id");
            	String date = resultSet.getString("date");
            	String trackingNumber = resultSet.getString("trackingNumber");
            	int prodId = resultSet.getInt("product");
            	Product product = ProductDAO.selectProduct(prodId);
            	String delString = resultSet.getString("deliveryStatus");
            	DeliveryStatus deliveryStatus = DeliveryStatus.valueOf(delString);
            	
            	list.add(new ShipmentTran(id, date, trackingNumber, product, deliveryStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 
}

