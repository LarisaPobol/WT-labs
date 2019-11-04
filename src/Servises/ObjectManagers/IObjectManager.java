package Servises.ObjectManagers;

import Beans.ObjectCreator;

import java.util.ArrayList;
import java.util.Comparator;

public interface IObjectManager {
    void addElement(ObjectCreator obj, int listIndex) ;
    ArrayList<ObjectCreator> addList() ;
    void deleteElement(int listIndex, int index );
    ArrayList<ArrayList<ObjectCreator>> getAll();
    ArrayList<ObjectCreator> getListByIndex(int listIndex);
    public  ObjectCreator search(int listIndex, ObjectCreator obj) throws IllegalAccessException;
    ObjectCreator getObjectByIndex(int listIndex, int objIndex);
    void set(ArrayList<ArrayList<ObjectCreator>> newList);
    ArrayList<ObjectCreator> getSortedList(int listIndex, Comparator<ObjectCreator> comparator);
}
