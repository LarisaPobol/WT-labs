package servises.comparators.itemComparators;

import beans.Item;

import java.util.Comparator;

/**
 * compares 2 objects of Item by amount
 */
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
