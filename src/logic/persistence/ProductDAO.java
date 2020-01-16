package logic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.enums.MesType;
import logic.persistence.DataSource;
import logic.model.Product;

public class ProductDAO {
	private static Connection currentCon = null;
//	 String.valueOf(roles) 

    public static Boolean insertProduct(Product product) {      
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getDiscountPercentage());
            preparedStatement.setString(4, String.valueOf(product.getCategory()));
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setBoolean(7, product.isAvailability()); ///verificare boolean se combacia con tinyint
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
            	ResultSet keys = preparedStatement.getGeneratedKeys();    
            	keys.next();  
            	product.setId(keys.getInt(1));
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    
    public static Boolean deleteProduct(Product product) {      
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_PRODUCT);
            preparedStatement.setInt(1, product.getId());

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
