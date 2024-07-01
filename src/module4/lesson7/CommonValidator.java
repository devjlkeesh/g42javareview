package module4.lesson7;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonValidator {

    public static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\+(998)(20|22|33|50|71|77|90|94)(\\d{7})$");

    public static void main(String[] args) {
        String[] testCases  = {
          "+998339409797",
          "+998907777777",
          "+998207777777",
          "+998217777777",
          "+998207777777salom",
        };
        for (String testCase : testCases) {
            System.out.println(isValidPhone(testCase));
        }
    }


    public static boolean isValidPhone(String phone) {
        Objects.requireNonNull(phone, "input can not be null");
        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(phone);
        return matcher.matches();
    }

}
