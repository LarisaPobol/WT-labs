package Servises.Factory;

import Beans.Item;
import Beans.ObjectCreator;

public class ItemCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator Create() {
        return new Item();
    }

    @Override
    public String toString() {
        return "Item";
    }
}
