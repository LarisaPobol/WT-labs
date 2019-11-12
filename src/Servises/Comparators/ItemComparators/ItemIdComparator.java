package servises.comparators.itemComparators;

import beans.Item;
import java.util.Comparator;

/**
 * compares 2 objects of Item by id
 */
public class ItemIdComparator implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        if (item.getId() < t1.getId() ) return -1;
        else if (item.getId()  > t1.getId() ) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "by Id";
    }
}
