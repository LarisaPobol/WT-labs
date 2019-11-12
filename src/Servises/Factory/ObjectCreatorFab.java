package servises.factory;

import beans.ObjectCreator;

/**
 * factory for ObjectCreator(base type of objects)
 */
public abstract class ObjectCreatorFab {
    public abstract ObjectCreator create();

    @Override
    public String toString() {
        return "Object";
    }
}
