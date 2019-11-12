package controllers;

import beans.ObjectCreator;
import servises.comparators.ComparatorFactory;
import servises.factory.*;
import servises.objectManagers.FactoryManager;
import servises.objectManagers.FileManager;
import servises.objectManagers.ObjectManager;
import servises.ServiseException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * main controller, deals with object's and comparator's factories and input/output conrollers
 */
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
    public List getCurrObjectsListByIndex(int listIndex) {
        return objectManager.getListByIndex(listIndex);
    }

    /**
     * return List that contains all objects lists
     * @return list of objects
     */
    @Override
    public List getAllObjectsLists() {
        return objectManager.getAll();
    }

    /**
     * return object factory
     * @return list of object's factories
     */
    @Override
    public List getObjectFactory() {
        return factoryManager.getFactory();
    }

    /**
     *return arrayList of comparators
     * @return list of comparators
     */
    @Override
    public List getComparatorFactory() {
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
    public List addList() {
        ArrayList<ObjectCreator> newList = objectManager.addList();
        return newList;
    }

    /**
     * deletes objects with entered index in ArrayList with entered index from ArrayList of ArrayList of ObjectCreator
     * @param listIndex index of List
     * @param index index of object
     * @throws  ControllerException
     */
    @Override
    public void deleteObject(int listIndex, int index) throws ControllerException {
        try {
            objectManager.deleteElement(listIndex, index);
        }
        catch (ServiseException e) {
            throw new ControllerException("Error while deleting object! Please try again");
        }
    }

    /**
     * return object with entered index in ArrayList with entered index from ArrayList of ArrayList of OjectCreator
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
     */
    @Override
    public int search(int listIndex, String strToFind)  {
        return objectManager.search(listIndex, strToFind);
    }


    @Override
    public int getListIndexByObject(ObjectCreator obj) {
        return objectManager.getListIndexByObject(obj);
    }

    @Override
    public List getSortedListOFCurrObjects(int listIndex, int comparatorIndex) {
        Comparator comparator = comparatorFactory.getNeededComparator(listIndex, comparatorIndex);
        return objectManager.getSortedList(listIndex, comparator);
    }

    /**
     * reads data from  sourse and sets it in objectManager
     * @param sourceName name of sourse
     *@throws  ControllerException
     */
    @Override
    public void readFromSource(String sourceName) throws ControllerException {
        ArrayList<ArrayList<ObjectCreator>> readedList = null;
        try {
            readedList = ( ArrayList<ArrayList<ObjectCreator>> ) fileManager.readFromFile(sourceName);
            objectManager.set(readedList);
        } catch (ServiseException ex) {
throw new ControllerException("Error while reading data from sourse! Try again please");
        }
    }

    /**
     * writes data to sourse
     * @param sourceName name of sourse
     *@throws  ControllerException
     */
    @Override
    public void writeToSource(String sourceName) throws ControllerException {
        try {
            fileManager.saveToFile(objectManager.getAll(), sourceName);
        } catch (ServiseException ex) {
            throw new ControllerException("Error while writing data to sourse! Try again please");
        }
    }
}


