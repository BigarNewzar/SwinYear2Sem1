/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ragib.jdbc;

import java.security.MessageDigest;
import java.util.ArrayList;

/**
 *
 * @author Ragib
 */
public class MakeCustomerDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // the database object to access the actual database
        CustomerDB db = new CustomerDB();

        // make sure no name conflicts
        try {
            db.destroyDBTable();
        } catch (Exception ex) {
        }

        // create the database table
        System.out.println("Create an empty database table Customer");
        db.createDBTable();
        
        System.out.println("Add several static records in the database table");
        
        // prepare data
        Customer cust001 = new Customer("1","Ragib", "Tester", "Tester@google.com", "378 Riversdale Road", "Hawthorn", "3123", "1234567890", "10.5", "5", "Tester Comment", "TesterCredit Card", "1234567890123456", "0320", "376");
        
        
        // prepare list
        ArrayList<Customer> custList = new ArrayList<>();
        custList.add(cust001);
       
        
        // add data to db
        db.addRecords(custList);
        
        
        
    }
    
    
    public static String makeSHA(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes("UTF-8"));
            
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString(); 
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
