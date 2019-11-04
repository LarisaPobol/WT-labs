package Servises.Factory;

import Beans.ObjectCreator;

public abstract class ObjectCreatorFab {
    public abstract ObjectCreator Create();

    @Override
    public String toString() {
        return "Object";
    }
}
