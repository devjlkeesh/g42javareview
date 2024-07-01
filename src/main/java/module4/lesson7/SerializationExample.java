package module4.lesson7;

import java.io.*;

public class SerializationExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputStream ous = new FileOutputStream("file.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(ous);
        Singleton instance = Singleton.getInstance();
        System.out.println(System.identityHashCode(instance));
        objectOutputStream.writeObject(instance);
        InputStream is = new FileInputStream("file.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        Singleton instance2 = (Singleton) objectInputStream.readObject();
        System.out.println(System.identityHashCode(instance2));
    }

}

class Singleton implements Serializable {
    private static final Singleton SINGLETON = new Singleton();


    public static Singleton getInstance() {
        return SINGLETON;
    }

    protected Object readResolve() {
        return getInstance();
    }
}

