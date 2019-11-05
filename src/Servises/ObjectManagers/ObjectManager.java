package Servises.ObjectManagers;

import Beans.*;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * class that manages objects
 */
public class ObjectManager implements IObjectManager, Serializable {
    private ArrayList<ArrayList<ObjectCreator>> listObjects;

    public ObjectManager() {
        listObjects = new ArrayList<ArrayList<ObjectCreator>>();
    }

    @Override
    public void addElement(ObjectCreator obj, int listIndex) {
        listObjects.get(listIndex).add(obj);
    }

    @Override
    public ArrayList<ObjectCreator> addList() {
        ArrayList<ObjectCreator> newList = new ArrayList<ObjectCreator>();
        listObjects.add(newList);
        return newList;
    }

    @Override
    public void deleteElement(int listIndex, int index) throws IllegalAccessException {
        ObjectCreator objForDel = listObjects.get(listIndex).get(index);
        for (ArrayList<ObjectCreator> list : listObjects
        ) {
            Iterator<ObjectCreator> it = list.iterator();
            while (it.hasNext()) {
                ObjectCreator objectInList = it.next();
               // delete(objectInList, objForDel, it);
                delete(objForDel, objectInList, it);
            }
        }
        listObjects.get(listIndex).remove(objForDel);
    }

    private void delete(ObjectCreator objectInList, ObjectCreator objForDel, Iterator it) throws IllegalAccessException {
        Field[] objForDelFields = objForDel.getClass().getDeclaredFields();
        Class class1 = objectInList.getClass();
        int fieldIndex = -1;
        int i = 0;
        boolean containField = false;
        while ((i < objForDelFields.length) && (!containField)) {
            if (objForDelFields[i].getType() == class1) {
                fieldIndex = i;
                containField = true;
            }
            i++;
        }
        if (fieldIndex != -1) {
            objForDelFields[fieldIndex].setAccessible(true);
            if (objForDelFields[fieldIndex].get(objForDel) == objectInList) {
                it.remove();
            }
        }
    }

    @Override
    public ArrayList<ArrayList<ObjectCreator>> getAll() {
        return listObjects;
    }

    @Override
    public ArrayList<ObjectCreator> getListByIndex(int listIndex) {
        return listObjects.get(listIndex);
    }

    @Override
    public void set(ArrayList<ArrayList<ObjectCreator>> newList) {
        listObjects = newList;
    }

    @Override
    public ObjectCreator getObjectByIndex(int listIndex, int objIndex) {
        return listObjects.get(listIndex).get(objIndex);
    }

    @Override
    public int getListIndexByObject(ObjectCreator obj) {
        for (ArrayList<ObjectCreator> list:listObjects
             ) {
            if (list.indexOf(obj) != -1) {
                return listObjects.indexOf(list);
            }
        }
        return -1;
    }
    @Override
    public ArrayList<ObjectCreator> getSortedList(int listIndex, Comparator<ObjectCreator> comparator) {
        ArrayList<ObjectCreator> sortedList = listObjects.get(listIndex);
        Collections.sort(sortedList, comparator);
        return sortedList;
    }

    @Override
    public int search(int listIndex, String strToFind) throws IllegalAccessException {
        for (ObjectCreator b :listObjects.get(listIndex)) {
            if (b.toString().equals(strToFind)) return listObjects.get(listIndex).indexOf(b);
        }
        return -1;
    }
}

