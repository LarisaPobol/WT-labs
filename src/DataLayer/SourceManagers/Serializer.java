package DataLayer.SourceManagers;

import Beans.ObjectCreator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class Serializer implements ISerializer {
    /**
     * serializes data to XML
     * @param listToSerialize data to serialize
     * @param FileName name of file to save data
     * @throws DataLayerException
     */
    @Override
    public void Serialize(ArrayList<ArrayList<ObjectCreator>> listToSerialize, String FileName) throws DataLayerException {
      try {
          File file = new File(FileName);
          file.createNewFile();
          XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FileName)));
          out.writeObject(listToSerialize);
          out.flush();
          out.close();
        }
catch (IOException e) {
            e.printStackTrace();
            throw new DataLayerException(e);
        }
    }

    /**
     * deserializes data from XML
     * @param fileName name of file to read data
     * @return deserialized ArrayList of ArrayLists of ObjectCreator objects
     * @throws DataLayerException
     */
    @Override
    public ArrayList<ArrayList<ObjectCreator>> Deserialize(String fileName) throws DataLayerException {
       try {
           XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
           ArrayList<ArrayList<ObjectCreator>> data = (ArrayList<ArrayList<ObjectCreator>>)in.readObject();
           in.close();
           return data;
        }
        catch (IOException e) {
            throw new DataLayerException(e);
        }
        //return null;
    }
}
