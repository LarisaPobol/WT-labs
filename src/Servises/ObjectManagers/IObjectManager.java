package servises.objectManagers;

import beans.ObjectCreator;
import servises.ServiseException;

import java.util.ArrayList;
import java.util.Comparator;

public interface IObjectManager {
    void addElement(ObjectCreator obj, int listIndex) ;
    ArrayList<ObjectCreator> addList() ;
    void deleteElement(int listIndex, int index ) throws IllegalAccessException, ServiseException;
    ArrayList<ArrayList<ObjectCreator>> getAll();
    ArrayList<ObjectCreator> getListByIndex(int listIndex);
    public  int search(int listIndex, String strToFind) throws IllegalAccessException, ServiseException;
    ObjectCreator getObjectByIndex(int listIndex, int objIndex);
    void set(ArrayList<ArrayList<ObjectCreator>> newList);
    int getListIndexByObject(ObjectCreator obj);
    ArrayList<ObjectCreator> getSortedList(int listIndex, Comparator<ObjectCreator> comparator);
}
