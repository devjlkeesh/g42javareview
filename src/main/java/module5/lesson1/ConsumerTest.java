package module5.lesson1;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );

        Consumer<Employee> printOnConsole = (System.out::println);
        Consumer<Employee> storeInDB = (e -> System.out.println(e.toString() + " saving database"));
        Consumer<Employee> priConsumerThenStoreInDB = printOnConsole.andThen(storeInDB);
        forEach(empList, priConsumerThenStoreInDB);
    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        int nullCount = 0;
        for (T t : list) {
            if (t != null) {
                consumer.accept(t);
            } else {
                nullCount++;
            }
        }
        System.out.printf("%d null entries count  in the list.\n", nullCount);
    }
}
