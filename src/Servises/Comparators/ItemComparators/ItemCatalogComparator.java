package Servises.Comparators.ItemComparators;

import Beans.Item;

import java.util.Comparator;

public class ItemCatalogComparator implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        return item.getCatalog().getName().compareTo(t1.getCatalog().getName());
    }

    @Override
    public String toString() {
        return "by Catalog";
    }
}
