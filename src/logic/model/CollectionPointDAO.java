package logic.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CollectionPointDAO {
	private static Connection currentCon = null;


    public static void insert(String name,double longitude, double latitude, int address, int openingTime, int closingTime, int isAvailable) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "insert into collectionpoint (name, longitude, latitude, address, openingTime, closingTime, isAvailable) values ('"
        				+ name
        				+ "','"
                        + longitude
                        + "','"
                        + latitude
                        + "','"
                        + address
                        + "','"
                        + openingTime
                        + "','"
                        + closingTime
                        + "','"
                        + isAvailable
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
}