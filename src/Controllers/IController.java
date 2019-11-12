package controllers;

import beans.ObjectCreator;
import servises.factory.ObjectCreatorFab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * interface of main controller
 */
public interface IController {
    List<ObjectCreator> getCurrObjectsListByIndex(int listIndex);
    List<List<ObjectCreator>> getAllObjectsLists();
    List<ObjectCreatorFab> getObjectFactory();
    List<List<Comparator>> getComparatorFactory();
    void AddObject(int listIndex, ObjectCreator obj);
    List<ObjectCreator> addList();
    int getListIndexByObject(ObjectCreator obj);
    int search(int listIndex, String strToFind) throws IllegalAccessException;
    void deleteObject(int listIndex, int index) throws IllegalAccessException, ControllerException;
    ObjectCreator getObjectByIndexes(int listIndex, int objIndex);
    List<ObjectCreator> getSortedListOFCurrObjects(int listIndex, int comparatorIndex);
    void readFromSource(String sourceName) throws ControllerException;
    void writeToSource(String sourceName) throws ControllerException;
}
