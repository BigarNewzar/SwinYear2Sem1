/**
 * EX - JDBC - demo
 *
 * Embedded SQL programming - CustomerDB
 *
 * File: SetUpCustomerDB.java 
 *     
 */
package ex.jdbc;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * set up the customer database table and load data from file
 *
 */
public class SetUpCustomerDB {

    static String url = "jdbc:derby://localhost/sun-appserv-samples";
    static String username = "APP";
    static String password = "APP";
    static String datafile = "customer.txt";

    // print usage message
    public static void usage() {
        System.err.println("SetUpDB [url username password] [filename]");
        System.err.println("\turl : the Database URL");
        System.err.println("\t\te.g. jdbc:derby://localhost/sun-appserv-samples");
        System.err.println("\tusername : user who can access the database");
        System.err.println("\t\te.g. app");
        System.err.println("\tpassword : password of user");
        System.err.println("\t\te.g. app");
    }

    public static void main(String[] args) {
        // check for invalid number of parameters
        switch (args.length) {
            case 0: // no supplied parameters, using default values
                break;
            case 1: // only data file name
                datafile = args[0];
                break;
            case 3: // only database connection parameters
                url = args[0];
                username = args[1];
                password = args[2];
                break;
            case 4: // all parameters are there
                url = args[0];
                username = args[1];
                password = args[2];
                datafile = args[3];
                break;
            default: // something is wrong
                System.out.println("Error: Invalid number of parameters!");
                usage();
                System.exit(1);
                break;
        }
        
        // the database object to access the actual database
        // establish the database connection with url, username, password
        CustomerDB db1 = new CustomerDB(url, username, password);

        db1.destroyDBTable();
        // create the database table
        System.out.println("Create an empty database table customer");
        db1.createDBTable();

        // show contents of the database table before adding records
        System.out.println("Before adding extra records to the customer table");
        System.out.println("\tQuery using Field name");
        db1.displayAllRecordsByField();

        // load data record from file to database table
        System.out.println("load records from file into the customer table");
        try {
            db1.loadRecordFromFile(datafile);
        } catch (FileNotFoundException | NumberFormatException ex) {
            Logger.getLogger(SetUpCustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        // query data records from database table
        System.out.println("Display all records in the customer table");
        System.out.println("\tQuery using Column number");
        db1.displayAllRecordsByColumn();

        // update data record in database table
        System.out.println("Update the record \"00013\" in the customer table");
        db1.editRecord("00013", "Bill Allen", "7890123457", 40);

        // query data records from database table
        System.out.println("Display all records in the customer table");
        System.out.println("\tQuery using Column number");
        db1.displayAllRecordsByColumn();


        // display data record by primary key (CustId)
        System.out.println("Display a particular record in the customer table");
        System.out.println("\tDisplay customer whose CustId is \"00012\"");
        db1.queryCustByCustId("00012");

        // delete data record from database table
        System.out.println("Delete the record whose CustId is \"00013\" from the customer table");
        db1.delRecord("00013");

        // query data records from database table
        System.out.println("Display all records in the customer table");
        System.out.println("\tQuery using Column number");
        db1.displayAllRecordsByColumn();
    }
}
