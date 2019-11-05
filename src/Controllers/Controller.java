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

public class Controller implements IController {
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

    /**
     * returns list of objects
     * @param listIndex index of needed list
     * @return arrayList with entered index
     */
    @Override
    public ArrayList<ObjectCreator> getCurrObjectsListByIndex(int listIndex) {
        return objectManager.getListByIndex(listIndex);
    }

    /**
     * return arrayList that contains all objects lists
     * @return
     */
    @Override
    public ArrayList<ArrayList<ObjectCreator>> getAllObjectsLists() {
        return objectManager.getAll();
    }

    /**
     * return object factory
     * @return
     */
    @Override
    public ArrayList<ObjectCreatorFab> getObjectFactory() {
        return factoryManager.getFactory();
    }

    /**
     *return arrayList of comparators
     * @return
     */
    @Override
    public ArrayList<ArrayList<Comparator>> getComparatorFactory() {
        return comparatorFactory.getComparatorArray();
    }

    /**
     * adds new object to arrayList with needed index
     * @param listIndex index of arrayList
     * @param obj object to add
     */
    @Override
    public void AddObject(int listIndex, ObjectCreator obj) {
        objectManager.addElement(obj, listIndex);
    }

    /**
     * adds new ArrayList to ArrayList of ArrayLists of ObjectCreator
     * @return added list
     */
    @Override
    public ArrayList<ObjectCreator> addList() {
        ArrayList<ObjectCreator> newList = objectManager.addList();
        return newList;
    }

    /**
     * deletes objects with entered index in ArrayList with entered index from ArrayList<ArrayList<OjectCreator>>
     * @param listIndex index of ArrayList
     * @param index index of object
     * @throws IllegalAccessException
     */
    @Override
    public void DeleteObject(int listIndex, int index) throws IllegalAccessException {
        objectManager.deleteElement(listIndex, index);
    }

    /**
     * return object with entered index in ArrayList with entered index from ArrayList<ArrayList<OjectCreator>>
     * @param listIndex index of ArrayList
     * @param objIndex index of object
     * @return object ObjectCreator
     */
    @Override
    public ObjectCreator getObjectByIndexes(int listIndex, int objIndex) {
        return objectManager.getObjectByIndex(listIndex, objIndex);
    }

    /**
     * search for object that equals to entered string
     * @param listIndex index of ArrayList
     * @param strToFind string to compare with object
     * @return index of founded object, if such object does not exists returns -1
     * @throws IllegalAccessException
     */
    @Override
    public int search(int listIndex, String strToFind) throws IllegalAccessException {
        return objectManager.search(listIndex, strToFind);
    }


    @Override
    public int getListIndexByObject(ObjectCreator obj) {
        return objectManager.getListIndexByObject(obj);
    }

    @Override
    public ArrayList<ObjectCreator> GetSortedListOFCurrObjects(int listIndex, int comparatorIndex) {
        Comparator comparator = comparatorFactory.getNeededComparator(listIndex, comparatorIndex);
        return objectManager.getSortedList(listIndex, comparator);
    }

    /**
     * reads data from  sourse and sets it in objectManager
     * @param sourceName name of sourse
     */
    @Override
    public void ReadFromSource(String sourceName) {
        ArrayList<ArrayList<ObjectCreator>> readedList = null;
        try {
            readedList = fileManager.readFromFile(sourceName);
            objectManager.set(readedList);
        } catch (ServiseException ex) {
        }
    }

    /**
     * writes data to sourse
     * @param sourceName name of sourse
     */
    @Override
    public void WriteToSource(String sourceName) {
        try {
            fileManager.saveToFile(objectManager.getAll(), sourceName);
        } catch (ServiseException ex) {
        }
    }
}


