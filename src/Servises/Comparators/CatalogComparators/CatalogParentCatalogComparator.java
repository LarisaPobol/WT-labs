package servises.comparators.catalogComparators;

import beans.Catalog;

import java.util.Comparator;

/**
 * compares 2 objects of Catalog by parent catalog
 */
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
