package Servises.ObjectManagers;

import Beans.*;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
    public void deleteElement(int listIndex, int index) {
        listObjects.get(listIndex).remove(index);
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
    public ArrayList<ObjectCreator> getSortedList(int listIndex, Comparator<ObjectCreator> comparator) {
        ArrayList<ObjectCreator> sortedList = listObjects.get(listIndex);
        Collections.sort(sortedList, comparator);
        return sortedList;
    }

    @Override
    public ObjectCreator search(int listIndex, ObjectCreator obj) throws IllegalAccessException {
        ArrayList<Class> classArray = new ArrayList<Class>(
                Arrays.asList(BonusCard.class, Catalog.class, Customer.class, Item.class, RegularCustomer.class, ShoppingCart.class)
        );
        ArrayList<ObjectCreator> listForSearch = new ArrayList<ObjectCreator>(listObjects.get(listIndex));
        Class objClass = obj.getClass();
        Field[] objFields = objClass.getDeclaredFields();
        for (Field field : objFields
        ) {
            field.setAccessible(true);

            if (field.get(obj) != null && field.get(obj) != " ") {
                int i = 0;
                for (i = 0; i < listForSearch.size(); i++) {
                    if (field.get(obj) != field.get(listForSearch.get(i))) {
                        listForSearch.remove(listForSearch.get(i));

                    }
                }
            }
       /* for (Field field : objFields
        ) {
            field.setAccessible(true);
            if (field.get(obj) != null) {
                for (ObjectCreator objInList : listForSearch
                ) {
                    if (field.get(obj) != field.get(objInList)) {
                        listForSearch.remove(objInList);
                    }
                }
            }*/
/*    ArrayList<Class> classArray = new ArrayList<Class>(
            Arrays.asList(BonusCard.class, Catalog.class, Customer.class, Item.class, RegularCustomer.class, ShoppingCart.class)
    );
        ArrayList<ObjectCreator> listForSearch = listObjects.get(listIndex);
    for (ObjectCreator b : listForSearch) {
        ObjectCreator d = (ObjectCreator) classArray.get(listIndex).cast(b);
        if (d.equals(b)) return listForSearch.indexOf(b);
    }
    return -1;*/
        }
        if (listForSearch.size() != 0) {
            return listForSearch.get(0);
        } else {
            return null;
        }
        //return listForSearch;
    }
}

