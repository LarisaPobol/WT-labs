package Controllers;

import Beans.ObjectCreator;
import Servises.Factory.ObjectCreatorFab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public interface IController {
    ArrayList<ObjectCreator> getCurrObjectsListByIndex(int listIndex);
    ArrayList<ArrayList<ObjectCreator>> getAllObjectsLists();
    ArrayList<ObjectCreatorFab> getObjectFactory();
    ArrayList<ArrayList<Comparator>> getComparatorFactory();
    void AddObject(int listIndex, ObjectCreator obj);
    ArrayList<ObjectCreator> addList();
    int getListIndexByObject(ObjectCreator obj);
    int search(int listIndex, String strToFind) throws IllegalAccessException;
    void DeleteObject(int listIndex, int index) throws IllegalAccessException;
    ObjectCreator getObjectByIndexes(int listIndex, int objIndex);
    ArrayList<ObjectCreator> GetSortedListOFCurrObjects(int listIndex, int comparatorIndex);
    void ReadFromSource(String sourceName);
    void WriteToSource(String sourceName);
}
