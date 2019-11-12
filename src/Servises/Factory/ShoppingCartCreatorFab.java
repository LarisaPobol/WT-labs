package servises.factory;

import beans.ObjectCreator;
import beans.ShoppingCart;

/**
 * factory for ShoppingCart
 */
public class ShoppingCartCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator create() {
        return new ShoppingCart();
    }

    @Override
    public String toString() {
        return "Shopping Cart";
    }
}
