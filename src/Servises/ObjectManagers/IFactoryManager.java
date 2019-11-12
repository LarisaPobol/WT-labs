package servises.objectManagers;

import servises.factory.ObjectCreatorFab;

import java.util.ArrayList;

public interface IFactoryManager{
    ArrayList<ObjectCreatorFab> getFactory();
}
