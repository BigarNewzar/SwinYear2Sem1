/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ragib;

import entity.CustomerDTO;
import java.util.Scanner;
import javax.ejb.EJB;
import session.CustomerTransactionManagementRemote;

/**
 *
 * @author Ragib
 */
public class AppClient {

    @EJB
    private static CustomerTransactionManagementRemote customerTransactionManagement;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AppClient client = new AppClient();

        CustomerDTO customerDTOTest = new CustomerDTO("2","Ragib", "Tester", "Tester@google.com", "378 Riversdale Road", "Hawthorn", "3123", "1234567890", "10.5", "5", "Tester Comment", "TesterCredit Card", "1234567890123456", "0320", "376");

        client.addCustomerTransaction(customerDTOTest);

        System.out.println("Want to remove the customer transaction just added? (Y/N)");
        Scanner sc = new Scanner(System.in);
        char answer = sc.next().trim().toUpperCase().charAt(0);
        if (answer == 'Y') {
            client.removeCustomerTransaction(customerDTOTest);
        } else {
            // do nothing
        }
    }

    public void addCustomerTransaction(CustomerDTO customerDTO) {
        System.out.println("Adding a customer to the database: " + customerDTO.getFirstname() + " " + customerDTO.getFirstname());
        boolean result = customerTransactionManagement.addCusomterTransaction(customerDTO);
                if (result) {
            System.out.println("The operation is successful.");
        } else {
            System.out.println("The operation fails!");
        }
    }

    public void removeCustomerTransaction(CustomerDTO customerDTO) {
        System.out.println("Removing an employee from the database: " + customerDTO.getFirstname() + " " + customerDTO.getFirstname());

        boolean result = customerTransactionManagement.removeCustomerTransaction(customerDTO.getTransaction_id());
        
        if (result) {
            System.out.println("The remove operation is successful.");
        } else {
            System.out.println("The remove operation fails!");
        }
    }

}
