/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import javax.ejb.Local;
import entity.Customer;


@Local
public interface CustomerFacadeLocal {

    Customer find(String id);

    boolean hasCustomerTransaction(String transaction_id);
    
    boolean addCustomerTransaction(Customer customer);   
    

}



