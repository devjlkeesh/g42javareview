package module5.lesson1;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x.intValue() + 2;
        System.out.println(f.apply(12));

    }
}
