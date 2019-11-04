package Servises.Comparators.ItemComparators;

import Beans.Item;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        if (item.getPrice() < t1.getPrice()) return -1;
        else if (item.getPrice()  > t1.getPrice() ) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "by Price";
    }
}
