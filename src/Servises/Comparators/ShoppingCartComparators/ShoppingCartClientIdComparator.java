package servises.comparators.shoppingCartComparators;

import beans.ShoppingCart;

import java.util.Comparator;

/**
 * compares 2 objects of ShoppingCart by client's id
 */
public class ShoppingCartClientIdComparator  implements Comparator<ShoppingCart> {
    @Override
    public int compare(ShoppingCart shoppingCart, ShoppingCart t1) {
        if (shoppingCart.getClientId() < t1.getClientId()) return -1;
        else if (shoppingCart.getClientId() > t1.getClientId()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "by Client Id";
    }
}
