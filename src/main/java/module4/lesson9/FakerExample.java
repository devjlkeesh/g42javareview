package module4.lesson9;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import com.github.javafaker.Name;
import com.github.javafaker.PhoneNumber;

public class FakerExample {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Name name = faker.name();
        Internet internet = faker.internet();
        PhoneNumber phone = faker.phoneNumber();
        for (int i = 0; i < 1e5; i++) {
            String firstName = name.firstName();
            String lastName = name.lastName();
            String email = internet.emailAddress();
            String phoneNumber = phone.phoneNumber();
            User user = new User(firstName, lastName, email, phoneNumber);
            System.out.println("user = " + user);
        }
    }
}
