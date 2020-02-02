package logic.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logic.enums.Category;
import logic.persistence.DataSource;
import logic.model.Product;

public class ProductDAO {
	private static Connection currentCon = null;
//	 String.valueOf(roles) 

    public static Boolean insert(Product product) throws SQLException{      
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getDiscountPercentage());
            preparedStatement.setString(4, String.valueOf(product.getCategory()));
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setBoolean(7, product.isAvailability()); 
            
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

    
    
    public static Boolean delete(int id) throws SQLException{      
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.DELETE_PRODUCT);
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
    
    public static ArrayList<Product> select() throws SQLException {

    	ArrayList<Product> list = new ArrayList<Product>();
        //preparing some objects for connection
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_PRODUCTS); 
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
            	int id = resultSet.getInt("id");
            	String name = resultSet.getString("name");
            	int price = resultSet.getInt("price");
            	int discountPercentage = resultSet.getInt("discountPercentage");
            	String catString = resultSet.getString("category");
            	Category category = Category.valueOf(catString);
            	String image = resultSet.getString("image");
            	String description = resultSet.getString("description");
            	Boolean availability = resultSet.getBoolean("availability");
            	
            	list.add(new Product(id, name, price, discountPercentage, category, image, description, availability));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public static Product selectProduct(int id) throws SQLException {

        //preparing some objects for connection
    	try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.SELECT_PRODUCT); 
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { 
            	String name = resultSet.getString("name");
            	int price = resultSet.getInt("price");
            	int discountPercentage = resultSet.getInt("discountPercentage");
            	String catString = resultSet.getString("category");
            	Category category = Category.valueOf(catString);
            	String image = resultSet.getString("image");
            	String description = resultSet.getString("description");
            	Boolean availability = resultSet.getBoolean("availability");
            	
            	return new Product(id, name, price, discountPercentage, category, image, description, availability);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean update(Product product) throws SQLException{      
        try {        
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getDiscountPercentage());
            preparedStatement.setString(4, String.valueOf(product.getCategory()));
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setBoolean(7, product.isAvailability()); 
            preparedStatement.setInt(8, product.getId());
            
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
