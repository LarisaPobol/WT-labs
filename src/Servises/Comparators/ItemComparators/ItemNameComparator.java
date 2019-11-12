package servises.comparators.itemComparators;

import beans.Item;

import java.util.Comparator;

/**
 * compares 2 objects of Item by name
 */
public class ItemNameComparator implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        return item.getName().compareTo(t1.getName());
    }

    @Override
    public String toString() {
        return "by Name";
    }
}
