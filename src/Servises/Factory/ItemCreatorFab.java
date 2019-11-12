package servises.factory;

import beans.Item;
import beans.ObjectCreator;

/**
 * factory for Item
 */
public class ItemCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator create() {
        return new Item();
    }

    @Override
    public String toString() {
        return "Item";
    }
}
