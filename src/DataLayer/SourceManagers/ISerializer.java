package dataLayer.sourceManagers;

import beans.ObjectCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * interface for data layer
 */
public interface ISerializer {
    void serialize(List listToSerialize, String FileName) throws IOException, DataLayerException;
    List deserialize(String fileName) throws DataLayerException;
}
