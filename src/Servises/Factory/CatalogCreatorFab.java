package servises.factory;

import beans.Catalog;
import beans.ObjectCreator;

/**
 * factory for Catalog
 */
public class CatalogCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator create() {
        return new Catalog();
    }

    @Override
    public String toString() {
        return "Catalog";
    }
}
