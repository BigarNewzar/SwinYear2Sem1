/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import entity.CustomerDTO;
import session.CustomerTransactionManagementRemote;

@Named(value = "myCustomerManagedBean")
@ConversationScoped
public class MyCustomerManagedBean implements Serializable {

    @Inject
    private Conversation conversation;
    @EJB
    private CustomerTransactionManagementRemote customerTransactionManagement;

    private String transaction_id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String suburb;
    private String postcode;
    private String phone;

    private String product_name;
    private String quantity;
    private String comment;
    private String credit_card_name;
    private String credit_card_number;
    private String credit_card_expiry_date;
    private String credit_card_CVV;

    /**
     * Creates a new instance of MyCustomerManagedBean
     */
    public MyCustomerManagedBean() {
        transaction_id = null;
        firstname = null;
        lastname = null;
        email = null;
        address = null;
        suburb = null;
        postcode = null;
        phone = null;
        product_name = null;
        quantity = null;
        comment = null;
        credit_card_name = null;
        credit_card_number = null;
        credit_card_expiry_date = null;
        credit_card_CVV = null;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCredit_card_name() {
        return credit_card_name;
    }

    public void setCredit_card_name(String credit_card_name) {
        this.credit_card_name = credit_card_name;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public String getCredit_card_expiry_date() {
        return credit_card_expiry_date;
    }

    public void setCredit_card_expiry_date(String credit_card_expiry_date) {
        this.credit_card_expiry_date = credit_card_expiry_date;
    }

    public String getCredit_card_CVV() {
        return credit_card_CVV;
    }

    public void setCredit_card_CVV(String credit_card_CVV) {
        this.credit_card_CVV = credit_card_CVV;
    }

    public void startConversation() {
        conversation.begin();
    }

    public void endConversation() {
        conversation.end();
    }

    public String addCustomerTransaction() {

        // check transaction_id is null
        if (isNull(transaction_id)) {
            return "debug";
        }

        // all information seems to be valid
        // try add the customer transaction
        CustomerDTO customerDTO = new CustomerDTO(transaction_id, firstname, lastname, email, address, suburb, postcode, phone, product_name, quantity, comment, credit_card_name, credit_card_number, credit_card_expiry_date, credit_card_CVV);
        boolean result = customerTransactionManagement.addCusomterTransaction(customerDTO);
        if (result) {
             endConversation();
            return "success";
            
            
        } else {
            return "failure";
        }
       
    }


    
    private boolean isNull(String s) {
        return (s == null);
    }


    public String displayCustomerTransaction() {
        // check transaction_id is null
        if (isNull(transaction_id) || conversation == null) {
            return "debug";
        }

        return setCustomerTransactionDetails();
    }


    private String setCustomerTransactionDetails() {

        if (isNull(transaction_id) || conversation == null) {
            return "debug";
        }

        CustomerDTO c = customerTransactionManagement.getCustomerTransactionDetails(transaction_id);

        if (c == null) {
            // no such employee
            return "failure";
        } else {
            // found - set details for display

            this.transaction_id = c.getTransaction_id();

            this.firstname = c.getFirstname();
            this.lastname = c.getLastname();
            this.email = c.getEmail();
            this.address = c.getAddress();
            this.suburb = c.getSuburb();

            this.postcode = c.getPostcode();
            this.phone = c.getPhone();

            this.product_name = c.getProduct_name();
            this.quantity = c.getQuantity();
            this.comment = c.getComment();
            this.credit_card_name = c.getCredit_card_name();
            this.credit_card_number = c.getCredit_card_number();
            this.credit_card_expiry_date = c.getCredit_card_expiry_date();
            this.credit_card_CVV = c.getCredit_card_CVV();
            return "success";
        }
    }

    public String Enquire() {
        String result = "failure";

        if ((transaction_id != null) && (firstname != null) && (lastname != null) && (email != null) && (address != null) && (suburb != null) && (postcode != null) && (phone != null) && (product_name != null) && (quantity != null) && (comment != null)) {
            if (!customerTransactionManagement.hasCustomerTransaction(transaction_id)) {
                result = "success";
                // note the startConversation of the conversation
                startConversation();
            }
        }

        return result;

    }
    
    
}
