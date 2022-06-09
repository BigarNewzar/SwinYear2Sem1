/**
 * EX- JDBC - demo
 *
 * Embedded SQL programming - CustomerDB
 *
 * File: CustomerDB.java (
 */
package ex.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.IOException;

/**
 * a class that calls various CustomerDB methods
 */
public class CustomerDB {

    // set default parameters for Derby / JavaDB
    String url;
    String username;
    String password;

    // query statement
    static String createTableSQL = "CREATE TABLE customer ("
            + " CustId CHAR(5) CONSTRAINT PK_CUSTOMER2 PRIMARY KEY,"
            + " Name CHAR(25), Tel CHAR(10), Age INT)";
    static String destroyTableSQL = "DROP TABLE customer";
    static String findAllSQL = "SELECT * FROM customer";
    static String findRecordByPKSQL = "SELECT * FROM customer WHERE CustId = ?";

    // precompiled query statement
    static String addRecordSQL = "INSERT INTO customer VALUES (?, ?, ?, ?)";
    static String editRecordSQL = "UPDATE customer "
            + "SET Name = ?, Tel = ?, Age = ? WHERE CustId = ?";
    static String delRecordSQL = "DELETE FROM customer WHERE CustId = ?";

    /**
     * constructor using default url, username and password
     */
    public CustomerDB() {
        // set default values
        url = "jdbc:derby://localhost/sun-appserv-samples";
        username = "APP";
        password = "APP";
    }

    /**
     * constructor using supplied dbUrl, username and password
     *
     * @param dbUrl
     * @param dbUsername
     * @param dbPassword
     */
    public CustomerDB(String dbUrl, String dbUsername, String dbPassword) {
        // set parameters for the connection
        url = dbUrl;
        username = dbUsername;
        password = dbPassword;
    }

