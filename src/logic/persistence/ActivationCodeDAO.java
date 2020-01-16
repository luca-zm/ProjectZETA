package logic.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import logic.model.ActivationCode;
import logic.persistence.DataSource;


public class ActivationCodeDAO { //INSERIMENTO DI ACTIVATION CODE DA PARTE DI ADMIN, DA RIVEDERE LA GESTIONE
	/**
	PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.FIND_REGISTERED_USER);
    preparedStatement.setString(1, email);
    preparedStatement.setString(2, password);

    System.out.println("Welcome " + email + " " + password);

    ResultSet resultSet = preparedStatement.executeQuery();
    
    if (resultSet.next()) {
            return retrieveUserInfoFromDatabaseQuery(resultSet);
        }

        throw new SQLException();
        
        //////////////////////////////////////////////////////////////////////////////
        
        
        try {

            PreparedStatement statement = DataSource.getConnection().prepareStatement(Query.INSERT_PRODUCT);

            statement.setString(1, manageProductBean.getProducer_email());
            statement.setString(2, manageProductBean.getCategory());
            statement.setString(3, manageProductBean.getName());
            statement.setString(4, manageProductBean.getDescription());
            statement.setString(5, manageProductBean.getPicture());
            statement.setString(6, manageProductBean.getPrice());
            statement.setString(7, manageProductBean.getManufacturer());
            statement.setString(8, manageProductBean.getIsCharitable());
            statement.setString(9, manageProductBean.getDiscountPercentage());
            statement.setString(10, manageProductBean.getShipment_cost());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    **/
	
    public static Boolean insertActivationCode(ActivationCode actCode) throws SQLException {

        //preparing some objects for connection
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
    
    
    public static Boolean deleteActivationCode(ActivationCode actCode) throws SQLException {

        //preparing some objects for connection
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
}
