package servises.objectManagers;

import beans.ObjectCreator;
import servises.ServiseException;

import java.util.ArrayList;
import java.util.List;

public interface IFileManager {
    void saveToFile(List listToSave, String fileName) throws ServiseException;
    List readFromFile(String fileName) throws ServiseException;
}
