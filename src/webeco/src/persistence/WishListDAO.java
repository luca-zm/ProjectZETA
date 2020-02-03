package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Category;
import model.AbstractUser;
import model.FactoryUsers;
import model.Product;
import persistence.DataSource;


public class WishListDAO { 
	private static Connection currentCon = null;
	
    public static Boolean insert(AbstractUser user, Product product) throws SQLException {                    
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

    public static Boolean delete(AbstractUser user, Product product) throws SQLException {                    
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
    
    public static ArrayList<Product> select(AbstractUser user) throws SQLException {
    	ArrayList<Product> list = new ArrayList<Product>();
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_WISHLIST);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
            	int productId = resultSet.getInt("productId");
            	Product product = ProductDAO.selectProduct(productId);
            	list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static Boolean checkProductByName(int id) throws SQLException {

        //preparing some objects for connection
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.FIND_PROD_IN_LIST); 
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { 

            	return true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}