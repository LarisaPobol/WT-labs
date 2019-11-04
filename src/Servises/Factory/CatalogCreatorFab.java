package Servises.Factory;

import Beans.Catalog;
import Beans.ObjectCreator;

public class CatalogCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator Create() {
        return new Catalog();
    }

    @Override
    public String toString() {
        return "Catalog";
    }
}
