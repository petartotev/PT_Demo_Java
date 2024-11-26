package IoEuropaGanymedeCallisto;

import java.io.*;

public class SerializationExample {
    public static void serialize(Object object, String fileName) throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            out.writeObject(object);
        }
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            return in.readObject();
        }
    }
}
