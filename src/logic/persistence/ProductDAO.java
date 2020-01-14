package logic.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.enums.MesType;
import logic.model.DataSource;

public class ProductDAO {
	private static Connection currentCon = null;


    public static void insertProduct(int id, String name, int price, int discountPercentage, String category, String image, String description, int availability ) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "insert into product (id, name, price, discountPercentage, category, image, description, availability) values ('"
                        + id
                        + "','"
                        + name
                        + "','"
                        + price
                        + "','"
                        + discountPercentage
                        + "','"
                        + category
                        + "','"
                        + image
                        + "','"
                        + description
                        + "','"
                        + availability
                        + "');";                  

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB
            currentCon = DataSource.getConnection();
            stmt = currentCon.createStatement();
            stmt.execute(searchQuery);
            
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        //some exception handling
        finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    System.out.println("Exception in Statement close");
                }
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                    System.out.println("Exception in Connection close");

                }
                currentCon = null;
            }
        }

    }
    
    public static void deleteProductById(int id) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "delete from product where id =" + id;

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB
            currentCon = DataSource.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(searchQuery);
            
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        //some exception handling
        finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    System.out.println("Exception in Statement close");
                }
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                    System.out.println("Exception in Connection close");

                }
                currentCon = null;
            }
        }

    }
}
