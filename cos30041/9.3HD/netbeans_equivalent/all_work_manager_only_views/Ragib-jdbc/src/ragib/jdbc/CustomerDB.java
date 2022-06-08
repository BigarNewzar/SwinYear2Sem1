package ragib.jdbc;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ragib
 */
public class CustomerDB {

    // Database parameters for connection - url, username, password
    static String url;
    static String username;
    static String password;

    static final String DB_TABLE = "Ragib_Customers";
    static final String DB_PK_CONSTRAINT = "PK_" + DB_TABLE;

    /**
     * constructor using default url, username and password
     */
    public CustomerDB() {
        // set default parameters for Derby and JavaDB
        url = "jdbc:derby://localhost/sun-appserv-samples;create=true";
        username = "APP";
        password = "APP";
    }

    /**
     * getConnecion()
     *
     * @aim Get a connection to the database using the specified info
     */
    public static Connection getConnection()
            throws SQLException, IOException {
        // first, need to set the driver for connection
        // for Derby
        System.setProperty("jdbc.drivers",
                "org.apache.derby.jdbc.ClientDriver");

        // next is to get the connection
        return DriverManager.getConnection(url, username, password);
    }

    /*
     * createDBTable
     *
     * @aim Use SQL commands to create the database table
     */
    public void createDBTable() {
        Connection cnnct = null;    // declare a connection object
        Statement stmnt = null;     // declare a statement object

        try {
            // get connection
            cnnct = getConnection();
            // get statement
            stmnt = cnnct.createStatement();

            /**
             * execute query to create a data table with the required fields
             * keeping all of them as strings as the these will only be stored and retrieved from database in form of logs and will not be used in calculation purposes
             */
            stmnt.execute("CREATE TABLE " + DB_TABLE
                    + " (Transaction_id VARCHAR(20) CONSTRAINT " + DB_PK_CONSTRAINT + " PRIMARY KEY,"
                    + " Firstname VARCHAR(20)," 
                    + " Lastname VARCHAR(20), "
                    + " Email VARCHAR(30), "
                    + " Address VARCHAR(30), "
                    + " Suburb VARCHAR(30), "
                    + " Postcode VARCHAR(4), "
                    + " Phone VARCHAR(10), "
                    + " Product_name VARCHAR(40), "        
                    + " Quantity VARCHAR(10), "        
                    + " Comment VARCHAR(100), "        
                    + " Credit_card_name VARCHAR(40), "
                    + " Credit_card_number VARCHAR(16), "
                    + " Credit_card_expiry_date VARCHAR(4), "
                    + " Credit_card_CVV VARCHAR(3))");
        } catch (SQLException ex) {
            // do nothing
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    /**
                     * cnnct.close() throws a SQLException, but we cannot
                     * recover at this point
                     */
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }

    /**
     * destroyDBTable()
     *
     * @aim Remove the database table
     */
    public void destroyDBTable() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            // get connection
            cnnct = getConnection();
            // get statement
            stmnt = cnnct.createStatement();

            // execute action query to destroy a data table
            stmnt.execute("DROP TABLE " + DB_TABLE);
        } catch (SQLException ex) {
            // do nothing
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }

    /**
     * addRecord()
     *
     * @aim Add a record into the database table
     */
    public void addRecords(ArrayList<Customer> custList) {

        Connection cnnct = null;

        // create a PreparedStatement object
        PreparedStatement pStmnt = null;

        try {
            // get connection
            cnnct = getConnection();

            // precompiled query statement
            String preQueryStatement = "INSERT INTO " + DB_TABLE
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            for (Customer cust : custList) {

                // get statement
                pStmnt = cnnct.prepareStatement(preQueryStatement);

                // set individual parameters at corresponding positions
                pStmnt.setString(1, cust.getTransaction_id());
                pStmnt.setString(2, cust.getFirstname());
                pStmnt.setString(3, cust.getLastname());
                pStmnt.setString(4, cust.getEmail());                
                pStmnt.setString(5, cust.getAddress());                
                pStmnt.setString(6, cust.getSuburb());
                pStmnt.setString(7, cust.getPostcode());
                pStmnt.setString(8, cust.getPhone());
                pStmnt.setString(9, cust.getProduct_name());
                pStmnt.setString(10, cust.getQuantity());
                pStmnt.setString(11, cust.getComment());
                pStmnt.setString(12, cust.getCredit_card_name());
                pStmnt.setString(13, cust.getCredit_card_number());
                pStmnt.setString(14, cust.getCredit_card_expiry_date());
                pStmnt.setString(15, cust.getCredit_card_CVV());
                

                
                int rowCount = pStmnt.executeUpdate();

                /*
                 * rowCount should be 1 because 1 record is added
                 *
                 * throws exception if not
                 */
                if (rowCount == 0) {
                    throw new SQLException("Cannot insert records!");
                }
            }
        } catch (SQLException ex) {
            // do nothing
        } catch (IOException ex) {
            // do nothing
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                    // do nothing
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                    // do nothing
                }
            }
        }
    }
}
