/**
 * EX - JDBC - demo
 *
 * Embedded SQL programming - CustomerDB
 *
 * File: CreateCustomerDB.java 
 */

package ex.jdbc;

/**
 * create the customer database table and
 * display all records by field
 */
public class CreateCustomerDB {

    static String url = "jdbc:derby://localhost/sun-appserv-samples";
    static String username = "APP";
    static String password = "APP";

    // print usage message
    public static void usage() {
        System.err.println("CreateCustomerDB [url username password]");
        System.err.println("\turl : the Database URL");
        System.err.println("\t\te.g. jdbc:derby://localhost/sample");
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
            case 3: // only database connection parameters
                url = args[0];
                username = args[1];
                password = args[2];
                break;
            default: // something is wrong
                System.out.println("Error: Invalid number of parameters!");
                usage();
                System.exit(1);
                break;
        }

        // the database object to access the actual database
        CustomerDB db1 = new CustomerDB(url, username, password);

        // create the database table
        System.out.println("Create an empty database table customer");
        db1.createDBTable();

        // show contents of the database table
        System.out.println("\tQuery all records using Field name");
        db1.displayAllRecordsByField();
    }
}
