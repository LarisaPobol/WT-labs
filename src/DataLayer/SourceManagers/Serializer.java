package dataLayer.sourceManagers;

import beans.ObjectCreator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * class for serializing and deserializing data in XML format
 */
public class Serializer implements ISerializer {
    /**
     * serializes data to XML
     * @param listToSerialize data to serialize
     * @param FileName name of file to save data
     * @throws DataLayerException
     */
    @Override
    public void serialize(List listToSerialize, String FileName) throws DataLayerException {
        XMLEncoder out = null;
        File file = new File(FileName);
        try {
            file.createNewFile();
            out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FileName)));
            out.writeObject(listToSerialize);

        } catch (IOException e) {
            throw new DataLayerException(e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * deserializes data from XML
     * @param fileName name of file to read data
     * @return deserialized ArrayList of ArrayLists of ObjectCreator objects
     * @throws DataLayerException
     */
    @Override
    public List deserialize(String fileName) throws DataLayerException {
        XMLDecoder in = null;
        try {
            in = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
            ArrayList<ArrayList<ObjectCreator>> data = (ArrayList<ArrayList<ObjectCreator>>) in.readObject();
            return data;
        } catch (IOException e) {
            throw new DataLayerException(e);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