    /**
     * getConnecion()
     *
     * @return
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     * @aim Get a connection to the database using the specified info
     */
    public Connection getConnection() throws SQLException, IOException {

        // first, need to set the driver for connection
        /**
         * there are two options one is to use - Class.forName() the other is to
         * use - System.setProperty()
         */
        // First option
        // register the driver to be used for PointBase
        /*
        Class.forName("com.pointbase.jdbc.jdbcUniversalDriver");
         */
        // register the driver to be used for Derby
        /*
        Class.forName("org.apache.derby.jdbc.ClientDriver");
         */
        // Second option
        // for PointBase
        /*
        System.setProperty("jdbc.drivers", "com.pointbase.jdbc.jdbcUniversalDriver");
         */
        // for Derby
//        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");

        // next is to get the connection
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * use SQL commands to create the database table - customer
     */
    public void createDBTable() {
        Connection cnnct = null;    // create a connection object
        Statement stmnt = null;     // create a statement object

        try {
            // get connection
            cnnct = this.getConnection();

            if (cnnct == null) {
                System.out.println("cannot get connection!");
            }
            // get statement
            stmnt = cnnct.createStatement();

            /**
             * execute action query to create a data table with four fields:
             * CustId, Name, Tel, Age
             *
             * beware that we need the space character to be in front or at end
             * to concatenate the strings properly
             */
            stmnt.execute(createTableSQL);
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
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
                }
            }
        }
    }

    /**
     * destroy the database table - customer
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
            stmnt.execute(destroyTableSQL);
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        } finally {
            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    /**
     * load data customer from file to database table
     *
     * @param filename
     * @return
     * @throws FileNotFoundException
     */
    public int loadRecordFromFile(String filename) throws FileNotFoundException, NumberFormatException {
        int numRecord = 0;

        // create a Connection object
        Connection cnnct = null;

        // create a PreparedStatement object
        PreparedStatement pStmnt = null;

        // open the file for read access
        BufferedReader reader;
        String msg;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            msg = "ERROR: The file " + filename + " does not exist";
            throw (new FileNotFoundException(msg));
        }

        // load data to database, one customer at a time
        try {
            // get connection
            cnnct = getConnection();

            // get statement
            pStmnt = cnnct.prepareStatement(addRecordSQL);

            String recordLine;
            int numLine = 0;
            numRecord = 0;
            Customer customer;
            while ((recordLine = reader.readLine()) != null) {
                numLine++;
                recordLine = recordLine.trim();
                if (recordLine.equals("")) {
                    // empty line - do nothing
                } else if (recordLine.charAt(0) == '#') {
                    // this is a comment line, ignore it - do nothing
                } else if ((customer = isValidRecord(recordLine, numLine))
                        != null) {
                    // the customer is good
                    numRecord++;

                    // load the data to the database table - starts here
                    // set individual parameters at corresponding positions
                    pStmnt.setString(1, customer.getCustId());
                    pStmnt.setString(2, customer.getName());
                    pStmnt.setString(3, customer.getTel());
                    pStmnt.setInt(4, customer.getAge());

                    /*
                     * execute update query to add customer into the data table
                     * with four fields: CustId, Name, Tel, Age
                     *
                     * will return number of records added
                     */
                    int rowCount = pStmnt.executeUpdate();

                    /*
                     * rowCount should be 1 because 1 customer is added
                     *
                     * throws exception if not
                     */
                    if (rowCount == 0) {
                        throw new SQLException("Cannot insert record!");
                    }
                }
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }

        return numRecord;
    }

    /**
     * check whether the line contains a valid customer and return a Customer
     * object if yes, null if otherwise
     *
     * @param line
     * @param num
     * @return a Customer object containing the corresponding data
     * @throws NumberFormatException
     */
    public Customer isValidRecord(String line, int num) throws NumberFormatException {
        Customer customer;

        String[] field = line.trim().split(",[\\s]*"); // data fields per line

        if (field.length < 4) {
            // insufficient data fields
            customer = null;
        } else if (field.length > 4) {
            // too many data fields
            customer = null;
        } else {
            // field length is 4
            String custId = field[0];
            String name = field[1];
            String tel = field[2];
            int age;
            try {
                age = Integer.parseInt(field[3]);

                if (age <= 0) {
                    String msg = "Error at line " + num + ": age is not positive";
                    throw (new NumberFormatException(msg));
                }
            } catch (NumberFormatException ex) {
                String msg = "Error at line " + num + ": age is not an integer";
                throw (new NumberFormatException(msg));
            }

            customer = new Customer(custId, name, tel, age);
        }

        return customer;
    }

    /**
     * add record to database
     *
     * @param custId
     * @param name
     * @param tel
     * @param age
     */
    public void addRecord(String custId, String name, String tel, int age) {
        Connection cnnct = null;

        // create a PreparedStatement object
        PreparedStatement pStmnt = null;

        try {
            // get connection
            cnnct = getConnection();

            // precompiled query statement
//            String preQueryStatement = "INSERT INTO customer"
//                    + " VALUES (?, ?, ?, ?)";
            // get statement
            pStmnt = cnnct.prepareStatement(addRecordSQL);

            // set individual parameters at corresponding positions
            pStmnt.setString(1, custId);
            pStmnt.setString(2, name);
            pStmnt.setString(3, tel);
            pStmnt.setInt(4, age);

            /*
             * execute update query to add customer into the data table
             * with four fields: CustId, Name, Tel, Age
             *
             * will return number of records added
             */
            int rowCount = pStmnt.executeUpdate();

            /*
             * rowCount should be 1 because 1 customer is added
             *
             * throws exception if not
             */
            if (rowCount == 0) {
                throw new SQLException("Cannot insert records!");
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    /**
     * delete record whose primary key is custId
     *
     * @param custId
     */
    public void delRecord(String custId) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        try {
            // get connection
            cnnct = getConnection();

            // precompiled query statement
//            String preQueryStatement = "DELETE FROM customer " +
//                    "WHERE CustId = ?";
            // get statement
            pStmnt = cnnct.prepareStatement(delRecordSQL);

            // set individual parameter
            pStmnt.setString(1, custId);

            /*
             * execute update query to delete record from the database table
             * with four fields: CustId, Name, Tel, Age
             *
             * return the number of records deleted
             */
            int rowCount = pStmnt.executeUpdate();

            /*
             * rowCount should be 1 if successful
             * cannot delete the record otherwise
             */
            if (rowCount == 0) {
                throw new SQLException("Cannot delete the row");
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    /**
     * edit a record whose primary key is custId
     *
     * @param custId
     * @param name
     * @param tel
     * @param age
     */
    public void editRecord(String custId, String name, String tel, int age) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        try {
            // get connection
            cnnct = getConnection();

            // precompiled query statement
//            String preQueryStatement = "UPDATE customer "
//                    + "SET Name = ?, Tel = ?, Age = ? WHERE CustId = ?";
            // get statement
            pStmnt = cnnct.prepareStatement(editRecordSQL);

            // set individual parameters
            pStmnt.setString(1, name);
            pStmnt.setString(2, tel);
            pStmnt.setInt(3, age);
            pStmnt.setString(4, custId);

            /*
             * execute update query to edit record in the database table
             * with four fields: Cust_Num, Name, Tel, Age
             *
             * return the number of records changed
             */
            int rowCount = pStmnt.executeUpdate();

            /*
             * rowCount should be 1 because using primary key
             * throw exception if we cannot modify the record
             */
            if (rowCount == 0) {
                throw new SQLException("Cannot modify the row");
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        } finally {
            // close Prepared Statement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    // Query methods
    /**
     * query the details of all customer via field name
     */
    public void displayAllRecordsByField() {
        Connection cnnct = null;
        Statement stmnt = null;

        // create a ResultSet object to hold the query results
        ResultSet rslt = null;

        String custId;
        String custName;
        String custTel;
        int custAge;

        try {
            // get connection
            cnnct = getConnection();
            // get statement
            stmnt = cnnct.createStatement();

            /**
             * execute query to get query result and hold it using the ResultSet
             * object
             */
            rslt = stmnt.executeQuery(findAllSQL);

            // loops through all returned records in ResultSet
            int i = 0;
            while (rslt.next()) {
                if (i == 0) {
                    System.out.println("Num\tCust_Id\t\tName\t\t\t"
                            + "\tTelephone\tAge");
                }
                i = i + 1;

                // get the value using the actual field name, CustId
                custId = rslt.getString("CustId");
                // get the value using the field name, Name
                custName = rslt.getString("Name");
                // get the value using the field name, Tel
                custTel = rslt.getString("Tel");
                // get the value using the field name, Age
                custAge = rslt.getInt("Age");

                // String custId = rslt.getString("Customer_Num");
                // String custName = rslt.getString("Name");
                System.out.println(i + "\t" + custId + "\t\t" + custName
                        + "\t" + custTel + "\t" + custAge);
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        } finally {
            // close ResultSet object
            if (rslt != null) {
                try {
                    rslt.close();
                } catch (SQLException e) {
                }
            }

            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    /**
     * query the details of all customers by column number
     */
    public void displayAllRecordsByColumn() {
        Connection cnnct = null;
        Statement stmnt = null;
        ResultSet rslt = null;

        String custId;
        String custName;
        String custTel;
        int custAge;

        try {
            // get connection
            cnnct = getConnection();
            // get statement
            stmnt = cnnct.createStatement();
            // execute query to get result set
            rslt = stmnt.executeQuery(findAllSQL);

            // loops through all returned records in ResultSet
            int i = 0;
            while (rslt.next()) {
                if (i == 0) {
                    System.out.println("Num\tCust_Id\t\tName\t\t\t\tTelephone\tAge");
                }

                i = i + 1;

                // custId is in the first column
                custId = rslt.getString(1);
                // Name is in the 2nd column
                custName = rslt.getString(2);
                // Tel is in the 3rd column
                custTel = rslt.getString(3);
                // Age is in the 4th column
                custAge = rslt.getInt(4);

                // String custId = rslt.getString("Customer_Num");
                // String custName = rslt.getString("Name");
                System.out.println(i + "\t" + custId + "\t\t" + custName
                        + "\t" + custTel + "\t" + custAge);
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        } finally {
            // close ResultSet object
            if (rslt != null) {
                try {
                    rslt.close();
                } catch (SQLException e) {
                }
            }

            // close Statement object
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    /**
     * query the details of a customer via Id
     *
     * @param tmpCustId
     */
    public void queryCustByCustId(String tmpCustId) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        ResultSet rslt = null;

        String custId;
        String custName;
        String custTel;
        int custAge;

        try {
            // get connection
            cnnct = getConnection();

            // precompiled query statement
//            String preQueryStatement = "SELECT * FROM customer WHERE CustId = ?";
            // get statement
            pStmnt = cnnct.prepareStatement(findRecordByPKSQL);

            // set individual parameter
            pStmnt.setString(1, tmpCustId);

            // execute query to get result set
            rslt = pStmnt.executeQuery();

            // loops through all returned records in ResultSet
            int i = 0;
            while (rslt.next()) {
                if (i == 0) {
                    System.out.println("Num\tCust_Id\t\tName\t\t\t\tTelephone\tAge");
                }
                i = i + 1;

                // custId is in the first column
                custId = rslt.getString("CustId");
                // Name is in the 2nd column
                custName = rslt.getString("Name");
                // Tel is in the 3rd column
                custTel = rslt.getString("Tel");
                // Age is in the 4th column
                custAge = rslt.getInt("Age");

                // String custId = rslt.getString("Customer_Num");
                // String custName = rslt.getString("Name");
                System.out.println(i + "\t" + custId + "\t\t" + custName
                        + "\t" + custTel + "\t" + custAge);
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        } finally {
            // close ResultSet object
            if (rslt != null) {
                try {
                    rslt.close();
                } catch (SQLException e) {
                }
            }

            // close PreparedStatement object
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }

            // close Connection object
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }
}
