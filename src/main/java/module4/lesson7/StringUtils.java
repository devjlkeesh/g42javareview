package module4.lesson7;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static final Pattern PHONE_NUMBER_PATTERN = Pattern
            .compile("^\\+(998)(2[02]|33|50|7[17]|9[^26])(\\d{7})$");

    public static final Pattern VALID_EMAIL_PATTERN = Pattern
            .compile("(\\w+)@([\\w-]+)\\.(\\w{2,4})");

    public static boolean isValidPhone(String phone) {
        Objects.requireNonNull(phone, "input can not be null");
        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(phone);
        return matcher.matches();
    }
      public static boolean isValidEmail(String email) {
        Objects.requireNonNull(email, "input can not be null");
        Matcher matcher = VALID_EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
