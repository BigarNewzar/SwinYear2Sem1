/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Customer;


@Stateless
public class CustomerFacade implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "Ragib-ejbPU")
    private EntityManager em;

    public CustomerFacade() {
    }

    private void create(Customer entity) {
        em.persist(entity);
    }

    private void edit(Customer entity) {
        em.merge(entity);
    }

    private void remove(Customer entity) {
        em.remove(em.merge(entity));
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Customer find(String id) {
        return em.find(Customer.class, id);
    }

    /**
     * checks whether an customer exist using transaction_id
     *
     * @param transaction_id
     * @return true if exist, false otherwise
     */
    @Override
    public boolean hasCustomerTransaction(String transaction_id) {
        return (find(transaction_id) != null);
    }

    /**
     * add a customer's transaction to the system
     *
     * @param customer
     * @return true if addition is successful, false otherwise
     */
    @Override
    public boolean addCustomerTransaction(Customer customer) {
        // check again - just to play it safe
        Customer c = find(customer.getTransaction_id());
        
        if (c != null) {
            // could not add one
            return false;
        }

        create(customer);

        return true;
    }

    /**
     * update customer transaction details
     *
     * @param customer
     * @return true if update is successful, false otherwise
     */
    @Override
    public boolean updateCustomerTransactionDetails(Customer customer) {
        // find the customer, just in case
        Customer c = find(customer.getTransaction_id());
        
        if (c != null) {
            // could not add one
            return false;
        }

        // no need to update the primary key - transaction_id
        edit(customer);
        return true;
    }   

   
    /**
     * physically remove the customer transaction record from database table
     * 
     *
     * @param transaction_id
     * @return true if successful, false otherwise
     */
    @Override
    public boolean removeCustomerTransaction(String transaction_id) {
        // find the customer transaction
        Customer c = find(transaction_id);

        // check again - just to play it safe
        if (c == null) {
            return false;
        }

        em.remove(c);
        return true;
    }
}
