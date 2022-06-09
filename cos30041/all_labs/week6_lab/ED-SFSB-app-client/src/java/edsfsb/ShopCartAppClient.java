/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edsfsb;

import dto.CartItem;
import ed.sfsb.ShopCartBeanRemote;
import java.util.ArrayList;
import java.util.Scanner;
import javax.ejb.EJB;

/**
 *
 * @author User
 */
public class ShopCartAppClient {

    @EJB
    private static ShopCartBeanRemote shopCart;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShopCartAppClient appClient = new ShopCartAppClient();
        // show that the shopCart is empty
        appClient.displayCart();
        // assuming they are selected by the user
        CartItem item1 = new CartItem("000001", "Intel Core i7 CPU", 349.99, 2);
        CartItem item2 = new CartItem("000002", "Intel SSD 512GB", 299.99, 3);
        appClient.addCart(item1);
        //appClient.addCart(item1);
        appClient.displayCart();
        appClient.addCart(item2);
        appClient.displayCart();
        
        

        Menu(appClient);
    }

    public static void Menu(ShopCartAppClient appClient) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        System.out.println("Type the number to perform the desired action:");
        while (option != 4) {
            System.out.println("1: Testing both Add Item cases to Cart");
            System.out.println("2: Testing Delete Item from Cart");
            System.out.println("3: Testing Update Item in Cart");

            System.out.println("4: Exit");
            System.out.print("\nPlease select an option (1-4): ");
            option = sc.nextInt();
            sc.nextLine(); //skip ‘\n

// fix this part for all cases 1 to 4 so that it can do the task
//take help from your copy and lab notes for that
//..............................
            switch (option) {
                case 1:
                    //just doing static adding just to simplify stuff

                    System.out.println("Enter the itemID:");
                    Scanner itemIdinput10 = new Scanner(System.in);
                    String itemId10 = itemIdinput10.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the item description:");
                    Scanner itemDescinput10 = new Scanner(System.in);
                    String itemDesc10 = itemDescinput10.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the item price:");
                    Scanner itemPriceinput10 = new Scanner(System.in);
                    double itemPrice10 = itemPriceinput10.nextDouble();    //see if it actually reads in the line

                    System.out.println("Enter the item Quantity:");
                    Scanner itemQuantityinput10 = new Scanner(System.in);
                    int itemQuantity10 = itemQuantityinput10.nextInt();    //see if it actually reads in the line

                    CartItem item10 = new CartItem(itemId10, itemDesc10, itemPrice10, itemQuantity10);

                    boolean outcome1 = appClient.shopCart.addCartItem(item10);

                    if (outcome1 == true) {
                        System.out.println("Item Successfully added to cart");

                    } else {
                        System.out.println("Item not added to cart");

                    }

                    appClient.displayCart();

                    break;
                case 2:
                    System.out.println("ItemID:");
                    Scanner itemIdinput11 = new Scanner(System.in);
                    String itemId11 = itemIdinput11.nextLine();    //see if it actually reads in the line

                    boolean outcome2 = appClient.shopCart.deleteCartItem(itemId11);

                    if (outcome2 == true) {
                        System.out.println("Deleted Successfully");
                    } else {
                        System.out.println("Failed to delete");
                    }

                    appClient.displayCart();

                    break;
                case 3:
                    System.out.println("Enter the itemID:");
                    Scanner itemIdinput12 = new Scanner(System.in);
                    String itemId12 = itemIdinput12.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter new item description:");
                    Scanner itemDescinput12 = new Scanner(System.in);
                    String itemDesc12 = itemDescinput12.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter new item price:");
                    Scanner itemPriceinput12 = new Scanner(System.in);
                    double itemPrice12 = itemPriceinput12.nextDouble();    //see if it actually reads in the line

                    System.out.println("Enter new item Quantity:");
                    Scanner itemQuantityinput12 = new Scanner(System.in);
                    int itemQuantity12 = itemQuantityinput12.nextInt();    //see if it actually reads in the line

                    CartItem item12 = new CartItem(itemId12, itemDesc12, itemPrice12, itemQuantity12);

                    boolean outcome3 = appClient.shopCart.updateCartItem(item12);

                    if (outcome3 == true) {
                        System.out.println("Item Successfully updated");

                    } else {
                        System.out.println("Item not updated");

                    }

                    appClient.displayCart();
                    break;

            }
        }//end while

    }

    private void addCart(CartItem item) {
        System.out.println("Adding item " + item.getDescription() + " to cart");
        if (shopCart.addCartItem(item)) {
            System.out.println("Your order of " + item.getQuantity()
                    + " " + item.getDescription() + " has been added.");
        } else {
            System.out.println("Sorry, your order of " + item.getQuantity() + " "
                    + item.getDescription() + " cannot be added due to low stock.");
        }
    }

    public void displayCart() {
        ArrayList<CartItem> ciList = shopCart.getCart();
        if (ciList.isEmpty()) {
            System.out.println("The shopping cart is empty!");
            return;
        }
        System.out.println("Your shopping cart has the following items:");
        double total = 0.0;
        for (CartItem ci : ciList) {
            double unitPrice = ci.getUnitPrice();
            double quantity = ci.getQuantity();
            double subTotal = unitPrice * quantity;
            System.out.println("Item: " + ci.getDescription()
                    + "\tUnit Price: " + ci.getUnitPrice()
                    + "\tQuantity: " + ci.getQuantity()
                    + "\tSub-Total: " + subTotal);
            total = total + subTotal;
        }
        System.out.println("---");
        System.out.println("Total price: " + total);
        System.out.println("----End of Shopping Cart---");
    }

}
