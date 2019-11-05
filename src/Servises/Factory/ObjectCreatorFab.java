package Servises.Factory;

import Beans.ObjectCreator;

/**
 * Object factory
 */
public abstract class ObjectCreatorFab {
    public abstract ObjectCreator Create();

    @Override
    public String toString() {
        return "Object";
    }
}
