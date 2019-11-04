package Servises.Comparators.CatalogComparators;

import Beans.Catalog;

import java.util.Comparator;

public class CatalogParentCatalogComparator implements Comparator<Catalog> {

    @Override
    public int compare(Catalog catalog, Catalog t1) {
       return catalog.getParentCatalog().getName().compareTo(t1.getParentCatalog().getName());
    }

    @Override
    public String toString() {
        return "by Parent Catalog";
    }
}
