package Servises.ObjectManagers;

import Servises.Factory.ObjectCreatorFab;

import java.util.ArrayList;

public interface IFactoryManager{
    ArrayList<ObjectCreatorFab> getFactory();
}
