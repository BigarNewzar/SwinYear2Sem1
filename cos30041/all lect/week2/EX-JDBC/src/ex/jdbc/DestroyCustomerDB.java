/**
 * EX - JDBC - demo
 *
 * Embedded SQL programming - CustomerDB
 *
 * File: DestroyCustomerDB.java 
 */

package ex.jdbc;

/**
 * destroy the database table customer
 */
public class DestroyCustomerDB {

    static String url = "jdbc:derby://localhost/sun-appserv-samples";
    static String username = "APP";
    static String password = "APP";

    // print usage message
    public static void usage() {
        System.err.println("DestroyCustomerDB [url username password]");
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

        // show contents of the database table
        System.out.println("Before destorying the table");
        System.out.println("\tDisplay database content");
        db1.displayAllRecordsByField();

        // destroy database table customer
        System.out.println("Destroy the database table Customer");
        db1.destroyDBTable();

        // show contents of the database table
        System.out.println("After destorying the table");
        System.out.println("\tDisplay database content - just to make sure");
        db1.displayAllRecordsByField();
    }
}
