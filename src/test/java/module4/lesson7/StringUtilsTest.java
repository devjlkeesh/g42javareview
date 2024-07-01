package module4.lesson7;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class StringUtilsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/phone_numbers.csv", useHeadersInDisplayName = true)
    void validPhoneNumberTest(String phoneNumber, boolean result) {
        Assertions.assertEquals(result, StringUtils.isValidPhone(phoneNumber));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/email.csv", useHeadersInDisplayName = true)
    void validEmailTest(String phoneNumber, boolean result) {
        Assertions.assertEquals(result, StringUtils.isValidEmail(phoneNumber));
    }

}
