/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import entity.Customer;
import entity.CustomerDTO;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

@DeclareRoles({"RAGIB-ADMIN"})
@Stateless
public class CustomerTransactionManagement implements CustomerTransactionManagementRemote {

    @EJB
    private CustomerFacadeLocal customerFacade;

    private Customer customerDTO2Entity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            // just in case
            return null;
        }

        String transaction_id = customerDTO.getTransaction_id();
        String firstname = customerDTO.getFirstname();
        String lastname = customerDTO.getLastname();
        String email = customerDTO.getEmail();
        String address = customerDTO.getAddress();
        String suburb = customerDTO.getSuburb();
        String postcode = customerDTO.getPostcode();
        String phone = customerDTO.getPhone();
        String price = customerDTO.getPrice();
        String quantity = customerDTO.getQuantity();
        String comment = customerDTO.getComment();
        String credit_card_name = customerDTO.getCredit_card_name();
        String credit_card_number = customerDTO.getCredit_card_number();
        String credit_card_expiry_date = customerDTO.getCredit_card_expiry_date();
        String credit_card_CVV = customerDTO.getCredit_card_CVV();

        Customer customer = new Customer(transaction_id, firstname, lastname, email, address, suburb, postcode, phone, price, quantity, comment, credit_card_name, credit_card_number, credit_card_expiry_date, credit_card_CVV);

        return customer;
    }

    private CustomerDTO customerEntity2DTO(Customer customer) {
        if (customer == null) {
            // just in case
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO(
                customer.getTransaction_id(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getSuburb(),
                customer.getPostcode(),
                customer.getPhone(),
                customer.getPrice(),
                customer.getQuantity(),
                customer.getComment(),
                customer.getCredit_card_name(),
                customer.getCredit_card_number(),
                customer.getCredit_card_expiry_date(),
                customer.getCredit_card_CVV()
        );

        return customerDTO;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * check whether the customer transaction is in the system
     *
     * @param transaction_id
     * @return true if the employee is in the system, false otherwise
     */
    @Override
    @PermitAll   //as customers need to check before adding thier transaction
    public boolean hasCustomerTransaction(String transaction_id) {
        return customerFacade.hasCustomerTransaction(transaction_id);
    }

    /**
     * add a customer transaction to the system
     *
     * @param customerDTO
     * @return true if addition is successful, false otherwise
     */
    @Override
    @PermitAll  //as cstomers need to be able to add thier transaction
    public boolean addCusomterTransaction(CustomerDTO customerDTO) {

        if (customerDTO == null) {
            // just in case
            return false;
        }

        // check customer exist?
        if (hasCustomerTransaction(customerDTO.getTransaction_id())) {
            // customer exists, cannot add one
            return false;
        }

        // customer not exist
        // convert to entity
        Customer customer = this.customerDTO2Entity(customerDTO);
        // add one
        return customerFacade.addCustomerTransaction(customer);
    }

    /**
     * update customer transaction details 
     *
     * @param customerDTO
     * @return true if update is successful, false otherwise
     */
    @Override
    @RolesAllowed({"RAGIB-ADMIN"})
    public boolean updateCustomerTransactionDetails(CustomerDTO customerDTO) {
        // check customer exist?
        if (!hasCustomerTransaction(customerDTO.getTransaction_id())) {
            return false;
        }

        // customer exist, update details
        // convert to entity class
        Customer customer = this.customerDTO2Entity(customerDTO);
        // update details
        return customerFacade.updateCustomerTransactionDetails(customer);
    }

    

    /**
     * get customer Transaction details and use a DTO to transmit the details
     *
     * @param transaction_id
     * @return a DTO containing the information of the customer if exists, null
     * otherwise
     */
    @Override
    @RolesAllowed({"RAGIB-ADMIN"})
    public CustomerDTO getCustomerTransactionDetails(String transaction_id) {
        // get the customer
        Customer customer = customerFacade.find(transaction_id);

        if (customer == null) {
            // not found - no such customer transaction
            return null;
        } else {
            // found - prepare details
           CustomerDTO customerDTO = new CustomerDTO(
                customer.getTransaction_id(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getSuburb(),
                customer.getPostcode(),
                customer.getPhone(),
                customer.getPrice(),
                customer.getQuantity(),
                customer.getComment(),
                customer.getCredit_card_name(),
                customer.getCredit_card_number(),
                customer.getCredit_card_expiry_date(),
                customer.getCredit_card_CVV());
        

            return customerDTO;
        }
    }

    
    /**
     * physically remove a customer transaction record from database
     *
     *
     * @param transaction_id
     * @return true if the record has been physically removed from the
     * database, false otherwise
     */
    @Override
    @RolesAllowed({"RAGIB-ADMIN"})
    public boolean removeCustomerTransaction(String transaction_id) {
        return customerFacade.removeCustomerTransaction(transaction_id);
    }

    

}
