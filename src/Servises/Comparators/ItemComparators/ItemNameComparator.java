package Servises.Comparators.ItemComparators;

import Beans.Item;

import java.util.Comparator;

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
