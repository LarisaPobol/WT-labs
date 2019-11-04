package Servises.Comparators.ItemComparators;

import Beans.Item;

import java.util.Comparator;

public class ItemAmountComparator implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        if (item.getAmount() < t1.getAmount()) return -1;
        else if (item.getAmount() > t1.getAmount()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "by Amount";
    }
}
