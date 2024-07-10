package module4;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GsonTest {

    @Test
    void snake_case_test() {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        String userAsJson = gson.toJson(new User("Jahongir", "Jahongir"));
        System.out.println(userAsJson);
        assertThat(userAsJson).contains("user_name");
        assertThat(userAsJson).contains("first_name");
    }

    static class User {
        String userName;
        String firstName;

        public User(String userName, String firstName) {
            this.userName = userName;
            this.firstName = firstName;
        }
    }

}
