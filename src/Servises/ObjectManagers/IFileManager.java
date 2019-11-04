package Servises.ObjectManagers;

import Beans.ObjectCreator;
import Servises.ServiseException;

import java.util.ArrayList;

public interface IFileManager {
    void saveToFile(ArrayList<ArrayList<ObjectCreator>> listToSave, String fileName) throws ServiseException;
    ArrayList<ArrayList<ObjectCreator>> readFromFile(String fileName) throws ServiseException;
}
