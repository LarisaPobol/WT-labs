package Servises.Comparators.CatalogComparators;

import Beans.Catalog;

import java.util.Comparator;

public class CatalogParentCatalogComparator implements Comparator<Catalog> {

    @Override
    public int compare(Catalog catalog, Catalog t1) {
        if ((catalog.getParentCatalog()!= null)&&(t1.getParentCatalog()!=null))
       return catalog.getParentCatalog().getName().compareTo(t1.getParentCatalog().getName());
        else return 0;
    }

    @Override
    public String toString() {
        return "by Parent Catalog";
    }
}
