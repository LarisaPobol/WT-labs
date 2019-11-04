package Servises.Comparators.CatalogComparators;

import Beans.BonusCard;
import Beans.Catalog;

import java.util.Comparator;

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

