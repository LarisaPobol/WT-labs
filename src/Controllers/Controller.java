package Controllers;

import Beans.ObjectCreator;
import Servises.Comparators.ComparatorFactory;
import Servises.Factory.*;
import Servises.ObjectManagers.FactoryManager;
import Servises.ObjectManagers.FileManager;
import Servises.ObjectManagers.ObjectManager;
import Servises.ServiseException;

import java.util.ArrayList;
import java.util.Comparator;

public class Controller implements  IController{
    private ObjectManager objectManager;
    private FileManager fileManager;
    private FactoryManager factoryManager;
    private ComparatorFactory comparatorFactory;


    public Controller() {
        objectManager = new ObjectManager();
        fileManager = new FileManager();
        factoryManager = new FactoryManager();
        comparatorFactory = new ComparatorFactory();
    }

    @Override
    public ArrayList<ObjectCreator> getCurrObjectsListByIndex(int listIndex) {
        return objectManager.getListByIndex(listIndex);
    }

    @Override
    public ArrayList<ArrayList<ObjectCreator>> getAllObjectsLists() {
        return objectManager.getAll();
    }

    @Override
    public ArrayList<ObjectCreatorFab> getObjectFactory() {
        return factoryManager.getFactory();
    }

    @Override
    public ArrayList<ArrayList<Comparator>> getComparatorFactory() {
        return comparatorFactory.getComparatorArray();
    }

    @Override
    public void AddObject(int listIndex, ObjectCreator obj) {
        objectManager.addElement(obj, listIndex);
    }

    @Override
    public ArrayList<ObjectCreator> addList()   {
        ArrayList<ObjectCreator> newList = objectManager.addList();
        return newList;
    }
    @Override
    public void DeleteObject(int listIndex, int index) {
        objectManager.deleteElement(listIndex, index);
    }

    @Override
    public ObjectCreator getObjectByIndexes(int listIndex, int objIndex) {
        return objectManager.getObjectByIndex(listIndex, objIndex);
    }

public  ObjectCreator search(int listIndex, ObjectCreator obj) throws IllegalAccessException {
return objectManager.search(listIndex, obj);
}

    @Override
    public ArrayList<ObjectCreator> GetSortedListOFCurrObjects(int listIndex, int comparatorIndex) {
        Comparator comparator = comparatorFactory.getNeededComparator(listIndex, comparatorIndex);
        return objectManager.getSortedList(listIndex, comparator);
    }

    @Override
    public void ReadFromSource(String sourceName) {
        ArrayList<ArrayList<ObjectCreator>> readedList = null;
        try {
           readedList = fileManager.readFromFile(sourceName);
           objectManager.set(readedList);
        }
        catch (ServiseException ex) {
        }
    }

    @Override
    public void WriteToSource(String sourceName) {
      try {
            fileManager.saveToFile(objectManager.getAll(), sourceName);
        }
        catch (ServiseException ex) {
        }
    }
}


