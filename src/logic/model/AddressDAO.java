package logic.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class AddressDAO { 
	private static Connection currentCon = null;


    public static void insert(String address, String city, String postalCode, String telephone, String state, String country, String zone) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "insert into address ( address, city, postalCode, telephone, state, country, zone) values ('"
                		+ address
        				+ "','"
                        + city
                        + "','"
                        + postalCode
                        + "','"
                        + telephone
                        + "','"
                        + state
                        + "','"
                        + country
                        + "','"
                        + zone
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