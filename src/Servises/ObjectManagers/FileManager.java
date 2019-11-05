package Servises.ObjectManagers;

import Beans.ObjectCreator;
import DataLayer.SourceManagers.DataLayerException;
import DataLayer.SourceManagers.ISerializer;
import DataLayer.SourceManagers.Serializer;
import Servises.ServiseException;

import java.util.ArrayList;

/**
 * class that uses serializer to deal with files
 */
public class FileManager  implements  IFileManager{
    private Serializer serializer;
    public FileManager() {
        serializer = new Serializer();
    }

    @Override
    public void saveToFile(ArrayList<ArrayList<ObjectCreator>> listToSave, String fileName) throws ServiseException {
        try {
            serializer.Serialize(listToSave, fileName);
        }
        catch (DataLayerException ex) {
            throw new ServiseException(ex);
        }
    }

    @Override
    public ArrayList<ArrayList<ObjectCreator>> readFromFile(String fileName) throws ServiseException {
        try {
            return serializer.Deserialize(fileName);
        }
        catch (DataLayerException ex) {
            throw new ServiseException(ex);
        }
    }
}
