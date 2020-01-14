package logic.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.enums.DeliveryStatus;
import logic.model.AbstractUser;
import logic.model.DataSource;

public class TransactionDAO {
	private static Connection currentCon = null;


    public static void insertActivationCodeTran(int id, String date, int activationCode, int greenCoinAdded, int userId ) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "insert into activationcodetran (id, date, activationCode, greenCoinAdded, userId ) values ('"
        				+ id
        				+ "','"
                        + date
                        + "','"
                        + activationCode
                        + "','"
                        + greenCoinAdded
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
    
    public static void deleteActivationCodeTranById(int id) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "delete from activationcodetran where id =" + id;

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
    public static void insertBonusTran(int id, String date, String description, int greenCoinAdded, int userId ) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "insert into bonustran (id, date, activationCode, greenCoinAdded, UserId ) values ('"
        				+ id
        				+ "','"
                        + date
                        + "','"
                        + description
                        + "','"
                        + greenCoinAdded
                        + "','"
                        + userId
                        + "');";                  

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
    
    public static void deleteBonusTranById(int id) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "delete from bonustran where id =" + id;

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
    
    public static void insertShipmentTran(String date, String trackingNumber, int product, DeliveryStatus deliveryStatus, int userId) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "insert into shipment (date, trackingNumber, product, deliveryStatus, userId) values ('"
                        + date
                        + "','"
                        + trackingNumber
                        + "','"
                        + product
                        + "','"
                        + deliveryStatus
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
    
    public static void deleteShipmentTranById(int id) {

        //preparing some objects for connection
        Statement stmt = null;


        
        String searchQuery =
                "delete from shipment where id =" + id;

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

