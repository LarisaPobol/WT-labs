package servises.comparators.itemComparators;

import beans.Item;

import java.util.Comparator;

/**
 * compares 2 objects of Item by catalog's name
 */
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
