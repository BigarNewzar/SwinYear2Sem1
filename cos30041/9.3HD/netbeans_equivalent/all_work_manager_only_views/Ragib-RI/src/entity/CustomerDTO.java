/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    String transaction_id;
    String firstname;
    String lastname;
    String email;
    String address;
    String suburb;
    String postcode;
    String phone;
    String product_name;
    String quantity;
    String comment;
    String credit_card_name;
    String credit_card_number;
    String credit_card_expiry_date;
    String credit_card_CVV;

    public CustomerDTO(String transaction_id, String firstname, String lastname, String email, String address, String suburb, String postcode, String phone, String product_name, String quantity, String comment, String credit_card_name, String credit_card_number, String credit_card_expiry_date, String credit_card_CVV) {
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhone() {
        return phone;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getComment() {
        return comment;
    }

    public String getCredit_card_name() {
        return credit_card_name;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public String getCredit_card_expiry_date() {
        return credit_card_expiry_date;
    }

    public String getCredit_card_CVV() {
        return credit_card_CVV;
    }
   
}