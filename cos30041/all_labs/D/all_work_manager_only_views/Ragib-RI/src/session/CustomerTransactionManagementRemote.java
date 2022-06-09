/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Remote;
import entity.CustomerDTO;

@Remote
public interface CustomerTransactionManagementRemote {

    boolean hasCustomerTransaction(String transaction_id);

    boolean addCusomterTransaction(CustomerDTO customerDTO);

    CustomerDTO getCustomerTransactionDetails(String transaction_id);


}
