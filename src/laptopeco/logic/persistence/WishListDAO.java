package laptopeco.logic.persistence;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.Product;


public class WishListDAO { 
	
	private WishListDAO()  {
        super();
    }

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
    
    public static List<Product> select(AbstractUser user) throws SQLException {
    	ArrayList<Product> list = new ArrayList<>();
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