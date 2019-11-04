package Servises.Factory;

import Beans.ObjectCreator;
import Beans.ShoppingCart;

public class ShoppingCartCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator Create() {
        return new ShoppingCart();
    }

    @Override
    public String toString() {
        return "Shopping Cart";
    }
}
