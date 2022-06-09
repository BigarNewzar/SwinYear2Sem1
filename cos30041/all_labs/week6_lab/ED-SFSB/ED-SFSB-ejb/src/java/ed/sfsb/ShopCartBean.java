/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.sfsb;

import dto.CartItem;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Collections;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author User
 */
@Stateful
public class ShopCartBean implements ShopCartBeanRemote {

    private ArrayList<CartItem> cart;

    // private ArrayList<CartItem> cart2;
    public ShopCartBean() {
        cart = new ArrayList<CartItem>();
    }

    @Override
    public boolean addCartItem(CartItem cartItem) {
        boolean result = false;
        try {
            for (CartItem item : cart) {
                if (item.getItemId().equals(cartItem.getItemId())) {
                    item.setQuantity(cartItem.getQuantity() + item.getQuantity());

                    result = true;

                }

            }
            if (result != true) {
                cart.add(cartItem);

                result = true;
            }

        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    @Remove
    public void remove() {
        cart = null;
    }

    @Override
    public boolean deleteCartItem(String itemId) {

        boolean result = false;

        ArrayList<CartItem> cart2 = new ArrayList<CartItem>();
        for (CartItem item : cart) {
            if (item.getItemId().equals(itemId)) {

                cart2.add(item);

            }

        }
        if (!cart2.isEmpty()) {
            CartItem item2 = cart2.get(0);
            cart.remove(item2);
            result = true;
        }

        cart2.clear();

        return result;
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) {
        boolean result = false;

        for (CartItem item : cart) {
            if (item.getItemId().equals(cartItem.getItemId())) {
                item.setDescription(cartItem.getDescription());
                item.setQuantity(cartItem.getQuantity());
                item.setUnitPrice(cartItem.getUnitPrice());

                result = true;

            }

        }
        return result;
    }

}
