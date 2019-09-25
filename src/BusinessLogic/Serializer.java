package BusinessLogic;

import java.io.*;
import java.util.List;

public class Serializer<T> {
    public void Serialize(T objectForSerializing, String fileName) throws IOException {
        //создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // сохраняем в файл
        objectOutputStream.writeObject(objectForSerializing);
        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
    }

    public T Deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        T  deserializedObject = (T) objectInputStream.readObject();
        return deserializedObject;
    }
}
