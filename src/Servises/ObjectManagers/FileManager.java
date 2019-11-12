package servises.objectManagers;

import beans.ObjectCreator;
import dataLayer.sourceManagers.DataLayerException;
import dataLayer.sourceManagers.Serializer;
import servises.ServiseException;

import java.util.ArrayList;
import java.util.List;

/**
 * class that uses serializer to deal with files
 */
public class FileManager  implements  IFileManager{
    private Serializer serializer;
    public FileManager() {
        serializer = new Serializer();
    }

    @Override
    public void saveToFile(List listToSave, String fileName) throws ServiseException {
        try {
            serializer.serialize(listToSave, fileName);
        }
        catch (DataLayerException ex) {
            throw new ServiseException(ex);
        }
    }

    @Override
    public List readFromFile(String fileName) throws ServiseException {
        try {
            return serializer.deserialize(fileName);
        }
        catch (DataLayerException ex) {
            throw new ServiseException(ex);
        }
    }
}
