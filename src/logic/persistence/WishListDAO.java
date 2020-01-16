package logic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.model.AbstractUser;
import logic.persistence.DataSource;
import logic.model.Product;


public class WishListDAO { 
	private static Connection currentCon = null;
	
    public static Boolean insert(AbstractUser user, Product product) {                    
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_WISHLIST);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, product.getId());
            
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean delete(AbstractUser user, Product product) {                    
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_WISHLIST);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, product.getId());
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