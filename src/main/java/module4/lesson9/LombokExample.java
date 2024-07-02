package module4.lesson9;

import lombok.*;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

import java.util.Objects;

//@Getter
//@Setter(value = AccessLevel.PRIVATE)
//@ToString(callSuper = true, /*of = {"a"}*/ exclude = {"a"})
//@EqualsAndHashCode(/*of = {"a"},*/ exclude = {"a"})
//@Value
@Log
//@Log4j
//@Log4j2
//@Slf4j
//@XSlf4j
public class LombokExample extends Object {
    private Objects a;
    private Objects b;

    public static void main(String[] args) {
        //val name = "Azamjon"; // final var
        User user = User.childBuilder()
                .b("33rfds")
                .build();
        System.out.println("user = " + user);
        log.info(user.toString());
        //@Cleanup var a = new FileInputStream("asd");
    }
}
