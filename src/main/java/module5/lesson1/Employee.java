package module5.lesson1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
    private String name;
    private String country;
    private String position;
    private int age;
}
