package Servises.Comparators.ShoppingCartComparators;

import Beans.ShoppingCart;

import java.util.Comparator;

public class ShoppingCartIdComparator implements Comparator<ShoppingCart> {
    @Override
    public int compare(ShoppingCart shoppingCart, ShoppingCart t1) {
        if (shoppingCart.getId() < t1.getId()) return -1;
        else if (shoppingCart.getId() > t1.getId()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "by Id";
    }
}
