/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.sfsb;

import dto.CartItem;
import java.util.ArrayList;
import javax.ejb.Remote;//if error pops up here just add javaee 8 api library to the libraries than it can recognise "javax"

/**
 *
 * @author User
 */
@Remote
public interface ShopCartBeanRemote {

    ArrayList<CartItem> getCart();  

    boolean deleteCartItem(String itemId);

    boolean updateCartItem(CartItem cartItem);

    boolean addCartItem(CartItem cartItem);
}


