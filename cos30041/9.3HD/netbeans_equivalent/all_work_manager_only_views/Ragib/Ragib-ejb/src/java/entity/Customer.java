/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Ragib_Customers", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByTransaction_id", query = "SELECT c FROM Customer c WHERE c.transaction_id = :transaction_id"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address"),
    @NamedQuery(name = "Customer.findBySuburb", query = "SELECT c FROM Customer c WHERE c.suburb = :suburb"),
    @NamedQuery(name = "Customer.findByPostcode", query = "SELECT c FROM Customer c WHERE c.postcode = :postcode"),

    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByProduct_Name", query = "SELECT c FROM Customer c WHERE c.product_name = :product_name"),
    @NamedQuery(name = "Customer.findByQuantity", query = "SELECT c FROM Customer c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "Customer.findByComment", query = "SELECT c FROM Customer c WHERE c.comment = :comment"),
    @NamedQuery(name = "Customer.findByCredit_Card_Name", query = "SELECT c FROM Customer c WHERE c.credit_card_name = :credit_card_name"),
    @NamedQuery(name = "Customer.findByCredit_Card_Number", query = "SELECT c FROM Customer c WHERE c.credit_card_number = :credit_card_number"),
    @NamedQuery(name = "Customer.findByCredit_Card_Expiry_Date", query = "SELECT c FROM Customer c WHERE c.credit_card_expiry_date = :credit_card_expiry_date"),
    @NamedQuery(name = "Customer.findByCredit_Card_CVV", query = "SELECT c FROM Customer c WHERE c.credit_card_CVV = :credit_card_CVV")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRANSACTION_ID")
    private String transaction_id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "SUBURB")
    private String suburb;
    @Column(name = "POSTCODE")
    private String postcode;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PRODUCT_NAME")
    private String product_name;
    @Column(name = "QUANTITY")
    private String quantity;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "CREDIT_CARD_NAME")
    private String credit_card_name;
    @Column(name = "CREDIT_CARD_NUMBER")
    private String credit_card_number;
    @Column(name = "CREDIT_CARD_EXPIRY_DATE")
    private String credit_card_expiry_date;
    @Column(name = "CREDIT_CARD_CVV")
    private String credit_card_CVV;

    public Customer() {
    }

    public Customer(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Customer(String transaction_id,
            String firstname,
            String lastname,
            String email,
            String address,
            String suburb,
            String postcode,
            String phone,
            String product_name,
            String quantity,
            String comment,
            String credit_card_name,
            String credit_card_number,
            String credit_card_expiry_date,
            String credit_card_CVV) {
        this.transaction_id = transaction_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.suburb = suburb;

        this.postcode = postcode;
        this.phone = phone;

        this.product_name = product_name;
        this.quantity = quantity;
        this.comment = comment;
        this.credit_card_name = credit_card_name;
        this.credit_card_number = credit_card_number;
        this.credit_card_expiry_date = credit_card_expiry_date;
        this.credit_card_CVV = credit_card_CVV;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    
     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.transaction_id == null && other.transaction_id != null) || (this.transaction_id != null && !this.transaction_id.equals(other.transaction_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.entity.Customer[ transaction_id=" + transaction_id + " ]";
    }

}
