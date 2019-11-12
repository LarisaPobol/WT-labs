package servises.comparators.catalogComparators;

import beans.Catalog;

import java.util.Comparator;

/**
 * compares 2 objects of Catalog by name
 */
public class CatalogNameComparator implements Comparator<Catalog> {
    @Override
    public String toString() {
        return "by Name";
    }

    @Override
    public int compare(Catalog catalog, Catalog t1) {
        return catalog.getName().compareTo(t1.getName());
    }
}

