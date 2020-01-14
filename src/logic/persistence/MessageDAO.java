package logic.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.enums.MesType;
import logic.model.DataSource;

public class MessageDAO {
	private static Connection currentCon = null;


    public static void insertMessage(String date, String title, String bodymessage, String type, int userId) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "insert into message (date, title, bodymessage, type, userId) values ('"
                        + date
                        + "','"
                        + title
                        + "','"
                        + bodymessage
                        + "','"
                        + type
                        + "','"
                        + userId
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
