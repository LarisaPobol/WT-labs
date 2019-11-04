package DataLayer.SourceManagers;

import Beans.ObjectCreator;

import java.io.IOException;
import java.util.ArrayList;

public interface ISerializer {
    void Serialize( ArrayList<ArrayList<ObjectCreator>> listToSerialize, String FileName) throws IOException, DataLayerException;
    ArrayList<ArrayList<ObjectCreator>> Deserialize(String fileName) throws DataLayerException;
}
