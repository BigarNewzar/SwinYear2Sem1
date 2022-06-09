/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MyDB {

    public static Connection getConnection() throws SQLException,
            IOException {
        System.setProperty("jdbc.drivers",
                "org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost/sun-appserv-samples;create=true";
        String username = "APP";
        String password = "APP";
        return DriverManager.getConnection(url, username, password);
    }

    public void createMyuserTable() {
        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            stmnt.execute("CREATE TABLE MYUSER ( "
                    + " UserId CHAR(6) CONSTRAINT PK_CUSTOMER PRIMARY KEY, "
                    + " Name CHAR(30), Password CHAR(6), Email CHAR(30), "
                    + " Phone CHAR(10), Address CHAR(60), "
                    + " SecQn CHAR(60), SecAns CHAR(60))");
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    public void dropMyuserTable() {
        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            stmnt.execute("DROP TABLE MYUSER");
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    public void addRecords(ArrayList<Myuser> myUsers) {

        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement
                    = "INSERT INTO MYUSER VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            for (Myuser myuser : myUsers) {
                pStmnt.setString(1, myuser.getUserid());
                pStmnt.setString(2, myuser.getName());
                pStmnt.setString(3, myuser.getPassword());
                pStmnt.setString(4, myuser.getEmail());
                pStmnt.setString(5, myuser.getPhone());
                pStmnt.setString(6, myuser.getAddress());
                pStmnt.setString(7, myuser.getSecQn());
                pStmnt.setString(8, myuser.getSecAns());
                int rowCount = pStmnt.executeUpdate();
                if (rowCount == 0) {
                    throw new SQLException("Cannot insert records!");
                }
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    public boolean createRecord(Myuser myuser) {

        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();

            //maybe userid doesnt exist, make new record and make it true,
            //else give false
            ResultSet rs = null;
            rs = stmnt.executeQuery("SELECT * FROM MYUSER WHERE USERID = \'" + myuser.getUserid() + "\'");

            rs.next();

            if (rs.getRow() == 0) {
                stmnt.execute("INSERT INTO MYUSER Values (\'" + myuser.getUserid() + "\', \'" + myuser.getName() + "\', \'" + myuser.getPassword() + "\', \'" + myuser.getEmail() + "\', \'" + myuser.getPhone() + "\', \'" + myuser.getAddress() + "\', \'" + myuser.getSecQn() + "\', \'" + myuser.getSecAns() + "\' )");
                //must make sure order is correct

                //System.out.println("This is runnign to keep true");
                return true;

            } else {
                //System.out.println("This is runnign to make false");

                return false;

            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }

        //System.out.println("This is runnign to keep a as....");
        return false;

    }

    public Myuser getRecord(String userId) {

        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();

            //look for that userID, if found then return the record, else return null
            ResultSet rs = null;
            rs = stmnt.executeQuery("SELECT * FROM MYUSER WHERE USERID = \'" + userId + "\'");  //must use this technique, or else it doesnt understand its a string and instead does integar and char type mismatch error!
            Myuser myuser2 = null;

            if (rs.next()) {
                myuser2 = new Myuser(rs.getString("userId"), rs.getString("Name"), rs.getString("Phone"), rs.getString("Password"), rs.getString("Address"), rs.getString("Email"), rs.getString("SecQn"), rs.getString("SecAns"));

            } else {
                myuser2 = null;
            }

            return myuser2; //this doesnt show any visible output, but the instruction said to return the myuser object, so kept it here.
            //and put the system out parts in menu part

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;

    }

    public boolean updateRecord(Myuser myuser) {

        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();

            //look for that userID, if found then update the record and say true, else say false
            int rs = 0;

            //basically, it will return number of records updated and as long as its not zero, update has taken place
            rs = stmnt.executeUpdate("UPDATE MYUSER SET NAME=  \'" + myuser.getName() + " \', PASSWORD=  \'" + myuser.getPassword() + " \', Email=  \'" + myuser.getEmail() + " \', Phone=  \'" + myuser.getPhone() + " \',  Address=  \'" + myuser.getAddress() + " \', SECQN=  \'" + myuser.getSecQn() + " \',  SECANS=  \'" + myuser.getSecAns() + " \' WHERE USERID=  \'" + myuser.getUserid() + "\'");  //must use this technique, or else it doesnt understand its a string and instead does integar and char type mismatch error!

            if (rs != 0) {
                //System.out.println("This will give true");
                return true;

            } else {

                //System.out.println("This will give false");
                return false;
            }

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }

        //System.out.println("This will give ....");
        return false;

    }

    public boolean deleteRecord(String UserId) {

        Connection cnnct = null;
        Statement stmnt = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();

            //look for that userID, if found then delete the record and return true, otherwise return false
            int rs = 0;
            rs = stmnt.executeUpdate(" DELETE FROM MYUSER WHERE USERID=  \'" + UserId + "\'");

            if (rs != 0) {
                //System.out.println("This will give true");
                return true;

            } else {
                //System.out.println("This will give false");
                return false;
            }

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        //System.out.println("This will give overall...");
        return false;

    }
}
