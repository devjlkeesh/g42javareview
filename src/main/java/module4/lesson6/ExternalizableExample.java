package module4.lesson6;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableExample {
    public static void main(String[] args) {

    }


    class User implements Externalizable {
        private String username;
        private String password;
        private int age;

        @Override
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeObject(username.toLowerCase());
            //objectOutput.writeObject(MD5.encrypt(password));
        }

        @Override
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            this.username = (String) objectInput.readObject();
            //this.password = (String) objectInput.readObject(MD5.decrypt(password));
        }
    }
}
